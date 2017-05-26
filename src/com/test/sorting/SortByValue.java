package com.test.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Sort or order a HashMap or TreeSet or any map item by value. Write a
 * comparator which compares by value, not by key. Entry class might hleps you
 * here. - See more at:
 * http://www.java2novice.com/java-interview-programs/sort-a-map-by-value/#sthash.J6mixHa7.dpuf
 * 
 * @author vigoel
 *
 */
public class SortByValue {

	public static void main(String a[]) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Unix", 67);
		map.put("C++", 45);
		map.put("Java2Novice", 2);
		map.put("MAC", 26);
		map.put("java", 20);
		Set<Entry<String, Integer>> set = map.entrySet();

		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		System.out.println("Sorted by value:");
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}
	}
}
