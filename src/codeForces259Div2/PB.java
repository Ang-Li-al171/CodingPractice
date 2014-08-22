package codeForces259Div2;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		
		int i = 0;
		while(i<a.length-1 && a[i+1]>=a[i]) i++;
		if(i==a.length-1){
			System.out.println(0);
			return;
		}
		int ans = a.length-1-i;
		i++;
		while(i<a.length-1 && a[i+1]>=a[i]) i++;
		if(i==a.length-1 && a[i]<=a[0]) System.out.println(ans);
		else System.out.println(-1);
		
	}
}
