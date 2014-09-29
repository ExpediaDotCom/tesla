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
	private String language = "java";
	
	@Parameter(names={"-s", "--serializer"}, description="The full name the generated serializer class name " +
			"(e.g. com.expedia.sample.AppSchema). Or C++ header file name without extension name.")
	private String appSchemaClassName = null;
	
	@Parameter(names={"-o", "--output-dir"}, description="The output directory. Output to current directory by default.")
	private String outputDir = System.getProperty("user.dir");
	
	@Parameter(names={"-c", "--class-template"}, description="User class source code template.")
	private String classTemplatePath;
	
	@Parameter(names={"-m", "--enum-template"}, description="User enum source code template.")
	private String enumTemplatePath;
	
	@Parameter(names={"-v", "--serializer-template"}, description="User serializer source code template.")
	private String appSchemaTemplatePath;
	
	@Parameter(names={"-nu", "--not-generate-user-types"}, description="Not generate source code for user types.")
	private boolean notGenerateUserTypes;
	
	@Parameter(names={"-E", "--plugin"}, description="Create a plugin object of type <class_name> with " +
			"<variable_name>. The plugin object will be available in template enginees, and can be refered by " +
			"variable $variable_name.")
	private Map<String, String> extension = new HashMap<>();
	
	@Parameter(description="Tesla schema files (TMLs).", required=true)
	private List<String> schemaFiles = new ArrayList<>();
	
	@Parameter(names={"-cp", "-classpath"}, 
			description = "Java classpath that compiler will search for user classes.")
	private String classpath;
	
	/**
	 * Constructor.
	 */
	public Compiler() {
	}

	/**
	 * Get the name of programming language we are generation source code.
	 * 
	 * @return the name of programming language we are generation source code.
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Get the full name the generated serializer class name.
	 * 
	 * @return the full name the generated serializer class name. 
	 */
	public String getAppSchemaClassName() {
		return appSchemaClassName;
	}

	/**
	 * Get the base output directory of the generated source code.
	 *  
	 * @return the base output directory of the generated source code.
	 */
	public String getOutputDir() {
		return outputDir;
	}

	/**
	 * Get the user class source code template.
	 * 
	 * @return the user class source code template.
	 */
	public String getClassTemplatePath() {
		return classTemplatePath;
	}

	/**
	 * Get the user enum source code template.
	 * 
	 * @return the user enum source code template.
	 */
	public String getEnumTemplatePath() {
		return enumTemplatePath;
	}

	/**
	 * Get the path of user serializer source code template.
	 * 
	 * @return the path of user serializer source code template.
	 */
	public String getAppSchemaTemplatePath() {
		return appSchemaTemplatePath;
	}

	/**
	 * Check if it is configured to not generate source code for user types.
	 * 
	 * @return ture if it is configured to not generate source code for user types. Otherwise, return false.
	 */
	public boolean isNotGenerateUserTypes() {
		return notGenerateUserTypes;
	}

	/**
	 * Get user extensions. The keys are extension names while the values are full class names of the extensions.
	 *  
	 * @return the user extensions.
	 */
	public Map<String, String> getExtension() {
		return extension;
	}

	/**
	 * Get the list of schema file paths.
	 *
	 * @return the paths of schema files.
	 */
	public List<String> getSchemaFiles() {
		return schemaFiles;
	}

	/**
	 * Get the classpath where compiler load Java classes for user extensions.
	 * 
	 * @return the Java the classpath where compiler load Java classes for user extensions.
	 */
	public String getClasspath() {
		return classpath;
	}

	/**
	 * Set the name of programming language we are generation source code
	 * 
	 * @param language the name of programming language we are generation source code
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Set the full name the generated serializer class name.
	 * 
	 * @param appSchemaClassName 
	 * 		the full name the generated serializer class name.
	 */
	public void setAppSchemaClassName(String appSchemaClassName) {
		this.appSchemaClassName = appSchemaClassName;
	}

	/**
	 * Set the base output directory of the generated source code.
	 * 
	 * @param outputDir 
	 * 		the base output directory of the generated source code.
	 */
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	/**
	 * Set the user class source code template.
	 * 
	 * @param classTemplatePath 
	 * 		the user class source code template.
	 */
	public void setClassTemplatePath(String classTemplatePath) {
		this.classTemplatePath = classTemplatePath;
	}

	/**
	 * Set the user enum source code template.
	 * 
	 * @param enumTemplatePath 
	 * 		the user enum source code template.
	 */
	public void setEnumTemplatePath(String enumTemplatePath) {
		this.enumTemplatePath = enumTemplatePath;
	}

	/**
	 * Set the path of user serializer source code template.
	 * 
	 * @param appSchemaTemplatePath 
	 * 		the path of user serializer source code template.
	 */
	public void setAppSchemaTemplatePath(String appSchemaTemplatePath) {
		this.appSchemaTemplatePath = appSchemaTemplatePath;
	}

	/**
	 * Configure compiler to not generate source code for user types. 
	 * <p>
	 * This is {@code false} by default.
	 * 
	 * @param notGenerateUserTypes
	 * 		set this to {@code true} for partial code generation which doesn't generate source code for user 
	 * 		classes and enums. 
	 */
	public void setNotGenerateUserTypes(boolean notGenerateUserTypes) {
		this.notGenerateUserTypes = notGenerateUserTypes;
	}

	/**
	 * Set user extensions. 
	 * <p>
	 * The keys are extension names while the values are full class names of the extensions.
	 * 
	 * @param extension 
	 * 		the extension to set
	 */
	public void setExtension(Map<String, String> extension) {
		this.extension = extension;
	}

	/**
	 * Set input schema file paths.
	 * 
	 * @param schemaFiles
	 *  	the list of schema file paths.
	 */
	public void setSchemaFiles(List<String> schemaFiles) {
		this.schemaFiles = schemaFiles;
	}

	/**
	 * Set the classpath where compiler load Java classes for user extensions. 
	 * <p>
	 * Tesla compiler will search for user extensions from both system class path and class paths specified here.
	 * 
	 * @param classpath 
	 * 		the Java classpath where compiler load Java classes for user extensions.
	 */
	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}

	/**
	 * Merge Tesla schemas and generate source code use the current settings. 
	 * @throws Exception
	 */
	public void compile() throws Exception {
		MergedSchema ms = mergeSchemas(schemaFiles);
		if (!this.notGenerateUserTypes) {
			writeClasses(ms.getClasses());
			writeEnums(ms.getEnumes());
		}
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