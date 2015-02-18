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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.compiler.SchemaGenerator;
import com.expedia.tesla.compiler.Util;

/**
 * Ant task that generates Tesla schema from Java by reflection.
 */
public class GenerateSchemaAntTask extends Task
{
	private Collection<String> classes = new HashSet<>();
	private Version schemaVersion;
	private File outputTml;
	private String classpath = "";

	/**
	 * Get the list of full qualified class names that used to generate Tesla schema.
	 * 
	 * @return
	 * 		a collection of class name strings.
	 */
	public Collection<String> getClasses() {
		return classes;
	}

	/**
	 * Add a full qualified class which we will generate Tesla schema.
	 *  
	 * @param className
	 * 		a full qualified class name
	 */
	public void addConfiguredClass(Class clss) {
		this.classes.add(clss.getName());
	}

	/**
	 * Get the version info of the generated schema.
	 * 
	 * @return
	 * 		the version information
	 */
	public Version getVersion() {
		return schemaVersion;
	}

	/**
	 * Set the schema version information includes version name and optionally version number.
	 * 
	 * @param schemaVersion
	 * 		the schema version info
	 */
	public void addConfiguredVersion(Version schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	/**
	 * Get the output Tesla schema file path.
	 * 
	 * @return
	 * 		the output Tesla schema file path.
	 */
	public File getOutputTml() {
		return outputTml;
	}

	/**
	 * Set the output Tesla schema file path.
	 * 
	 * @param outputTml
	 * 		the output Tesla schema file path.
	 */
	public void setOutputTml(File outputTml) {
		this.outputTml = outputTml;
	}

	/**
	 * Get the classpath that defines the user classes.
	 * 
	 * @return
	 * 		the classpath that defines the user classes
	 */
	public String getClasspath() {
		return classpath;
	}

	/**
	 * Set the classpath that defines the user classes. Tesla will try to load user classes from this classpath.
	 * 
	 * @param classpath
	 * 		the classpath that defines the user classes
	 */
	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}
	
	/**
	 * Invoke Tesla schema generator to generate Tesla schema from Java.
	 */
	@Override
	public void execute()
    {
    	if (outputTml == null) {
    		log("Output is not set, using default value 'output.tml'.");
    		outputTml = new File("output.tml");
    	}
    	
    	log("Generating Tesla schema.");
    	log(String.format("classpath: %s", classpath));
    	log(String.format("Classes: %s", Arrays.toString(this.classes.toArray())));
    	log(String.format("Schema version name: %s", schemaVersion.getName()));
    	log(String.format("Schema version number: %s", schemaVersion.getNumber()));
    	log(String.format("Output: %s", outputTml));
    	OutputStream os = null;
    	try {
    		Util.forceMkdirParent(outputTml);
    		os = new FileOutputStream(outputTml);
			SchemaGenerator.genTml(classes, 
					new SchemaVersion(0L, schemaVersion.getNumber(), 
							schemaVersion.getName(), null), 
					os, classpath);
		} catch (Exception e) {
			throw new BuildException("Failed to generate Tesla schema from Java.", e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
        log( "Generated Tesla schema successfully." );
    }
	
	public static class Class {
		private String name;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
    
    public static class Version {
    	private int number;
    	private String name;
    	
		public int getNumber() {
			return number;
		}
		public void setNumber(int versionNumber) {
			this.number = versionNumber;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
    }

}
