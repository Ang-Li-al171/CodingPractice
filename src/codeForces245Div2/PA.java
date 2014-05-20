package codeForces245Div2;
import java.util.Arrays;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int m = in.nextInt();
		int[] ori = new int[n];
		int[] points = new int[n];
		int[] color = new int[101];
		for(int i=0;i<n;i++){
			ori[i]=in.nextInt();
			points[i]=ori[i];
		}
		for(int i=0;i<101;i++) color[i]=-1;
		
		Arrays.sort(points);
		for(int i=0;i<n;i++){
			if(i%2==0){
				color[points[i]]=1;
			} else{
				color[points[i]]=0;
			}
		}
		for(int i=0;i<n;i++){
			System.out.printf("%d ", color[ori[i]]);
		}
	}
	
}
