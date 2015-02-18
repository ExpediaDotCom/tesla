/*******************************************************************************
 * Copyright (c) 2014 Expedia Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

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
	
	public static final String LANG_JAVA = "java";
	public static final String LANG_CPP = "cpp";
	public static final String LANG_CSHARP = "csharp";
	private static final Map<String, String> LANG_ALIAS = new HashMap<>();
	
	@Parameter(names={"-l", "--language"}, description="The output code language (Java, C# or C++).")
	private String language = LANG_JAVA;
	
	@Parameter(names={"-s", "--serializer"}, description="The full name the generated serializer class name " +
			"(e.g. com.expedia.sample.AppSchema). Or C++ header file name without extension name.")
	private String appSchemaClassName = null;
	
	@Parameter(names={"-o", "--output-dir"}, description="The output directory. Output to current directory by default.")
	private File outputDir = new File(System.getProperty("user.dir"));
	
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
	
	@Parameter(names ={"-h", "--help"}, description="Show this help message.", help = true)
	private boolean help;
	
	static {
		LANG_ALIAS.put("java", LANG_JAVA);
		LANG_ALIAS.put("c++", LANG_CPP);
		LANG_ALIAS.put("cpp", LANG_CPP);
		LANG_ALIAS.put("csharp", LANG_CSHARP);
		LANG_ALIAS.put("cs", LANG_CSHARP);
		LANG_ALIAS.put("c#", LANG_CSHARP);
	}
	
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
	public File getOutputDir() {
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
	public Collection<String> getSchemaFiles() {
		return new ArrayList<String>(schemaFiles);
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
		this.language = LANG_ALIAS.get(language.toLowerCase());
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
	public void setOutputDir(File outputDir) {
		this.outputDir = outputDir;
	}
	
	/**
	 * Set the base output directory of the generated source code.
	 * 
	 * @param outputDir 
	 * 		the base output directory of the generated source code.
	 */
	public void setOutputDir(String outputDir) {
		setOutputDir(new File(outputDir));
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
		this.extension.clear();
		this.extension.putAll(extension);
	}

	/**
	 * Set input schema file paths.
	 * 
	 * @param schemaFiles
	 *  	the list of schema file paths.
	 */
	public void setSchemaFiles(Collection<String> schemaFiles) {
		this.schemaFiles.clear();
		this.schemaFiles.addAll(schemaFiles);
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
		System.out.println("Tesla compiled schema(s) successfully.");
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

			String path = getOutputPath(me.getName());
			try (Writer writer = new FileWriter(path)) {
				System.out.println("Writing source file " + path);
				te.merge(variables, writer);
			}
		}
	}

	private String getOutputPath(String fullName) throws IOException {
		int idx = fullName.lastIndexOf('.');
		String shortName = idx == -1 ? fullName : fullName.substring(idx+1);
		String fileName = shortName;
		switch (this.language) {
		case LANG_JAVA:
			fileName = fullName.replace('.', File.separatorChar) + ".java";
			break;
		case LANG_CSHARP:
			fileName += ".cs";
			break;
		case LANG_CPP:
			fileName += ".h";
			break;
		default:
			fileName += '.' + this.language;
			break;
		}
		File file = new File(FilenameUtils.concat(this.outputDir.getAbsolutePath(), fileName));
		Util.forceMkdirParent(file);
		return file.getAbsolutePath();
	}

	private void writeClasses(List<MergedClass> classes) throws Exception {
		TemplateEngine te = new TemplateEngine(this.language, this.classTemplatePath, "class.vm");
		for (MergedClass mc : classes) {
			Map<String, Object> variables = new TreeMap<String, Object>();
			variables.put("class", mc);
			variables.put("util", createUtilObject());
			variables.put("serializerName", this.appSchemaClassName);
			variables.putAll(loadExtension());
			
			String path = getOutputPath(mc.getName());
			try (Writer writer = new FileWriter(path)) {
				System.out.println("Writing source file " + path);
				te.merge(variables, writer);
			}
		}
	}

	private Object createUtilObject() {
		if (this.language.equals(LANG_JAVA)) {
			return new JavaUtils();
		} else if (this.language.equals(LANG_CPP)) {
			return new CppUtils();
		} else if (this.language.equals(LANG_CSHARP)) {
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

		String defaultTemplate = this.language.equals(LANG_JAVA) ? "serializer.vm"
				: "application_schema.vm";
		TemplateEngine te = new TemplateEngine(this.language, this.appSchemaTemplatePath, defaultTemplate);
		Map<String, Object> variables = new HashMap<>();
		variables.put("schemas", collection);
		variables.put("className", appSchemaClassShortName);
		variables.put("namespace", appSchemaClassNamespace);
		variables.put("util", createUtilObject());
		variables.put("mapper", new JavaTypeMapper());

		String path = getOutputPath(this.appSchemaClassName);
		try (Writer writer = new FileWriter(path)) {
			System.out.println("Writing source file " + path);
			te.merge(variables, writer);
			writer.flush();
		}
	}

	private MergedSchema mergeSchemas(Collection<String> values) throws TeslaSchemaException, IOException {
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
			if (compiler.help) {
				jc.usage();
			} else {
				compiler.compile();
			}
		} catch (ParameterException e) {
			System.err.printf("Error: %s\nUse -h or --help option to show usage help.\n", e.getMessage());
			System.exit(1);
		}
	}
	

}