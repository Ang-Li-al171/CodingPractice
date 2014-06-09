package codeForces252Div2;
import java.util.ArrayList;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int b = in.nextInt();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int index = 1;
		while(n-->0){
			int ni = in.nextInt();
			int possible = 0;
			for(int i=0;i<ni;i++){
				int t = in.nextInt();
				if (t<b){
					possible = 1;
				}
			}
			if(possible == 1){
				result.add(index);
			}
			index++;
		}
		System.out.println(result.size());
			for(int i:result){
				System.out.printf("%d ", i);
			}
	}
}
