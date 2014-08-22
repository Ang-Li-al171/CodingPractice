package codeForces260Div2;
import java.util.Arrays;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		PA pa = new PA();
		
		int n = in.nextInt();
		
		Point[] lap = new Point[n];
		
		for(int i=0;i<n;i++){
			lap[i]=pa.new Point(in.nextInt(), in.nextInt());
		}
		
		Arrays.sort(lap);
		
		String ret = "Poor Alex";
		for(int i=0;i<n-1;i++){
			if(lap[i+1].q < lap[i].q) ret = "Happy Alex";
		}
		System.out.println(ret);
	}
	
	private class Point implements Comparable<Point>{
		
		int p, q;
		
		public Point(int p, int q){
			this.p=p;
			this.q=q;
		}

		@Override
		public int compareTo(Point o) {
			return p-o.p;
		}
	}
}
