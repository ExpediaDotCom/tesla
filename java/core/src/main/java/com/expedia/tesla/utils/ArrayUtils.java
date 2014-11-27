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
package com.expedia.tesla.utils;

/**
 * Helper methods for array/list access
 *
 * @author Yunfei Zuo (yzuo@expedia.com)
 * 
 */
public class ArrayUtils {
	
	public static <T> T get(java.util.List<T> v, int i) {
		return v.get(i);
	}

	public static <T> T get(T[] v, int i) {
		return v[i];
	}

	public static byte get(byte[] v, int i) {
		return v[i];
	}

	public static short get(short[] v, int i) {
		return v[i];
	}

	public static int get(int[] v, int i) {
		return v[i];
	}

	public static long get(long[] v, int i) {
		return v[i];
	}

	public static float get(float[] v, int i) {
		return v[i];
	}

	public static double get(double[] v, int i) {
		return v[i];
	}

	public static boolean get(boolean[] v, int i) {
		return v[i];
	}

	public static <T> int size(java.util.List<T> v) {
		return v.size();
	}

	public static <T> int size(T[] v) {
		return v.length;
	}

	public static int size(byte[] v) {
		return v.length;
	}

	public static int size(short[] v) {
		return v.length;
	}

	public static int size(int[] v) {
		return v.length;
	}

	public static int size(long[] v) {
		return v.length;
	}

	public static int size(float[] v) {
		return v.length;
	}

	public static int size(double[] v) {
		return v.length;
	}

	public static int size(boolean[] v) {
		return v.length;
	}
}
