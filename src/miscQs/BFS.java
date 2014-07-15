import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BFS {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[n+1];
		for(int i=0;i<=n;i++){
			visited[i]=false;
			g.add(new ArrayList<Integer>());
		}
		for(int i=0;i<m;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			g.get(a).add(b);
		}
		
		int[] dist = new int[n+1];
		bfs(4, g, visited, dist);
		
		for(int i=1;i<=n;i++){
			System.out.printf("Node %d has shortest dist %d\n", i, dist[i]);
		}
	}
	
	static void bfs(int node, ArrayList<ArrayList<Integer>> g, boolean[] visited, int[] dist){
		if(visited[node]) return;
		Queue<Integer> toDo = new LinkedList<Integer>();
		dist[node]=0;
		toDo.add(node);
		while(!toDo.isEmpty()){
			int n = toDo.poll();
			visited[n]=true;
			for(int neighbor:g.get(n)){
				if(!visited[neighbor]){
					dist[neighbor]=dist[n]+1;
					toDo.add(neighbor);
				}
			}
		}
	}
}
