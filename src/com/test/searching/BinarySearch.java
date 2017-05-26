package com.test.searching;

/**
 * 
 * @author vigoel
 *
 */
public class BinarySearch {

	public static void main(String[] args) {

		BinarySearch mbs = new BinarySearch();
		int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };
		System.out.println("Key 14's position: " + mbs.binarySearch(arr, 14));
	}

	public int binarySearch(int[] inputArr, int key) {

		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
