package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Write a program to find out duplicate or repeated characters in a string, and
 * calculate the count of repeatation. - See more at:
 * http://www.java2novice.com/java-interview-programs/duplicate-string-character-count/#sthash.d1zsgENi.dpuf
 * 
 * @author vigoel
 *
 */
public class DuplicateCharsInString {

	public void findDuplicateChars(String str) {

		Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
		char[] chrs = str.toCharArray();
		for (Character ch : chrs) {
			if (dupMap.containsKey(ch)) {
				dupMap.put(ch, dupMap.get(ch) + 1);
			} else {
				dupMap.put(ch, 1);
			}
		}
		Set<Character> keys = dupMap.keySet();
		for (Character ch : keys) {
			if (dupMap.get(ch) > 1) {
				System.out.println(ch + "--->" + dupMap.get(ch));
			}
		}
	}

	public static void main(String a[]) {
		DuplicateCharsInString dcs = new DuplicateCharsInString();
		dcs.findDuplicateChars("Java2Novice");
	}
}