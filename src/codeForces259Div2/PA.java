package codeForces259Div2;
import java.util.Arrays;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		char[][] ret = new char[n][n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				ret[i][j]='*';
			}
		}
		
		for(int i=0;i<=n/2;i++){
			for(int j=n/2-i;j<=n/2+i;j++){
				ret[i][j]='D';
				ret[n-1-i][j]='D';
			}
		}
		
		for(char[] s: ret){
			System.out.println(s);
		}
	}
}
