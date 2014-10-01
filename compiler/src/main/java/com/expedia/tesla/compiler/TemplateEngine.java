/**
 *
 * TemplateEngine.java
 *
 * Copyright 2014 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.expedia.tesla.compiler;

import java.io.Writer;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * Velocity template engine wrapper.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class TemplateEngine {
	private String language;
	private String templatePath;
	private String defaultTemplate;

	/**
	 * Constructor.
	 * 
	 * @param language
	 *            programming language name of the generated source code.
	 * @param templatePath
	 *            template path.
	 * @param defaultTemplate
	 *            default template path.
	 */
	public TemplateEngine(String language, String templatePath,
			String defaultTemplate) {
		this.language = language;
		this.templatePath = templatePath;
		this.defaultTemplate = defaultTemplate;
	}

	/**
	 * Run template engine to generate source code.
	 * 
	 * @param variables
	 *            context variables.
	 * @param writer
	 *            text writer to write generated source code.
	 */
	public void merge(Map<String, Object> variables, Writer writer) {
		createTemplate(this.language, this.templatePath, this.defaultTemplate)
				.merge(createContext(variables), writer);
	}

	/**
	 * Create a template.
	 * 
	 * @param language
	 *            programming language name of the generated source code.
	 * @param templatePath
	 *            template path.
	 * @param defaultTemplate
	 *            default template path.
	 */
	protected Template createTemplate(String language, String templatePath,
			String defaultTemplate) {
		String defaultResourcePath = "resources/" + this.language + "/"
				+ defaultTemplate;
		if (templatePath == null || templatePath.isEmpty()) {
			templatePath = defaultResourcePath;
		}

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "file, classpath");
		ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		ve.init();

		try {
			return ve.getTemplate(templatePath);
		} catch (ResourceNotFoundException ex) {
			if (templatePath != defaultResourcePath) {
				return ve.getTemplate(defaultResourcePath);
			} else {
				throw ex;
			}
		}
	}

	/**
	 * Create a {@code VelocityContext} with variables.
	 * 
	 * @param variables
	 *            variables.
	 * @return {@code VelocityContext} with variables.
	 */
	protected VelocityContext createContext(Map<String, Object> variables) {
		VelocityContext context = new VelocityContext();
		if (variables != null) {
			for (String varName : variables.keySet()) {
				context.put(varName, variables.get(varName));
			}
		}
		return context;
	}
}