import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Dijkstra {

	public static void main(String[] args){
		
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
		
		new Dijkstra().dijkstra(4, dist, g);
		for(int i=1;i<=n;i++){
			System.out.printf("Node %d has shortest distance %d\n", i, dist[i]);
		}
	}
	
	private void dijkstra(int source, int[] dist, HashMap<Integer, HashMap<Integer, Integer>> g){
		dist[source]=0;
		PriorityQueue<NodeWithDist> q = new PriorityQueue<NodeWithDist>();
		q.add(new NodeWithDist(source, dist[source]));
		while(!q.isEmpty()){
			int node = q.poll().node;
			for(int neighbor:g.get(node).keySet()){
				if(dist[node] + g.get(node).get(neighbor) < dist[neighbor]){
					dist[neighbor] = dist[node] + g.get(node).get(neighbor);
					q.add(new NodeWithDist(neighbor, dist[neighbor]));
				}
			}
		}
	}
	
	private class NodeWithDist implements Comparable<NodeWithDist>{
		int node;
		int dist;
		public NodeWithDist(int n, int d){
			node = n;
			dist = d;
		}
		@Override
		public int compareTo(NodeWithDist arg0) {
			return dist-arg0.dist;
		}
		
	}
}
