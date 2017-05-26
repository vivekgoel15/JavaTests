package com.test.sorting;

/**
 * 
 * @author vigoel
 *
 */
public class SelectionSort {

	public static int[] doSelectionSort(int[] arr) {

		int smallerNumber;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					smallerNumber = arr[i];
					arr[i] = arr[j];
					arr[j] = smallerNumber;
				}
			}
		}
		return arr;
	}

	public static void main(String a[]) {

		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr2 = doSelectionSort(arr1);
		for (int i : arr2) {
			System.out.println(i);
		}
	}
}