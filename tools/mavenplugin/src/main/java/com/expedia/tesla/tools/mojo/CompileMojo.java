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

package com.expedia.tesla.tools.mojo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.model.FileSet;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.FileUtils;

import com.expedia.tesla.compiler.Compiler;

/**
 * Invoke Tesla compiler to generate source code from Tesla schema files (TML).
 */
@Mojo(name = "gensrc", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class CompileMojo extends AbstractMojo {
	@Parameter(defaultValue = "java", required = true)
	private String language;

	@Parameter(required = true)
	private File outputDir;

	@Parameter(required = true)
	private String serializerClassName;

	@Parameter
	private File serializerTemplate;

	@Parameter(defaultValue = "false", required = true)
	private boolean generateTypes;

	@Parameter
	private File classTemplate;

	@Parameter
	private File enumTemplate;

	@Parameter
	private Map<String, String> extension = new HashMap<String, String>();

	@Parameter(required = true)
	private List<FileSet> tmls = new ArrayList<FileSet>();

	@Parameter(defaultValue="${project}", readonly=true, required=true)
	private MavenProject project;
	
	@Override
	public void execute() throws MojoExecutionException {
		Log log = getLog();

		log.info("Generating source code from Tesla schemas.");
		log.debug(String.format("language: %s", language));
		log.debug(String.format("outputDir: %s", outputDir));
		log.debug(String.format("classTemplate: %s", classTemplate));
		log.debug(String.format("enumTemplate: %s", enumTemplate));
		log.debug(String.format("serializerTemplate: %s", serializerTemplate));
		log.debug(String.format("generateTypes: %s", generateTypes ? "yes" : "no"));
		PrintStream os = new PrintStream(new ByteArrayOutputStream());
		MapUtils.debugPrint(os, null, extension);
		log.debug(String.format("extension: %s", os.toString()));
		try {
			Compiler compiler = new Compiler();
			compiler.setLanguage(language);
			compiler.setOutputDir(outputDir);
			compiler.setAppSchemaClassName(serializerClassName);
			if (serializerTemplate != null) {
				compiler.setAppSchemaTemplatePath(serializerTemplate.getAbsolutePath());
			}
			compiler.setNotGenerateUserTypes(!generateTypes);
			if (classTemplate != null) {
				compiler.setClassTemplatePath(classTemplate.getAbsolutePath());
			}
			if (enumTemplate != null) {
				compiler.setEnumTemplatePath(enumTemplate.getAbsolutePath());
			}
			compiler.setExtension(extension);
			compiler.setSchemaFiles(getTmlFiles());
			compiler.compile();
		} catch (Exception e) {
			throw new MojoExecutionException(
					"Failed to generate Tesla schema from Java.", e);
		}
		log.info("Generated source code from Tesla schemas successfully.");
	}
	
	private Set<String> getTmlFiles() throws IOException {
		Set<String> files = new HashSet<>();
		for (FileSet fileSet : tmls) {
			File directory = (fileSet.getDirectory() == null) ? 
					this.project.getBasedir() : new File(fileSet.getDirectory());
			String includes = StringUtils.join(fileSet.getIncludes(), ',');
            String excludes = StringUtils.join(fileSet.getExcludes(), ',');
            for (File file : FileUtils.getFiles(directory, includes, excludes)) {
            	files.add(file.getAbsolutePath());
            }
		}
		return files;
	}

	public static class TmlVersionInfo {
		private int versionNumber;
		private String name;

		public int getVersionNumber() {
			return versionNumber;
		}

		public void setVersionNumber(int versionNumber) {
			this.versionNumber = versionNumber;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
