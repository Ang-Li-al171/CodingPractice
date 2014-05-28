package codeForces242Div2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		new PB().go();
	}
	
	private void go(){
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int ppl = in.nextInt();
		ArrayList<City> l = new ArrayList<City>();
		for(int i=0;i<n;i++){
			l.add(new City(in.nextInt(), in.nextInt(), in.nextInt()));
		}
		Collections.sort(l);
		double r = 0;
		for(int i=0;i<l.size();i++){
//			System.out.println(l.get(i).x + " " + l.get(i).y + " " + ppl);
			if(Math.abs(ppl-1e6) < 1e-6 || ppl>1e6) break;
			ppl+=l.get(i).popu;
			r=Math.sqrt(l.get(i).x*l.get(i).x+l.get(i).y*l.get(i).y);
		}
		if(ppl<1e6) r = -1;
		System.out.println(r);
	}
	
	private class City implements Comparable<City>{
		int popu;
		int x;
		int y;
		public City(int xx, int yy, int p){
			popu = p;
			x = xx;
			y = yy;
		}
		@Override
		public int compareTo(City o) {
			City c = (City) o;
			return x*x+y*y-c.x*c.x-c.y*c.y;
		}
	}
}
