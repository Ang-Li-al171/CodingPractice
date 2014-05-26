package codeForces243Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int s = in.nextInt();
		int max = 0;
		int sum = 0;
		while(n-->0){
			int a = in.nextInt();
			sum+=a;
			max=Math.max(max, a);
		}
		
		System.out.println(sum-max > s?"NO":"YES");
	}
}
