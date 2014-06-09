package miscQs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Permutations {

	static Set<String> permutations = new HashSet<String>();
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String s = in.next();
		permutate(s.toCharArray(), 0);
		for(String str:permutations){
			System.out.println(str);
		}
	}
	
	private static void permutate(char[] s, int n){
		for(int i=n;i<s.length;i++){
			for(int j=i+1;j<s.length;j++){
				swap(i, j, s);
				permutations.add(new String(s));
				permutate(s, n+1);
				swap(i, j, s);
				permutate(s, n+1);
			}
		}
	}
	
	private static void swap(int i, int j, char[] s){
		char tmp = s[i];
		s[i]=s[j];
		s[j]=tmp;
	}
}
