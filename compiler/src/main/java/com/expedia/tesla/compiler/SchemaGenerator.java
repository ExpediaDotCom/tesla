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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.expedia.tesla.SchemaVersion;
import com.expedia.tesla.compiler.plugins.JavaTypeMapper;
import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.TeslaSchemaException;

/**
 * Generates Tesla schema (TML) from existing Java source code. The Java source code must be compiled and can be loaded
 * by JVM. All Java classes need to follow Java Bean convention.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class SchemaGenerator {
	
	/**
	 * Generate Tesla schema file (TML) from Java classes that follow Java Bean convention.
	 * 
	 * @param classes
	 * 		The full names of classes that generate schema from.
	 * @param schemaVersion
	 * 		The version of generated schema.
	 * @param output
	 * 		The output schema file path.
	 * @param classpath
	 * 		The Java class path of the classes listed in parameter {@code classes}. Tesla compiler will search classes
	 * 		from both system class path and the class paths listed in this parameter.
	 * 
	 * @throws IOException 
	 * 		On IO errors.
	 * @throws TeslaSchemaException 
	 * 		On Tesla schema errors.
	 * @throws ClassNotFoundException 
	 * 		If the class is not found. 
	 * @throws JAXBException 
	 * 		When there is a JAXB error.
	 */
	public static void genTml(Collection<String> classes, SchemaVersion schemaVersion, OutputStream output, 
			String classpath) throws IOException, TeslaSchemaException, ClassNotFoundException, JAXBException {
		JavaTypeMapper mapper = new JavaTypeMapper();
		Schema.SchemaBuilder schemaBuilder = new Schema.SchemaBuilder();
		schemaBuilder.setVersion(schemaVersion);

		for (String name : classes) {
			java.lang.Class<?> clzz = Util.loadClass(name, classpath);
			mapper.fromJavaClass(schemaBuilder, clzz);
		}
		schemaBuilder.build().save(output);
	}
	
	private static class CommandLineParameters {
		@Parameter(description = "Output TML file path", required = true)
		private List<String> outputFiles = new ArrayList<>();
		
		@Parameter(names={"-rc", "--root-class"}, 
				description = "Generate schema (TML file) from the user class definition by java reflection. The " +
						"compiler will load the class by name and generate Tesla fields for all public properties " +
						"by default. Please use -classpath option to specify the search path for your class, or put " +
						"them in JVM classpath.",
				required = true)
		private List<String> rootClasses;
		
		@Parameter(names={"-cp", "-classpath"}, 
				description = "Java classpath that compiler will search for user classes.")
		private String classpath;
		
		@Parameter(names={"-ver", "--schema-version"},
				description = "Specify a schema version name and (or) version number for the generated schema. " +
						"Version name is required while version number is option. For more information about Tesla " +
						"schema version, please refer Tesla documentation or specification. Sample: -ver name="+
						"Abc Service v2.5.1,number=6",
				required = true,
				converter = SchemaVersionConverter.class)
		private SchemaVersion schemaVersion;
	
		@Parameter(names = "--help", help = true)
		private boolean help;
	}
	
	/**
	 * JCommander parameter converter that parses command line string to schema version. 
	 * 
	 * @author Yunfei Zuo (yzuo@expedia.com)
	 *
	 */
	public static class SchemaVersionConverter implements IStringConverter<SchemaVersion> {
		@Override
		public SchemaVersion convert(String value) {
			String name = null;
			int number = -1;
			String[] values = value.split(",");
			for (String v : values){
				String[] p = v.split("=");
				if (p.length != 2)
						throw new ParameterException("Invalid schema version: '" + value + "'");
				p[0] = p[0].trim();
				p[1] = p[1].trim();
				switch (p[0].toLowerCase()) {
				case "name":
					name = p[1];
					break;
				case "number":
					number = Integer.valueOf(number);
					break;
				default:
					throw new ParameterException("Invalid schema version: '" + value + "'");
				}
			}
			if (name == null) {
				throw new ParameterException("Invalid schema version: '" + value + "', must provide a version name.");
			}
				
			return new SchemaVersion(0L, number, name, null);
		}
	}

	public static void main(String[] args) throws Exception {
		JCommander jc = null;
		try {
			CommandLineParameters p = new CommandLineParameters();
			jc = new JCommander(p);
			jc.parse(args);
			if (p.help) {
				jc.usage();
				return;
			}
			try (OutputStream os = new FileOutputStream(p.outputFiles.get(0))) {
				genTml(p.rootClasses, p.schemaVersion, os, p.classpath);
			} catch (ClassNotFoundException e) {
				// ClassNotFoundException exception message only says the class name, add a little more information 
				// to report meaningful error message.
				throw new RuntimeException(String.format("Could not find class '%s'.", e.getMessage()), e);
			}
		} catch (Exception e) {
			System.err.printf("Error: %s\n", e.getMessage());
			System.exit(1);
		}
	}
}