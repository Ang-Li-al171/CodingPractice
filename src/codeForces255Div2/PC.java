package codeForces255Div2;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		int[] l = new int[n];
		for(int i=0;i<n;i++){
			A[i]=in.nextInt();
		}
		l[0]=1;
		int result = 1;
		int prev = A[0];
		for(int i=1;i<n;i++){
			if(A[i]>prev){
				l[i]=l[i-1]+1;
				prev = A[i];
			} else {
				int leng = findDecBack(A, i);
				l[i]=leng;
				if(!canDecrease(A, i, leng))
					prev=A[i-1]+1;
				else
					prev=A[i];
			}
			result = Math.max(result, l[i]);
		}
		System.out.println(result);
	}
	
	private static boolean canDecrease(int[] A, int index, int leng){
		int cnt = 0;
		int secondMax = Integer.MIN_VALUE;
		for(int k=0;k<leng-1;k++){
			if(A[index-k-1]>=A[index]) cnt++;
			if(k==1) secondMax = A[index-k-1];
		}
		return cnt<2 && secondMax<A[index]-1;
	}
	private static int findDecBack(int[] A, int index){
		for(int i=index-1;i>0;i--){
			if(A[i] <= A[i-1]){
				return index-i+1;
			}
		}
		return index+1;
	}
}
