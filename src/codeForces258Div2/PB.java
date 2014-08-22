package codeForces258Div2;
import java.util.Scanner;


public class PB {

	static int[] range = new int[2];
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		
		String result = check(a);
		
		System.out.println(result);
		if(result.equals("yes"))
			System.out.println(range[0]+" "+range[1]);
	}
	
	private static String check(int[] a){
		
		int i = 0;
		while(i<a.length-1 && a[i+1]>=a[i]) i++;
		range[0]=i+1;
		while(i<a.length-1 && a[i+1]<=a[i]) i++;
		range[1]=i+1;
		while(i<a.length-1 && a[i+1]>=a[i]) i++;
		if(i==a.length-1 && (range[1]>=a.length || a[range[0]-1]<=a[range[1]]) &&
				(range[0]<2 || a[range[1]-1]>=a[range[0]-2])) return "yes";
		else return "no";
	}
}
