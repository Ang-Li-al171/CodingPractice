package codeForces258Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		System.out.println(Math.min(n, m)%2==0?"Malvika":"Akshat");
	}
}
