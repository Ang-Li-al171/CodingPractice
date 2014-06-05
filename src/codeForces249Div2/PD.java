package codeForces249Div2;
import java.util.Scanner;

public class PD {

	static int count = 0;

	static boolean[][] isBlack;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int m=in.nextInt();
		isBlack = new boolean[n][m];
		for(int i=0;i<n;i++){
			String line = in.next();
			for(int j=0;j<m;j++){
				isBlack[i][j]=line.charAt(j)=='1';
//				System.out.println(isBlack[i][j]);
			}
		}
		
		for(int i=1;i<400;i*=2){
			for(int j=i;j<=i*2;j*=2){
				findInRec(i, j);
			}
		}
		
		System.out.println(count);
	}
	
	static void findInRec(int l, int w){
			for(int i=0;i<400;i++){
				for(int j=0;j<400;j++){
					validate(i, j, l, w);
//					validate(...);
				}
			}
	}
	
	static void validate(int i, int j, int l, int w){
			for(int m=j;m<=j+l;m++){
				if(safeIsBlack(i, m)) return;
			}
			for(int m=j;m<=j+l/2;m++){
				if(safeIsBlack(i, m)) return;
				i++;
			}
			i--;
			for(int m=j+l/2+1;m<=j+l;m++){
				if(safeIsBlack(i, m)) return;
				i--;
			}
			count++;
	}
	
	static boolean safeIsBlack(int i, int j){
		if(i>=isBlack.length || j>=isBlack[0].length) return true;
		else return isBlack[i][j];
	}
}
