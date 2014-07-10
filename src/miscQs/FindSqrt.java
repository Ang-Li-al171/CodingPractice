package miscQs;

import java.util.Scanner;

public class FindSqrt {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(sqrt(n));
	}

	private static float sqrt(int n){
		float l = 0;
		float r = n;
		while(l<r){
			float mid = l + (r-l)/2;
			float curr = mid*mid;
			if(curr < n){
				l=(float) (mid+0.001);
			} else if (curr == n) {
				return mid;
			} else {
				r=(float) (mid-0.001);
			}
		}
		return l;
	}
}
