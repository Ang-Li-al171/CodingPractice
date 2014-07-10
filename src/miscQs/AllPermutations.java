package miscQs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AllPermutations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
//		printAllPermutations(s.toCharArray(), 0);
		printAllPermutations2(s.toCharArray());
	}

	private static void printAllPermutations(char[] str, int index) {
		if (index == str.length) {
			System.out.println(str);
			return;
		}
		for (int i = index; i < str.length; i++) {
			swap(str, index, i);
			printAllPermutations(str, index + 1);
			swap(str, index, i); //important! need to swap back
		}
	}

	private static void swap(char[] c, int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}

	private static void printAllPermutations2(char[] str) {
		Set<String> sofar = new HashSet<String>();
		sofar.add("" + str[0]);
		for (int i = 1; i < str.length; i++) {
			Set<String> toAdd = new HashSet<String>();
			for (String s : sofar) {
				for (int k = 0; k <= s.length(); k++) {
					toAdd.add(s.substring(0, k) + str[i] + s.substring(k));
				}
			}
			sofar=toAdd;
		}
		for (String s : sofar) {
			System.out.println(s);
		}
	}

}
