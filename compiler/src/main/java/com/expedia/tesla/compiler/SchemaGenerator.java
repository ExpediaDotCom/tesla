/**
 *
 * SchemaGenerator.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
	@Parameter(description = "Output TML file path", required = true, converter = FileConverter.class)
	private File output;
	
	@Parameter(names={"-c", "-class"}, 
			description = "Generate schema (TML file) from the user class definition by java reflection. The " +
					"compiler will load the class by name and generate Tesla fields for all public properties " +
					"by default. Please use -classpath option to specify the search path for your class, or put " +
					"them in JVM classpath.",
			required = true)
	private List<String> genTmlRootClasses;
	
	@Parameter(names={"-cp", "-classpath"}, 
			description = "Java classpath that compiler will search for user classes.")
	String classpath;
	
	@Parameter(names={"-ver", "-schemaversion"},
			description = "Specify a schema version name and (or) version number for the generated schema. " +
					"Version name is required while version number is option. For more information about Tesla " +
					"schema version, please refer Tesla documentation or specification. Sample: -ver name="+
					"Abc Service v2.5.1,number=6",
			required = true,
			converter = SchemaVersionConverter.class)
	SchemaVersion schemaVersion;

	@Parameter(names = "--help", help = true)
	private boolean help;

	/**
	 * Constructor. 
	 */
	private SchemaGenerator() {
	}
	
	/**
	 * Constructor.
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
	 */
	public SchemaGenerator(List<String> classes, SchemaVersion schemaVersion, File output, String classpath) {
		this.genTmlRootClasses = classes;
		this.classpath = classpath;
		this.output = output;
		this.schemaVersion = schemaVersion;
	}

	/**
	 * Generate Tesla schema file (TML) from Java classes that follow Java Bean convention.
	 * @throws IOException 
	 * 		On IO errors.
	 * @throws TeslaSchemaException 
	 * 		On Tesla schema errors.
	 * @throws ClassNotFoundException 
	 * 		If the class is not found. 
	 * @throws JAXBException 
	 * 		When there is a JAXB error.
	 */
	public void genTml() throws IOException, TeslaSchemaException, ClassNotFoundException, JAXBException {
		JavaTypeMapper mapper = new JavaTypeMapper();
		Schema.SchemaBuilder schemaBuilder = new Schema.SchemaBuilder();
		schemaBuilder.setVersion(this.schemaVersion);

		for (String name : this.genTmlRootClasses) {
				java.lang.Class<?> clzz = Util.loadClass(name, this.classpath);
				mapper.fromJavaClass(schemaBuilder, clzz);
		}
		try (OutputStream os = new FileOutputStream(this.output)) {
			schemaBuilder.build().save(os);
		}
	}

	public static void main(String[] args) throws Exception {
		JCommander jc = null;
		try {
			SchemaGenerator sg = new SchemaGenerator();
			jc = new JCommander(sg);
			jc.parse(args);			
		} catch (ParameterException e) {
			jc.usage();
			throw e;
		} catch (Exception e) {
			System.err.printf("Error: %s\n", e.getMessage());
			throw e;
		}
	}
	
	private class FileConverter implements IStringConverter<File> {
		@Override
		public File convert(String value) {
			return new File(value);
		}
	}
	
	private class SchemaVersionConverter implements IStringConverter<SchemaVersion> {
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
}