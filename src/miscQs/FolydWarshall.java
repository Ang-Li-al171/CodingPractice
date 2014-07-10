package miscQs;

import java.util.HashMap;
import java.util.Scanner;

public class FolydWarshall {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		HashMap<Integer, HashMap<Integer, Integer>> g = new HashMap<Integer, HashMap<Integer, Integer>>();
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			g.put(i, new HashMap<Integer, Integer>());
		}
		for(int j=0;j<m;j++){
			int a = in.nextInt();
			int b = in.nextInt();
			int w = in.nextInt();
			g.get(a).put(b, w);
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == j)
					dist[i][j] = 0;
				else if (g.get(i).containsKey(j)) {
					dist[i][j] = g.get(i).get(j);
				} else {
					dist[i][j] = 999;
				}
			}
		}
		folydWarshall(g, dist);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.printf("Distance from %d to %d is %d\n", i, j,
						dist[i][j]);
			}
		}
	}

	private static void folydWarshall(
			HashMap<Integer, HashMap<Integer, Integer>> g, int[][] dist) {
		for (int k = 1; k <= dist.length - 1; k++) {
			for (int i = 1; i <= dist.length - 1; i++) {
				for (int j = 1; j <= dist.length - 1; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
	}

}
