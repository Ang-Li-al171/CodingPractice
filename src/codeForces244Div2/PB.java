package codeForces244Div2;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int t = in.nextInt();
		int c = in.nextInt();
		
		int streak = 0;
		int result = 0;
		for(int i=0;i<n;i++){
			int curr = in.nextInt();
			if(curr<=t) streak++;
			else streak=0;
			if(streak >= c) result++;
		}
		
		System.out.println(result);
	}
}
