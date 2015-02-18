/*******************************************************************************
 * Copyright (c) 2015 Expedia Inc.
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

package com.expedia.tesla.tools.anttask;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

import com.expedia.tesla.compiler.Compiler;

/**
 * Ant task that invokes Tesla compiler to generate source code from Tesla schema files (TML).
 * 
 * @author Yunfei Zuo (yzuo@expedia.com)
 */
public class CompilerAntTask extends Task {
	
	private String language = "java";
	private File outputDir = new File(System.getProperty("user.dir"));
	private String serializerClassName;
	private String serializerTemplate;
	private boolean generateTypes = false;
	private String classTemplate;
	private String enumTemplate;
	
	private Map<String, String> extension = new HashMap<String, String>();
	private Set<String> tmls = new HashSet<String>();
	
    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public File getOutputDir() {
		return outputDir;
	}

	public void setOutputDir(File outputDir) {
		this.outputDir = outputDir;
	}

	public String getSerializer() {
		return serializerClassName;
	}

	public void setSerializer(String serializerClassName) {
		this.serializerClassName = serializerClassName;
	}

	public String getSerializerTemplate() {
		return serializerTemplate;
	}

	public void setSerializerTemplate(String serializerTemplate) {
		this.serializerTemplate = serializerTemplate;
	}

	public boolean isGenerateTypes() {
		return generateTypes;
	}

	public void setGenerateTypes(boolean generateTypes) {
		this.generateTypes = generateTypes;
	}

	public String getClassTemplate() {
		return classTemplate;
	}

	public void setClassTemplate(String classTemplate) {
		this.classTemplate = classTemplate;
	}

	public String getEnumTemplate() {
		return enumTemplate;
	}

	public void setEnumTemplate(String enumTemplate) {
		this.enumTemplate = enumTemplate;
	}

	public void addConfiguredExtension(Extension extension) {
		this.extension.put(extension.getName(), extension.getClassName());
	}

	public void addConfiguredFileSet(FileSet fileset) {
		DirectoryScanner ds = fileset.getDirectoryScanner(getProject());
		File dir = ds.getBasedir();
		String[] filesInSet = ds.getIncludedFiles();
		for (String filename : filesInSet) {
			tmls.add(new File(dir, filename).toString());
		}
	}
	
	public void execute() {
        log("language: " +  this.language);
        log("outputDir: " +  this.outputDir);
        log("serializer: " +  this.serializerClassName);
        log("serializerTemplate: " +  this.serializerTemplate == null ? this.serializerTemplate : "default template");
        log("generateTypes: " +  this.generateTypes );
        log("classTemplate: " +  this.classTemplate == null ? this.classTemplate : "default template");
        log("enumTemplate: " +  this.enumTemplate == null ? this.enumTemplate : "default template");
        log("generateTypes: " +  this.generateTypes);
        log(String.format("extensions: %s", Arrays.toString(extension.entrySet().toArray())));
        log(String.format("TMLs: %s", Arrays.toString(tmls.toArray())));
        
        try {
			Compiler compiler = new Compiler();
			compiler.setLanguage(language);
			compiler.setOutputDir(outputDir.toString());
			compiler.setAppSchemaClassName(serializerClassName);
			compiler.setAppSchemaTemplatePath(serializerTemplate);
			compiler.setNotGenerateUserTypes(!generateTypes);
			compiler.setClassTemplatePath(classTemplate);
			compiler.setEnumTemplatePath(enumTemplate);
			compiler.setExtension(extension);
			compiler.setSchemaFiles(new ArrayList<String>(tmls));
			compiler.compile();
		} catch (Exception e) {
			throw new BuildException(
					"Failed to generate source code from schema.", e);
		}
		log("Generated source code from Tesla schemas successfully.");
    }

	public static class Extension {
		private String name;
		private String className;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		} 
	}
}
