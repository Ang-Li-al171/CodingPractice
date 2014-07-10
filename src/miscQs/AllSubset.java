package miscQs;

import java.util.Scanner;

public class AllSubset {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		char[] str = s.toCharArray();
		int n = 1 << s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				if (((i >> j) & 1 )== 1) {
					sb.append(str[j]);
				}
			}
			System.out.println(sb.toString());
		}
	}

}
