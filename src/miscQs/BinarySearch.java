package miscQs;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}
		System.out.println(binarySearch(A, 5, 0, A.length-1));
	}

	private static int binarySearch(int[] A, int target, int l, int r) {
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (target > A[mid]) {
				l = mid + 1;
			} else if (target == A[mid]) {
				return mid;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

}
