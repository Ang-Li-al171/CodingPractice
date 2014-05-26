package codeForces248Div2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PBV2 {

	public static void main(String[] args) throws IOException {

		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String line;

		int n = Integer.parseInt(bi.readLine());
		int[] a = new int[n];
		int[] aSorted = new int[n];
		long[] sums = new long[n];
		long[] sumsSorted = new long[n];
		line = bi.readLine();
		String[] num = line.split("\\s+");

		a[0] = Integer.parseInt(num[0]);
		aSorted[0]=a[0];
		for (int i = 1; i < n; i++) {
			a[i] = Integer.parseInt(num[i]);
			aSorted[i]=a[i];
			sums[i]+=sums[i-1]+a[i];
		}
		Arrays.sort(aSorted);
		sumsSorted[0] = aSorted[0];
		for (int i = 1; i < n; i++) {
			sumsSorted[i]+=sumsSorted[i-1]+aSorted[i];
		}

		int m = Integer.parseInt(bi.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			line = bi.readLine();
			num = line.split("\\s+");
			int type = Integer.parseInt(num[0]);
			int l = Integer.parseInt(num[1]) - 1;
			int r = Integer.parseInt(num[2]) - 1;
			if (type == 1) {
				sb.append(sums[r]-sums[l]+a[l]);
				sb.append('\n');
			} else {
				sb.append(sumsSorted[r]-sumsSorted[l]+aSorted[l]);
				sb.append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}
