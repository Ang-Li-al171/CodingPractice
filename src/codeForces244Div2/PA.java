package codeForces244Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int curr = 0;
		int untreated = 0;
		while(n-->0){
			int t = in.nextInt();
			if(t<0){
				if(curr <= 0) untreated++;
				else curr-=1;
			} else {
				curr+=t;
			}
		}
		
		System.out.println(untreated);
	}
}
