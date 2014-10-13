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
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.expedia.tesla.schema.Schema;
import com.expedia.tesla.schema.UserType;

/**
 * Tesla compiler utility methods.
 * 
 * @author <a href="mailto:yzuo@expedia.com">Yunfei Zuo</a>
 */
public class Util {
	/**
	 * Convert a list of elements to a single comma separated string.
	 * 
	 * @param list
	 * 		the collection of values to join together.
	 * 
	 * @return
	 * 		a single comma separated string.
	 */
	public static <T> String commaSeparate(Collection<T> list) {
		return delimiterSeparate(list, ", ");
	}

	/**
	 * Convert a list of elements to a single delimiter separated string.
	 * 
	 * @param list
	 * 		the collection of values to join together.
	 * @param delimiter
	 * 		the delimiter that separates values.
	 * 
	 * @return
	 * 		a single delimiter separated string.
	 */
	public static <T> String delimiterSeparate(Collection<T> list, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (T e : list) {
			if (sb.length() > 0) {
				sb.append(delimiter);
			}
			sb.append(e.toString());
		}
		return sb.toString();
	}

	/**
	 * Make the first character lower case. 
	 * <p>
	 * The input string must at least has 2 characters.
	 * 
	 * @param s
	 * 		the input string value.
	 * @return
	 * 		the string with first character lower case.
	 */
	public static String firstCharLowerCase(String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	/**
	 * Make the first character upper case. 
	 * <p>
	 * The input string must at least has 2 characters.
	 * 
	 * @param s
	 * 		the input string value.
	 * @return
	 * 		the string with first character upper case.
	 */
	public static String firstCharUpperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * Extract short name from a full qualified type name.
	 * <p>
	 * The full name has the format of {@code namespace.typename}. 
	 * 
	 * @param fullName
	 * 		full type name.
	 * 
	 * @return
	 * 		short name.
	 */
	public static String toShortName(String fullName) {
		return UserType.toShortName(fullName);
	}

	/**
	 * Extract name space from a full qualified type name.
	 * <p>
	 * The full name has the format of {@code namespace.typename}. 
	 * 
	 * @param fullName
	 * 		full type name.
	 * 
	 * @return
	 * 		name space.
	 */
	public static String toNameSpace(String fullName) {
		return UserType.toNameSpace(fullName);
	}

	/**
	 * Get a new line character.
	 * 
	 * @return
	 * 		a new line character.
	 */
	public static String getNewLine() {
		return "\n";
	}

	/**
	 * Get a set of all user types defined in all schemas. It's the union of all
	 * user type definitions.
	 * 
	 * @param schemas
	 *            A collection of Tesla schema objects.
	 * @return A set of all user types defined in all schemas
	 */
	public static Collection<UserType> getAllUserTypes(Collection<Schema> schemas) {
		Map<String, UserType> all = new TreeMap<String, UserType>();
		for (Schema schema : schemas) {
			for (UserType t : schema.getUserTypes()) {
				all.put(t.getName(), t);
			}
		}
		return all.values();
	}
	
	/**
	 * Expand glob file patterns to path strings. Any path element that is not a glob pattern will be keep as it is.
	 * 
	 * @param pathOrPatterns
	 * 		glob patterns.
	 * 
	 * @return
	 * 		The expanded paths.
	 * 
	 * @throws IOException
	 * 		On IO errors.
	 */
	public static Collection<String> expandWildcard(Collection<String> pathOrPatterns) throws IOException {
		final List<String> files = new ArrayList<String>();
		final List<PathMatcher> matchers = new ArrayList<PathMatcher>();
		for (String pattern : pathOrPatterns) {
			if (pattern.contains("*") || pattern.contains("?")) {
				PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
				matchers.add(matcher);
			} else {
				files.add(pattern);
			}
		}
		
		if (!matchers.isEmpty()) {
			Files.walkFileTree(new File(System.getProperty("user.dir")).toPath(), new SimpleFileVisitor<Path>() {
				@Override
			    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
					for (PathMatcher matcher : matchers) {
						if (matcher.matches(file)) {
							files.add(file.toString());
						}
					}
					return FileVisitResult.CONTINUE;
				}
			});
		}
		
		return files;
	}
	
	/**
	 * Parse a Java {@code classpath} string to URLs. The {@code classpath} is represented with the same format of the 
	 * {@code CLASSPATH} variable or {@code -cp} java option. It supports the {@code *} wildcard.
	 * 
	 * @param classpath
	 * 		the classpath string.
	 * @return
	 * 		URLs.
	 * 
	 * @throws IOException
	 * 		on IO errors.
	 */
	public static URL[] parseClassPath(String classpath) throws IOException {
		final String splitPattern = Character.toString(File.pathSeparatorChar);
		final String wildcardPattern = ".+\\*";
		String[] paths = classpath.split(splitPattern);
		List<URL> urls = new ArrayList<URL>();
		for (String path : paths) {
			path = path.trim();
			if (path.matches(wildcardPattern)) {
				File folder = new File(path.replace("\\*", ""));
				if (folder.exists()) {
					File[] files = folder.listFiles();
					for (File f : files) {
						urls.add(f.toURI().toURL());
					}
				}
			} else {
				urls.add(new File(path).toURI().toURL());
			}
		}
		URL[] result = new URL[urls.size()];
		return urls.toArray(result);
	}

	/**
	 * Load a Java class by it's full name.
	 * 
	 * @param name
	 *            The full name of the Java class to load.
	 * @param classpath
	 *            The class paths or jar files from where the Java class be
	 *            loaded. If this is null or empty string. {@code loadClass}
	 *            will try to load from JVM classpath instead.
	 * @return The java.lang.Class object represents the Java class.
	 * @throws ClassNotFoundException
	 *             If the class is not found.
	 * @throws IOException
	 *             If the jar file cannot open.
	 */
	public static java.lang.Class<?> loadClass(String name, String classpath)
			throws ClassNotFoundException, IOException {
		return loadClass(name, (classpath == null || classpath.isEmpty()) ? null
						: parseClassPath(classpath));
	}

	/**
	 * Load a Java class by it's full name.
	 * 
	 * @param name
	 *            The full name of the Java class to load.
	 * @param urls
	 *            An array of URL objects represent class paths or jar files.
	 * @return The java.lang.Class object represents the Java class.
	 * @throws ClassNotFoundException
	 *             If the class is not found.
	 * @throws IOException
	 *             If the jar file cannot open.
	 */
	public static java.lang.Class<?> loadClass(String name, URL[] urls)
			throws ClassNotFoundException, IOException {
		java.lang.Class<?> clzz = null;
		if (urls != null && urls.length > 0) {
			URLClassLoader cl = URLClassLoader.newInstance(urls);
			clzz = cl.loadClass(name);
		}

		if (clzz == null) {
			clzz = Class.forName(name);
		}

		return clzz;
	}


}
