package codeForces255Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int result = -1;
		int p = in.nextInt();
		int n = in.nextInt();
		int[] A = new int[p];
		for(int i=0;i<n;i++){
			int num = in.nextInt();
			if(A[num%p]==0)
				A[num%p]=1;
			else{
				result = i+1;
				break;
			}
		}
		System.out.println(result);
		
	}
}
