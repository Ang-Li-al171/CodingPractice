package p50_p100_Euler;

import java.math.BigInteger;

public class P55 {

	public static void main(String[] args){
		int count=0;
		for(int i=1;i<1e4;i++){
			if(isLychrel(i)){
				count++;
			}
		}
		System.out.println(count);
	}
	
	private static boolean isLychrel(int n){
		BigInteger temp = new BigInteger(Integer.toString(n));
		for(int i=0;i<50;i++){
			String reverse = new StringBuilder(temp.toString()).reverse().toString();
			temp = temp.add(new BigInteger(reverse));
			if (isPalindrome(temp.toString())) return false;
		}
		return true;
	}
	
	private static boolean isPalindrome(String n){
		String ns = n;
		for(int i=0;i<ns.length()/2;i++){
			if(ns.charAt(i) != ns.charAt(ns.length()-1-i)) return false;
		}
		return true;
	}
}
