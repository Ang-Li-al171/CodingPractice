package codeForces254Div2;
import java.util.Scanner;


public class PA {

	static int n, m;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		char[][] A = new char[n][m];
		for(int i=0;i<n;i++){
			A[i]=in.next().toCharArray();
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(A[i][j]=='.'){
					fill(A, i, j, 'W');
				}
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(A[i][j]);
			}
			System.out.println();
		}
		
	}
	
	static void fill(char[][] A, int i, int j, char toFill){
		if(i<0 || i>=n || j<0 || j>=m || A[i][j]!='.') return;
		A[i][j]=toFill;
		fill(A, i-1, j, toFill=='W'?'B':'W');
		fill(A, i, j+1, toFill=='W'?'B':'W');
		fill(A, i+1, j, toFill=='W'?'B':'W');
		fill(A, i, j-1, toFill=='W'?'B':'W');
	}
}
