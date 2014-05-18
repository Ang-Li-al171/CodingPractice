package codeForces246Div2;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] home = new int[(int)1e5+1];
		int[] away = new int[(int)1e5+1];
		int[][] colors = new int[n][2];
		
		for(int i=0;i<n;i++){
			int t1 = in.nextInt();
			int t2 = in.nextInt();
			home[t1]++;
			away[t2]++;
			colors[i][0]=t1;
			colors[i][1]=t2;
		}
		
		int[][] results = new int[n][2];
		for(int i=0;i<n;i++){
			results[i][0]=n-1;
			results[i][0]+=home[colors[i][1]];
			results[i][1]=n-1-home[colors[i][1]];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(String.format("%d %d\n", results[i][0], results[i][1]));
		}
		System.out.println(sb.toString());
	}
}
