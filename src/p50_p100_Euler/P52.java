package p50_p100_Euler;

public class P52 {

	public static void main(String[] args) {

		for (int i = 2; i < 1e9; i++) {
			if (isPermutate(i, i * 2) && isPermutate(i * 2, i * 3)
					&& isPermutate(i * 3, i * 4) && isPermutate(i * 4, i * 5)
					&& isPermutate(i * 5, i * 6)) {
				System.out.println(i);
				return;
			}
		}
	}

	private static boolean isPermutate(long a, long b) {
		int[] ac = new int[10];
		int[] bc = new int[10];
		for (char c : Long.toString(a).toCharArray()) {
			ac[Integer.parseInt(c + "")]++;
		}
		for (char c : Long.toString(b).toCharArray()) {
			bc[Integer.parseInt(c + "")]++;
		}
		for (int i = 0; i < 10; i++) {
			if (ac[i] != bc[i])
				return false;
		}
		return true;
	}
}
