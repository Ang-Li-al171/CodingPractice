package zeptoCodeRush;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		new PB().go();
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
		int rowFromTop = 1;
		int[] result = new int[m];
		while(rowFromTop<n){
			for(Point p : l){
				p.x--;
			}
			for(Point p : r){
				p.x++;
			}
			for(Point p : u){
				p.y--;
			}
			for(Point p : d){
				p.y++;
			}
			for(Point p : l){
				if(p.y==rowFromTop && p.x>=0 && p.x<m){
					result[p.x]++;
				}
			}
			for(Point p : r){
				if(p.y==rowFromTop && p.x>=0 && p.x<m){
					result[p.x]++;
				}
			}
			for(Point p : u){
				if(p.y==rowFromTop && p.x>=0 && p.x<m){
					result[p.x]++;
				}
			}
			for(Point p : d){
				if(p.y==rowFromTop && p.x>=0 && p.x<m){
					result[p.x]++;
				}
			}

			ArrayList<Point> newl = new ArrayList<Point>();
			ArrayList<Point> newr = new ArrayList<Point>();
			ArrayList<Point> newu = new ArrayList<Point>();
			ArrayList<Point> newd = new ArrayList<Point>();
			for(int i=0;i<l.size();i++){
				if(l.get(i).x < m && l.get(i).x >=0 && l.get(i).y > rowFromTop){
					newl.add(l.get(i));
				}
			}
			for(int i=0;i<r.size();i++){
				if(r.get(i).x < m && r.get(i).x >=0 && r.get(i).y > rowFromTop){
					newr.add(r.get(i));
				}
			}
			for(int i=0;i<u.size();i++){
				if(u.get(i).x < m && u.get(i).x >=0 && u.get(i).y > rowFromTop){
					newu.add(u.get(i));
				}
			}
			for(int i=0;i<d.size();i++){
				if(d.get(i).x < m && d.get(i).x >=0 && d.get(i).y > rowFromTop){
					newd.add(d.get(i));
				}
			}
			l = newl;
			r = newr;
			u = newu;
			d = newd;
			rowFromTop++;
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
