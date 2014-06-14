package zeptoCodeRush;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;


public class PBV2 {

	public static void main(String[] args){
		new PBV2().go();
	}
	
	private void go(){
		Scanner in = new Scanner (System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		ArrayList<Point> l = new ArrayList<Point>();
		ArrayList<Point> r = new ArrayList<Point>();
		ArrayList<Point> u = new ArrayList<Point>();
		ArrayList<Point> d = new ArrayList<Point>();
		
		for(int i=0;i<n;i++){
			String row = in.next();
			int index = 0;
			for(char c : row.toCharArray()){
				if(c=='L'){
					l.add(new Point(index, i));
				} else if(c=='R'){
					r.add(new Point(index, i));
				} else if(c=='U'){
					u.add(new Point(index, i));
				} else if(c=='D'){
					d.add(new Point(index, i));
				}
				index++;
			}
		}
		
		int[] result = new int[m];
		for(Point p:l){
			if(p.x-p.y>=0 && p.x-p.y<m)
				result[p.x-p.y]++;
		}
		for(Point p:r){
			if(p.x+p.y>=0 && p.x+p.y<m)
				result[p.x+p.y]++;
		}
		for(Point p:u){
			if(p.y%2==0)
				result[p.x]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++){
			sb.append(result[i]);
			sb.append(' ');
		}
		sb.append('\n');
		System.out.println(sb.toString());
	}
}
