package codeForces249Div2;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		long n=in.nextLong();
		int c=in.nextInt();
		char[] result=Long.toString(n).toCharArray();
		int starting = 0;
		for(int i=0;i<c;){
			if(starting>=result.length) break;
			int index = findLargestIndex(result, c-i+1, starting);
			swapFromJtoI(result, starting, index);
			i+=index-starting;
			starting++;
//			System.out.println(i);
		}
		
		System.out.println(result);
	}
	
	private static void swapFromJtoI(char[] n, int i, int j){
		for(int k=j;k>i;k--){
			char tmp = n[k-1];
			n[k-1]=n[k];
			n[k]=tmp;
		}
	}
	
	private static int findLargestIndex(char[] n, int range, int starting){
		int index = starting;
		char max = n[starting];
		for(int i=starting+1;i<starting+range;i++){
			if(i>=n.length) break;
			if(n[i]>max){
				max=n[i];
				index=i;
			}
		}
		return index;
	}
}
