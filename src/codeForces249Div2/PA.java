package codeForces249Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int m=in.nextInt();
		
		int count = 1;
		int curr = 0;
		while(n-->0){
			int p=in.nextInt();
			if(curr+p>m){
				count++;
				curr=p;
			} else {
				curr+=p;
			}
		}
		
		System.out.println(count);
	}
}
