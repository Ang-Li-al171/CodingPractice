package codeForces256Div2;
import java.util.Arrays;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		String t = in.next();
		
		String result = "need tree";
		
		if(checkAuto(s, t)) result = "automaton";
		else if(equalArrays(sortChars(s), sortChars(t))) result = "array";
		else if(checkAuto(new String(sortChars(s)), new String(sortChars(t)))) result = "both";
		System.out.println(result);
	}
	
	private static char[] sortChars(String s){
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return temp;
	}
	
	private static boolean equalArrays(char[] s, char[] t){
		if(s.length!=t.length) return false;
		for(int i=0;i<s.length;i++){
			if(s[i]!=t[i]) return false;
		}
		return true;
	}
	
	private static boolean checkAuto(String s, String t){
		int sindex = 0;
		for(int i=0;i<t.length();i++, sindex++){
			while(sindex<s.length() && s.charAt(sindex)!=t.charAt(i)) sindex++;
			if(sindex >= s.length()) return false;
		}
		return true;
	}
}
