package p1_p50_Euler;
public class P9 {
	public static void main(String[] args) {
		int result = 0;
		for (int i = 1; i < 1000; i++) {
			for (int j = 1; j < 1000; j++) {
				int k = 1000 - i - j;
				if (i * i + j * j == k * k)
					result = i * j * k;
			}
		}
		System.out.println(result);
	}
}
