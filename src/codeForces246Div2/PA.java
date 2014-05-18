package codeForces246Div2;
import java.util.Scanner;

public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int count=0;
		for(int i=0;i<n;i++){
			int temp = in.nextInt();
			if(5-temp >= k) count++;
		}
		
		System.out.println(count/3);
	}
}
