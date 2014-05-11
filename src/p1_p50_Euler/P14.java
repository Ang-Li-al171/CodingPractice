package p1_p50_Euler;
import java.util.HashMap;
import java.util.Map;

public class P14 {

	private static Map<Long, Long> l = new HashMap<Long, Long>();

	public static void main(String[] args) {

		long max = 0;
		long maxindex = 0;
		for (int i = 1; i < 1e6; i++) {
			// System.out.println(i);
			long temp = trace(i);
			if (temp > max) {
				maxindex = i;
				max = temp;
			}
		}

		System.out.println(maxindex);
	}

	private static long trace(long n) {
		long length = 1;
		long temp = n;
		while (temp != 1) {
			length++;
			temp = (temp % 2 == 0) ? (temp / 2) : (3 * temp + 1);
			if (temp < n) {
				try {
					length += l.get(temp);
				} catch (Exception e) {
					System.out.println("tracing " + n + " can't find " + temp);
				}
				break;
			}
		}
		l.put(n, length);
		return length;
	}
}
