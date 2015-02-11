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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.compiler.SchemaGenerator;
import com.expedia.tesla.compiler.Util;

/**
 * Generate Tesla schema from Java by reflection.
 */
@Mojo(name = "gentml", defaultPhase = LifecyclePhase.GENERATE_RESOURCES, 
requiresDependencyResolution = ResolutionScope.COMPILE, 
requiresDependencyCollection = ResolutionScope.COMPILE)
public class GenerateSchemaMojo extends AbstractMojo
{
	@Parameter(defaultValue = "${project}", required = true, readonly = true)
	private MavenProject project;
	
	@Parameter
	private Collection<String> classes;
	
	@Parameter
	private TmlVersionInfo schemaVersion;
	
	@Parameter
	private File outputTml;
	
	@Parameter
	private String classpath = "";
	
    public void execute() throws MojoExecutionException
    {
    	Log log = getLog();
    	try {
    		classpath += StringUtils.join(project.getCompileClasspathElements(),
    				System.getProperty("path.separator"));
		} catch (DependencyResolutionRequiredException e) {
			throw new MojoExecutionException("Failed to resolve project dependencies: " 
					+ e.getMessage(), e);
		}
    	
    	if (outputTml == null) {
    		log.warn("Output is not set, using default value 'output.tml'.");
    		outputTml = new File("output.tml");
    	}
    	
    	log.info("Generating Tesla schema.");
    	log.debug(String.format("classpath: %s", classpath));
    	log.debug(String.format("Classes: %s", Arrays.toString(this.classes.toArray())));
    	log.debug(String.format("Schema version name: %s", schemaVersion.getName()));
    	log.debug(String.format("Schema version number: %s", schemaVersion.getVersionNumber()));
    	log.debug(String.format("Output: %s", outputTml));
    	OutputStream os = null;
    	try {
    		Util.forceMkdirParent(outputTml);
    		os = new FileOutputStream(outputTml);
			SchemaGenerator.genTml(classes, 
					new SchemaVersion(0L, schemaVersion.getVersionNumber(), 
							schemaVersion.getName(), null), 
					os, classpath);
		} catch (Exception e) {
			throw new MojoExecutionException("Failed to generate Tesla schema from Java.", e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
        log.info( "Generated Tesla schema successfully." );
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
