package codeForces245Div2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class PC {

	public static void main(String[] args){
		new PC().go();
	}
	
	private void go(){

		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		int[][] edges = new int[n-1][2];
		for(int i=0;i<n-1;i++){
			edges[i][0]=in.nextInt();
			edges[i][1]=in.nextInt();
		}
		
		int[] init = new int[n];
		int[] target=new int[n];

		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node(0));
		
		for(int i=0;i<n;i++){
			init[i]=in.nextInt();
			nodes.add(new Node(i+1));
		}
		
		nodes.get(1).parent = 0;
		
		for(int i=0;i<n;i++){
			target[i]=in.nextInt();
		}
		
		for(int i=0;i<n-1;i++){
			nodes.get(edges[i][0]).children.add(edges[i][1]);
			nodes.get(edges[i][1]).parent = edges[i][0];
			nodes.get(edges[i][1]).children.add(edges[i][0]);
			nodes.get(edges[i][0]).parent = edges[i][1];
		}
		
		Set<Integer> visited = new HashSet<Integer>();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		boolean[] flipQ = new boolean[n];
		for(int i=0;i<n;i++) flipQ[i]=false;
		Stack<Integer> toFlip = new Stack<Integer>();
		toFlip.add(1);
		while(!toFlip.isEmpty()){
			int nn = toFlip.pop();
			if(visited.contains(nn)) continue;
			visited.add(nn);
			for(Integer c1 : nodes.get(nn).children){
				if(!visited.contains(c1)){
					toFlip.add(c1);
				}
			}
			if((init[nn-1] != target[nn-1] && flipQ[nn-1]==false)){
				flip(nn, init, nodes, visited, flipQ);
				sb.append(nn).append("\n");
				count++;
			}else if (init[nn-1] == target[nn-1] && flipQ[nn-1]==true){
				sb.append(nn).append("\n");
				count++;
			}
			else if (init[nn-1] != target[nn-1] && flipQ[nn-1]==true){
				flip(nn, init, nodes, visited, flipQ);
			}
		}
		
		System.out.print(count+"\n");
		if(sb.length()>0) System.out.print(sb.substring(0, sb.length()-1));
	}
	
	private void flip(int node, int[] a, List<Node> nodes, Set<Integer> seen, boolean[] f){

			int nn = node;
			seen.add(node);
			for(Integer c1 : nodes.get(nn).children){
				if(seen.contains(c1))
					continue;
				for(Integer c2 : nodes.get(c1).children){
					if(!seen.contains(c2)){
						f[c2-1]=!f[c2-1];
					}
				}
			}
			a[nn-1]=a[nn-1]==0?1:0;
//			System.out.println("changed "+(node-1)+" to"+a[node-1]);
		}
	
	private class Node{
		public int id;
		public int parent = -1;
		public List<Integer> children = new ArrayList<Integer>();
		public Node(int id){
			this.id = id;
		}
	}
}
