package codeForces250Div2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class PB {

	static int[] lower;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int sum = in.nextInt();
		int limit = in.nextInt();
		int curr = 0;
		lower = new int[limit+1];
		ArrayList<Integer> out = new ArrayList<Integer>();
		HashSet<Integer> used = new HashSet<Integer>();
		while(curr<sum){
			int old = curr;
			for(int i=limit;i>0;i--){
				int num=findLower(i);
//				System.out.println(curr+" "+num);
				if(!used.contains(i) && num <= sum-curr){
					used.add(i);
					curr+=num;
					out.add(i);
				}
			}
			if(curr == old) break;
		}
		if(curr!=sum) System.out.println(-1);
		else{
			System.out.println(out.size());
			StringBuilder sb = new StringBuilder();
			for(int i:out){
				sb.append(i);
				sb.append(" ");
			}
			sb.append("\n");
			System.out.println(sb.toString());
		}
	}
	
	static int findLower(int n){
		if(lower[n]!=0) return lower[n];
		else{
			int l = Integer.toBinaryString(n).length();
			for(int i=0;i<l;i++){
				int mask = 1 << i;
				if((n & mask) > 0){
					lower[n] = mask;
					return mask;
				}
			}
			return -1;
		}
	}
}
