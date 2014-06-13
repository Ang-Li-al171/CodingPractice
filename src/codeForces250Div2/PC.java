package codeForces250Div2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		
		new PC().go();
	}
	
	private void go(){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int ntemp = n;
		int m = in.nextInt();
		Node[] nodes = new Node[n+1];
		nodes[0]=new Node(0, 0);
		int index=1;
		while(ntemp-->0){
			nodes[index]=new Node(index, in.nextInt());
			index++;
		}
		while(m-->0){
			
			int a = in.nextInt();
			int b = in.nextInt();
			nodes[a].neighbors.add(b);
			nodes[b].neighbors.add(a);
//			System.out.println(a+" "+b);
		}
		Node[] sorted = Arrays.copyOf(nodes, nodes.length);
		Arrays.sort(sorted);
		int cost = 0;
		for(int i=0;i<n;i++){
			int nn = sorted[i].id;
			for(int nei:nodes[nn].neighbors){
				cost+=nodes[nei].v;
//				System.out.println(sorted[i].v+" "+nodes[nei].v);
				nodes[nei].neighbors.remove(new Integer(nn));
			}
		}
		System.out.println(cost);
	}
	
	private class Node implements Comparable<Node>{
		int v;
		int id;
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		public Node(int id, int v){
			this.id=id;
			this.v=v;
		}
		@Override
		public int compareTo(Node o) {
			return o.v-this.v;
		}
	}
}
