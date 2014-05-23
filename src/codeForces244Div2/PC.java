package codeForces244Div2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class PC {

	static Stack<Integer> s = new Stack<Integer>();
	static int n;

	static ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> gR = new ArrayList<ArrayList<Integer>>();
	
	static boolean[] visited;
	static int[] cost;
	static boolean[] removed;
	
	static int minCount = 1;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		n =in.nextInt();
		cost = new int[n+1];
		visited = new boolean[n+1];
		
		g.add(new ArrayList<Integer>());
		gR.add(new ArrayList<Integer>());
		for(int i=1;i<=n;i++){
			cost[i]=in.nextInt();
			visited[i]=false;
			g.add(new ArrayList<Integer>());
			gR.add(new ArrayList<Integer>());
		}
		
		int m = in.nextInt();
		for(int i=0;i<m;i++){
			int u = in.nextInt();
			int v = in.nextInt();
			g.get(u).add(v);
			gR.get(v).add(u);
		}
		
		for(int i=1;i<=n;i++){
			if(visited[i]==false){
				dfs(i);
			}
		}
		
		removed = new boolean[n+1];
		for(int i=1;i<=n;i++){visited[i]=false; removed[i]=false;}
		
		long result = 1;
		int mod = 1000000007;
		long minSum = 0;
		while(!s.isEmpty()){
			min = Integer.MAX_VALUE;
			minCount = 1;
			int node = s.pop();
			if(removed[node]==true){continue;}
			dfsR(node);
			result = result*minCount%mod;
			minSum+=min;
		}
		
		System.out.println(minSum + " " + result);
	}
	
	private static void dfs(int node){
		if(visited[node] == true) return;
		visited[node] = true;
			for(Integer neighbor:g.get(node)){
				if(visited[neighbor] == false)
					dfs(neighbor);
			}
		s.push(node);
	}
	
	private static void dfsR(int node){
		if(visited[node] == true) return;
		visited[node] = true;
			for(Integer neighbor:gR.get(node)){
				dfsR(neighbor);
			}
		removed[node] = true;
		if(cost[node]<min){
			min = cost[node];
			minCount=1;
		} else if (cost[node]==min){
			minCount++;
		}
	}
}
