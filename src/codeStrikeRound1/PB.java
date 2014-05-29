package codeStrikeRound1;
import java.util.Arrays;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] comp = new int[n];
		for(int i=0;i<n;i++){
			comp[i]=in.nextInt();
		}
		
		Arrays.sort(comp);
		int count = 0;
		for(int i=comp.length-1;i>=0;i--){
			count++;
			if(count==k){
				System.out.println(comp[i]);
				break;
			}
		}
	}
}
