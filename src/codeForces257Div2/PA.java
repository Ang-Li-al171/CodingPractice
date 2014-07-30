package codeForces257Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[] A = new int[n];
		
		int max = 0;
		
		for(int i=0;i<n;i++){
			A[i]=in.nextInt();
			A[i]=(int)Math.ceil(((double)A[i])/((double)m));
			max=Math.max(A[i],max);
		}
		
		int result=0;
		for(int i=0;i<n;i++){
			if(A[i]==max) result=i+1;
		}
		System.out.println(result);
	}
}
