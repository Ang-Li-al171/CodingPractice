package miscQs;

import java.util.Scanner;

public class FastSquare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		System.out.println(fastSq(n, p));
	}

	private static int fastSq(int base, int power) {
		if (power == 1) {
			return base;
		} else if (power == 0) {
			return 1;
		} else if (power % 2 == 0) {
			return (int) Math.pow(fastSq(base, power / 2), 2);
		} else {
			return (int) (Math.pow(fastSq(base, power / 2), 2) * base);
		}
	}

}
