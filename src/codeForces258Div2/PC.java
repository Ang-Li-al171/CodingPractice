package codeForces258Div2;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		while(num-->0){
			int n = in.nextInt();
			int k = in.nextInt();
			int d1 = in.nextInt();
			int d2 = in.nextInt();
			
			System.out.println(n%3==0 && d1+d2<(n/3) ? "yes" : "no");
		}
	}
}
