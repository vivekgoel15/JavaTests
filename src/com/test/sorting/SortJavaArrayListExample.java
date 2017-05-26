package com.test.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author vigoel
 *
 */
public class SortJavaArrayListExample {

	public static void main(String[] args) {

		// create an ArrayList object
		ArrayList arrayList = new ArrayList();

		// Add elements to Arraylist
		arrayList.add("4");
		arrayList.add("3");
		arrayList.add("5");
		arrayList.add("2");
		arrayList.add("1");

		/*
		 * To sort an ArrayList object, use Collection.sort method. This is a
		 * static method. It sorts an ArrayList object's elements into ascending
		 * order.
		 */
		Collections.sort(arrayList);

		// display elements of ArrayList
		System.out.println("ArrayList elements after sorting in ascending order : ");
		for (int i = 0; i < arrayList.size(); i++)
			System.out.println(arrayList.get(i));

	}
}