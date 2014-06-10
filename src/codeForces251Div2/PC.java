package codeForces251Div2;
import java.util.ArrayList;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int p = in.nextInt();
		int curreven = 0;
		int currodd = 0;
		ArrayList<ArrayList<Integer>> even = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> odd = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> eveninput = new ArrayList<Integer>();
		ArrayList<Integer> oddinput = new ArrayList<Integer>();
		while(n-->0){
			int t = in.nextInt();
			if(t%2==0) eveninput.add(t);
			else oddinput.add(t);
		}
		for(int i=0;i<eveninput.size();i++){
			final int t = eveninput.get(i);
				if(curreven<p){
					even.add(new ArrayList<Integer>(){{add(t);}});
					curreven++;
				}else{
					if(curreven>0) even.get(0).add(t);
					else{
						if(currodd>0) odd.get(0).add(t);
						else{
							even.add(new ArrayList<Integer>(){{add(t);}});
							curreven++;
						}
					}
				}
		}
		for(int i=0;i<oddinput.size();i++){
			final int t = oddinput.get(i);
				if(currodd<k-p){
					odd.add(new ArrayList<Integer>(){{add(t);}});
					currodd++;
				} else if (currodd>k-p){
					ArrayList<Integer> l = odd.get(odd.size()-1);
					l.add(t);
					even.add(l);
					curreven++;
					odd.remove(odd.size()-1);
					currodd--;
				} else {
					if(curreven>p){
						ArrayList<Integer> l = even.get(even.size()-1);
						l.add(t);
						odd.add(l);
						currodd++;
						even.remove(even.size()-1);
						curreven--;
					} else {
						odd.add(new ArrayList<Integer>(){{add(t);}});
						currodd++;
					}
				}
			}
		while(curreven>p && p>0){
			ArrayList<Integer> l = even.get(even.size()-1);
			even.get(0).addAll(l);
			even.remove(even.size()-1);
			curreven--;
		}
		if(p==0 && currodd>0){
			for(ArrayList<Integer> l : even){
				odd.get(0).addAll(l);
			}
			curreven = 0;
			even=new ArrayList<ArrayList<Integer>>();
		}
		while(currodd>2 && currodd>k-p){
			ArrayList<Integer> l = odd.get(odd.size()-1);
			ArrayList<Integer> l2 = odd.get(odd.size()-2);
			odd.get(0).addAll(l);
			odd.get(0).addAll(l2);
			currodd-=2;
			odd.remove(odd.size()-1);
			odd.remove(odd.size()-1);
		}
		if(currodd+curreven!=k){
			System.out.println("NO");
			return;
		}
		StringBuilder sb = new StringBuilder();
		System.out.println(curreven==p?"YES":"NO");
		if(curreven==p){
			for(ArrayList<Integer> l : even){
				sb.append(l.size()+" ");
				for(int i : l){
					sb.append(i+" ");
				}
				sb.append("\n");
			}
			for(ArrayList<Integer> l : odd){
				sb.append(l.size()+" ");
				for(int i : l){
					sb.append(i+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
