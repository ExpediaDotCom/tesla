/**
 *
 * Compiler.java
 *
 * Copyright 2013 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FilenameUtils;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.expedia.tesla.compiler.plugins.CSharpUtils;
import com.expedia.tesla.compiler.plugins.CppUtils;
import com.expedia.tesla.compiler.plugins.JavaTypeMapper;
import com.expedia.tesla.compiler.plugins.JavaUtils;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.TeslaSchemaException;

/**
 * Telsa compiler compiles Tesla schema file (TML) into source code. This is the
 * entry point of the compiler tool.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class Compiler {
	
	@Parameter(names={"-l", "--language"}, description="The output code language (Java, C# or C++).")
	String language = "java";
	
	@Parameter(names={"-s", "--serializer"}, description="The full name the generated serializer class name " +
			"(e.g. com.expedia.sample.AppSchema). Or C++ header file name without extension name.")
	String appSchemaClassName = null;
	
	@Parameter(names={"-o", "--output-dir"}, description="The output directory. Output to current directory by default.")
	String outputDir = System.getProperty("user.dir");
	
	@Parameter(names={"-c", "--class-template"}, description="User class source code template.")
	String classTemplatePath;
	
	@Parameter(names={"-m", "--enum-template"}, description="User enum source code template.")
	String enumTemplatePath;
	
	@Parameter(names={"-v", "--serializer-template"}, description="User serializer source code template.")
	String appSchemaTemplatePath;
	
	@Parameter(names={"-E", "--plugin"}, description="Create a plugin object of type <class_name> with " +
			"<variable_name>. The plugin object will be available in template enginees, and can be refered by " +
			"variable $variable_name.")
	Map<String, String> extension = new HashMap<>();
	
	@Parameter(description="Tesla schema files (TMLs).", required=true)
	List<String> schemaFiles = new ArrayList<>();
	MergedSchema mergedSchema;
	
	@Parameter(names={"-cp", "-classpath"}, 
			description = "Java classpath that compiler will search for user classes.")
	String classpath;

	private void compile() throws Exception {
		MergedSchema ms = mergeSchemas(schemaFiles);
		writeClasses(ms.getClasses());
		writeEnums(ms.getEnumes());
		writeAppSchema(ms.getSchemas());
	}

	private Map<String, Object> loadExtension() throws Exception {
		Map<String, Object> variables = new HashMap<>();
		if (this.extension != null) {
			for (String varName : this.extension.keySet()) {
				String varClassName = this.extension.get(varName);
				java.lang.Class<?> clazz = java.lang.Class.forName(varClassName);
				variables.put(varName, clazz.newInstance());
			}
		}
		return variables;
	}

	private void writeEnums(List<MergedEnum> enums) throws Exception {
		TemplateEngine te = new TemplateEngine(this.language, this.enumTemplatePath, "enum.vm");
		for (MergedEnum me : enums) {
			Map<String, Object> variables = new TreeMap<String, Object>();
			variables.put("enum", me);
			variables.put("util", createUtilObject());
			variables.putAll(loadExtension());

			try (Writer writer = new FileWriter(getOutputPath(me.getName()))) {
				te.merge(variables, writer);
			}
		}
	}

	private String getOutputPath(String fullName) {
		String path = null;
		if (this.language.equals("java")) {
			path = FilenameUtils.concat(this.outputDir, fullName.replace('.', File.separatorChar)) + ".java";
		} else if (this.language.equals("csharp")) {
			String[] tmp = fullName.split("\\.");
			path = FilenameUtils.concat(this.outputDir, tmp[tmp.length - 1] + ".cs");
		} else if (this.language.equals("cpp")) {
			String[] tmp = fullName.split("\\.");
			path = FilenameUtils.concat(this.outputDir, tmp[tmp.length - 1] + ".h");
		}
		File dir = new File(path).getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return path;
	}

	private void writeClasses(List<MergedClass> classes) throws Exception {
		TemplateEngine te = new TemplateEngine(this.language, this.classTemplatePath, "class.vm");
		for (MergedClass mc : classes) {
			Map<String, Object> variables = new TreeMap<String, Object>();
			variables.put("class", mc);
			variables.put("util", createUtilObject());
			variables.put("serializerName", this.appSchemaClassName);
			variables.putAll(loadExtension());
			
			try (Writer writer = new FileWriter(getOutputPath(mc.getName()))) {
				te.merge(variables, writer);
			}
		}
	}

	private Object createUtilObject() {
		if (this.language.equals("java")) {
			return new JavaUtils();
		} else if (this.language.equals("cpp")) {
			return new CppUtils();
		} else if (this.language.equals("csharp")) {
			return new CSharpUtils();
		}
		return null;
	}

	private void writeAppSchema(Collection<Schema> collection) throws IOException {
		if (this.appSchemaClassName == null
				|| this.appSchemaClassName.isEmpty()) {
			return;
		}

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		ve.init();

		String appSchemaClassShortName = this.appSchemaClassName;
		String appSchemaClassNamespace = null;
		if (this.appSchemaClassName.matches(".+\\..+")) {
			int pos = this.appSchemaClassName.lastIndexOf('.');
			appSchemaClassShortName = this.appSchemaClassName.substring(pos + 1);
			appSchemaClassNamespace = this.appSchemaClassName.substring(0, pos);
		}

		String defaultTemplate = this.language.equals("java") ? "serializer.vm"
				: "application_schema.vm";
		TemplateEngine te = new TemplateEngine(this.language, this.appSchemaTemplatePath, defaultTemplate);
		Map<String, Object> variables = new HashMap<>();
		variables.put("schemas", collection);
		variables.put("className", appSchemaClassShortName);
		variables.put("namespace", appSchemaClassNamespace);
		variables.put("util", createUtilObject());
		variables.put("mapper", new JavaTypeMapper());

		try (Writer writer = new FileWriter(getOutputPath(this.appSchemaClassName))) {
			te.merge(variables, writer);
			writer.flush();
		}
	}

	private MergedSchema mergeSchemas(List<String> values) throws TeslaSchemaException, IOException {
		List<Schema> schemas = new ArrayList<>();
		for (String path : Util.expandWildcard(values)) {
			schemas.add(Schema.build(path));
		}
		return new MergedSchema(schemas);
	}

	public static void main(String[] args) throws Exception {
		JCommander jc = null;
		try {
			Compiler compiler = new Compiler();
			jc = new JCommander(compiler);
			jc.parse(args);
			compiler.compile();
		} catch (ParameterException e) {
			jc.usage();
			throw e;
		} catch (Exception e) {
			System.err.printf("Error: %s\n", e.getMessage());
			throw e;
		}
	}
	

}