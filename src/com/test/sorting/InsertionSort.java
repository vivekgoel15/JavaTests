package com.test.sorting;

/**
 * Insertion sort iterates through the list by consuming one input element at
 * each repetition, and growing a sorted output list. On a repetition, insertion
 * sort removes one element from the input data, finds the location it belongs
 * within the sorted list, and inserts it there. It repeats until no input
 * elements remain. - See more at:
 * http://www.java2novice.com/java-sorting-algorithms/insertion-sort/#sthash.HbDOkEsD.dpuf
 * 
 * @author vigoel
 *
 */
public class InsertionSort {

	public static void main(String a[]) {
		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr2 = doInsertionSort(arr1);
		for (int i : arr2) {
			System.out.print(i);
			System.out.print(", ");
		}
	}

	public static int[] doInsertionSort(int[] input) {
		int temp;
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
		return input;
	}
}
