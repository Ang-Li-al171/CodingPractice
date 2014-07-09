package codeForces254Div2;
import java.util.ArrayList;
import java.util.Scanner;


public class PB {

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> g;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n =in.nextInt();
		int m = in.nextInt();
		visited = new boolean[n+1];
		g = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=n;i++){
			g.add(new ArrayList<Integer>());
			visited[i]=false;
		}
		for(int i=0;i<m;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			g.get(a).add(b);
			g.get(b).add(a);
		}
		
		long answer = 1;
		for(int i=1;i<=n;i++){
			int cnt = dfs(i, 0);
			answer*=shift(cnt);
		}

//		System.out.println(shift(30));
		System.out.println(answer);
	}
	static long shift(int cnt){
		if(cnt<32)
			return cnt>1?(1<<(cnt-1)):1;
		else
			return (long) Math.pow(2, cnt-1);
	}
	static int dfs(int node, int num){
		if(visited[node]) return num;
		num++;
		visited[node]=true;
		for(int neighbor: g.get(node)){
			if(!visited[neighbor]){
				num = dfs(neighbor, num);
			}
		}
		return num;
	}
}
