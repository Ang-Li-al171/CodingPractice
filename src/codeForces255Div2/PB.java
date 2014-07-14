package codeForces255Div2;
import java.util.Arrays;
import java.util.Scanner;


public class PB {

	static int result = 0;
	static int index = 1;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		String s = in.next();
		int n = in.nextInt();
		int[] v=  new int[26];
		int max = 0;
		for(int i=0;i<26;i++){
			v[i]=in.nextInt();
			max = Math.max(max, v[i]);
		}
		for(char c : s.toCharArray()){
			if(v[c-'a']>max && !done){
				done = true;
				addExtra(n, max);
			}
			result+=index*v[c-'a'];
			index++;
		}
		if(!done){
			done = true;
			addExtra(n, max);
		}
		System.out.println(result);
	}
	static void addExtra(int n, int max){
		while(n-->0){
			result+=index*max;
			index++;
		}
	}
}
