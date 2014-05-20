package codeForces245Div2;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int x = in.nextInt();
		int[] balls = new int[n];
		int left, right;
		for(int i=0;i<n;i++){
			balls[i]=in.nextInt();
		}
		int max = 0;
		for(int i=1;i<n;i++){
			int destroyed = 0;
			if(balls[i-1] == x && x == balls[i]){
				destroyed+=2;
				left=i-2;
				right=i+1;
				while(left>=0 && right<n && balls[left]==balls[right]){
					while(left>0 && balls[left]==balls[left-1]){
						left--;
					}
					while(right<n-1 && balls[right]==balls[right+1]){
						right++;
					}
					if(right-left-destroyed+1 < 3) break;
					destroyed+=right-left-destroyed+1;
					left--;
					right++;
				}
				if(destroyed>max) max = destroyed;
			}
		}
		System.out.println(max);
	}
}
