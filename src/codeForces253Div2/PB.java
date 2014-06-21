package codeForces253Div2;
import java.util.Scanner;


public class PB {

	static int max = 0;
	static int allowed = 0;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		int n = in.nextInt();
		allowed = n+s.length();
		if(n >= s.length()){
			System.out.println((n+s.length())%2==0?(n+s.length()):(n+s.length()-1));
		} else {
			for(int i=0;i<allowed;i++){
				for(int j=i+1;j<allowed;j++){
					tryDo(s, i, j);
				}
			}
			System.out.println(max);
		}
	}
	
	private static void tryDo(String s, int i, int j){
		int len = j-i;
		int sLen = s.length();
		for(int k=0;k<len;k++){
			if((j+k<allowed && j+k>=sLen) || (i+k<sLen && j+k<sLen && s.charAt(i+k)==s.charAt(j+k))){
				continue;
			} else {
				return;
			}
		}
		max = Math.max(len*2, max);
	}
}
