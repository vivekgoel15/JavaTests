package com.test.searching;

/**
 * See more at:
 * http://www.java2novice.com/java-search-algorithms/linear-search/#sthash.qwzpjiRl.dpuf
 * 
 * @author vigoel
 *
 */
public class LinearSearch {

	public static int linerSearch(int[] arr, int key) {

		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String a[]) {

		int[] arr1 = { 23, 45, 21, 55, 234, 1, 34, 90 };
		int searchKey = 34;
		System.out.println("Key " + searchKey + " found at index: " + linerSearch(arr1, searchKey));
	}
}
