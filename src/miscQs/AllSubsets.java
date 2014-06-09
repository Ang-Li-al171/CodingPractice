package miscQs;

import java.util.Scanner;

public class AllSubsets {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String s = in.next();
		AllSubsets(s);
	}
	
	private static void AllSubsets(String s){
		int l = s.length();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Math.pow(2,l);i++){
			sb = new StringBuilder();
			int base = 1;
			for(int j=0;j<l;j++){
				if((i & base) > 0){
					sb.append(s.charAt(j));
				}
				base = base << 1;
			}
			System.out.println(sb.toString());
		}
	}
}
