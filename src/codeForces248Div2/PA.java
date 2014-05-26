package codeForces248Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		
		int cnt200 = 0;
		int cnt100 = 0;
		
		while(n-->0){
			int a = in.nextInt();
			if(a==100) cnt100++;
			else cnt200++;
		}
		
		String ans = "";
		if(cnt200%2 == 0 && cnt100%2 == 0) ans = "YES";
		else if (cnt100 > 0 && (cnt100-2)%2==0) ans = "YES";
		else ans = "NO";
		System.out.printf("%s\n", ans);
	}
}
