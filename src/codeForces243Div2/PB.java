package codeForces243Div2;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int r= in.nextInt();
		int c= in.nextInt();
		
		int[][] A = new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				A[i][j]=in.nextInt();
			}
		}
		
		System.out.println(count(A));
	}
	
	private static int count(int[][] A){
		if(A.length % 2 != 0) return A.length;
		if(A.length == 1) return 1;
		for(int i=0;i<A.length/2;i++){
			for(int j=0;j<A[0].length;j++){
				if(A[i][j] != A[A.length-1-i][j]) return A.length;
			}
		}
		
		int[][] a = new int[A.length/2][A[0].length];
		for(int i=0;i<A.length/2;i++){
			for(int j=0;j<A[0].length;j++){
				a[i][j]=A[i][j];
			}
		}
		return count(a);
	}
}
