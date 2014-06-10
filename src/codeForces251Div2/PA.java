package codeForces251Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] agrs){
		Scanner in = new Scanner(System.in);
		
		int n =in.nextInt();
		int l=in.nextInt();
		int curr=0;
		int result = 0;
		while(n-->0){
			int s = in.nextInt();
			curr+=s+10;
			result+=2;
		}
		curr-=10;
		result-=2;
		if(curr<=l){
			result+=(l-curr)/5;
			System.out.println(result);
		}else{
			System.out.println(-1);
		}
	}
}
