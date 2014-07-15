import java.util.HashMap;
import java.util.Scanner;


public class BellmanFord {

	public static void main(String[] args){
		new BellmanFord().go();
	}
	
	private void go(){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		HashMap<Integer, HashMap<Integer, Integer>> g = new HashMap<Integer, HashMap<Integer, Integer>>();
		int[] dist = new int[n+1];
		for(int i=1;i<=n;i++){
			dist[i]=Integer.MAX_VALUE;
			g.put(i, new HashMap<Integer, Integer>());
		}
		for(int i=0;i<m;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int edge = in.nextInt();
			g.get(a).put(b, edge);
		}
		
		bellmanFord(4, dist, g);
		for(int i=1;i<=n;i++){
			System.out.printf("Node %d has shortest distance %d\n", i, dist[i]);
		}
	}
	
	private void bellmanFord(int source, int[] dist, HashMap<Integer, HashMap<Integer, Integer>> g){
		dist[source]=0;
		for(int i=1;i<dist.length;i++){
			for(int j=1;j<dist.length;j++){
				if(dist[j]<Integer.MAX_VALUE){
					for(int neighbor:g.get(j).keySet()){
						if(dist[neighbor] > dist[j]+g.get(j).get(neighbor)){
							dist[neighbor] = dist[j]+g.get(j).get(neighbor);
						}
					}
				}
			}
		}
	}
}
