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

package com.expedia.tesla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import com.expedia.tesla.compiler.Compiler;

/**
 * Invoke Tesla compiler to generate source code from Tesla schema files (TML).
 */
@Mojo(name = "gensrc", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class CompileMojo extends AbstractMojo {
	@Parameter(defaultValue = "java", required = true)
	private String language;

	@Parameter(required = true)
	private String outputDir;

	@Parameter(required = true)
	private String serializerClassName;

	@Parameter
	private String serializerTemplate;

	@Parameter(defaultValue = "false", required = true)
	private boolean generateTypes;

	@Parameter
	private String classTemplate;

	@Parameter
	private String enumTemplate;

	@Parameter
	private Map<String, String> extension = new HashMap<String, String>();

	@Parameter(required = true)
	private List<String> tmls = new ArrayList<String>();

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
			compiler.setAppSchemaTemplatePath(serializerTemplate);
			compiler.setNotGenerateUserTypes(!generateTypes);
			compiler.setClassTemplatePath(classTemplate);
			compiler.setEnumTemplatePath(enumTemplate);
			compiler.setExtension(extension);
			compiler.setSchemaFiles(tmls);
			compiler.compile();
		} catch (Exception e) {
			throw new MojoExecutionException(
					"Failed to generate Tesla schema from Java.", e);
		}
		log.info("Generated source code from Tesla schemas successfully.");
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
