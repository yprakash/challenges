/**
 * @author Prakash Yenugandula
 * Date  : 2020-11-03
 * https://www.hackerrank.com/challenges/reduced-string/problem
 */

package com.yprakash.algorithms.strings;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SuperReducedString
{
	public static void main(String[] args) {
		String s = "a";
		System.out.println(s + " -> " + superReducedString(s));
		s = "aa";
		System.out.println(s + " -> " + superReducedString(s));
		s = "baab";
		System.out.println(s + " -> " + superReducedString(s));
		s = "aaabccddd";
		System.out.println(s + " -> " + superReducedString(s));
	}

	// 100% Accepted solution
	static String superReducedString(String s) {
		List<Character> list = new LinkedList<Character>(); // create linkedlist as we need many manipulations to list
		for (char ch: s.toCharArray()) {
			list.add(ch);
		}
		boolean traverse = true;

		while(traverse && list.size() > 1) {
			traverse = false;
			for (int i = 0; i+1 < list.size(); ) {
				if (list.get(i) == list.get(i+1)) {
					list.remove(i);
					list.remove(i);
					traverse = true;
				} else {
					i++;
				}
			}
		}
		return list.size() == 0 ? "Empty String" : list.stream().map(String::valueOf).collect(Collectors.joining());
	}
}
