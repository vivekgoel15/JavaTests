package com.test.searching;

/**
 * Binary search using recursion.
 * 
 * @author vigoel
 *
 */
public class RecursiveBinarySearch {

	public static void main(String[] args) {

		int[] arr1 = { 2, 45, 234, 567, 876, 900, 976, 999 };

		int index = recursiveBinarySearch(arr1, 0, arr1.length, 900);
		System.out.println("Found 900 at " + index + " index");
	}

	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {

		if (start < end) {
			int mid = start + (end - start) / 2;
			if (key < sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, start, mid, key);
			} else if (key > sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, mid + 1, end, key);
			} else {
				return mid;
			}
		}
		return -(start + 1);
	}
}