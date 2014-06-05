package codeStrikeRound1;
import java.util.ArrayList;
import java.util.Scanner;

public class PD {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int d = in.nextInt();
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[n+1];
		
		g.add(new ArrayList<Integer>());
		for(int i=1;i<=n;i++){
			visited[i]=false;
			g.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<d;i++){
			int k = in.nextInt();
			int kk=in.nextInt();
			g.get(k).add(kk);
		}
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		for(int i=1;i<=n;i++){
			if(!visited[i]){
				dfs(i, g, results, visited);
			}
		}
		
		if(results.size()==n){
			for(int k=0;k<results.size();k++){
				System.out.printf("%d ", results.get(k));
			}
		} else {
			System.out.println("-1");
		}
	}
	
	private static void dfs(int n, ArrayList<ArrayList<Integer>> g, ArrayList<Integer> results, boolean[] visited){
		visited[n]=true;
		for(Integer neighbor:g.get(n)){
			if(!visited[neighbor]){
				dfs(neighbor, g, results, visited);
			}
		}
		results.add(n);
	}
}
