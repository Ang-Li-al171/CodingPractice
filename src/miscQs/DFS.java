import java.util.ArrayList;
import java.util.Scanner;


public class DFS {

	static 
	int timer = 0;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[n+1];
		for(int i=0;i<=n;i++){
			g.add(new ArrayList<Integer>());
			visited[i]=false;
		}
		for(int j=0;j<m;j++){
			int a = in.nextInt();
			int b = in.nextInt();
			g.get(a).add(b);
		}
		
		
		for(int i=1;i<=n;i++){
			dfs(i, g, visited);
		}
	}
	static void dfs(int node, ArrayList<ArrayList<Integer>> g, boolean[] visited){
		if(visited[node]) return;
		System.out.printf("StartTime for Node: %d -- %d\n", node, timer++);
		visited[node]=true;
		for(int neighbor: g.get(node)){
			dfs(neighbor, g, visited);
		}
		System.out.printf("FinishTime for Node: %d -- %d\n", node, timer++);
	}
}
