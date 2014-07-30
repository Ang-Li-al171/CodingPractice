package codeForces256Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		double cups = 0;
		double medals = 0;
		
		for(int i=0;i<3;i++){
			cups+=in.nextInt();
		}
		
		for(int i=0;i<3;i++){
			medals+=in.nextInt();
		}
		
		int n = in.nextInt();
		
		System.out.println(((int)Math.ceil(cups/5)) + ((int)Math.ceil(medals/10))>n?"NO":"YES");
	}
}
