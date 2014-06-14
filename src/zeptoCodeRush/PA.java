package zeptoCodeRush;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class PA {

	static int x;
	
	public static void main(String[] args){
		
		new PA().go();
	}
	
	private void go(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		x = in.nextInt();
		int xCopy = x;
		
		ArrayList<Candy> t0 = new ArrayList<Candy>();
		ArrayList<Candy> t1 = new ArrayList<Candy>();
		
		ArrayList<Candy> t0Copy = new ArrayList<Candy>();
		ArrayList<Candy> t1Copy = new ArrayList<Candy>();
		
		for(int i=0;i<n;i++){
			int t = in.nextInt();
			int h = in.nextInt();
			int m = in.nextInt();
			if(t == 0){
				t0.add(new Candy(h, m));
				t0Copy.add(new Candy(h, m));
			}else{
				t1.add(new Candy(h, m));
				t1Copy.add(new Candy(h, m));
			}
		}
		
		Collections.sort(t0);
		Collections.sort(t1);
		Collections.sort(t0Copy);
		Collections.sort(t1Copy);
		
		int result1 = startWith(0, t0, t1);
		x = xCopy;
		int result2 = startWith(1, t0Copy, t1Copy);
		
//		System.out.println(result1+" "+result2);
		
		System.out.println(result1>result2?result1:result2);
	}
	
	private int startWith(int n, ArrayList<Candy> t0, ArrayList<Candy> t1){

		int cnt = 0;
		int curr = 0;
		int last = n;
		
		while(true){
			curr = cnt;
			int chosen = -1;
			if(last == 0){
				for(int i=0;i<t0.size();i++){
					if(x>=t0.get(i).h){
						chosen = i;
						break;
					}
				}
				if(chosen >= 0){
					last = 1;
					cnt++;
					x+=t0.get(chosen).m;
					t0.remove(chosen);
				}
			} else {
				for(int i=0;i<t1.size();i++){
					if(x>=t1.get(i).h){
						chosen = i;
						break;
					}
				}
				if(chosen >= 0){
					last = 0;
					cnt++;
					x+=t1.get(chosen).m;
					t1.remove(chosen);
				}
			}
			if(curr == cnt) break;
		}	
		
		return cnt;
	}
	
	private class Candy implements Comparable<Candy>{
		int h;
		int m;
		public Candy(int h, int m){
			this.h = h;
			this.m = m;
		}
		@Override
		public int compareTo(Candy o) {
			return o.m - m;
		}
	}
}
