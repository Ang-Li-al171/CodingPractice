package p1_p50_Euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P47 {
	static final int N = (int)1e6;
	static List<Integer> primes = new ArrayList<Integer>();
	static boolean[] is4Prime = new boolean[N];
	static boolean[] didThis = new boolean[N];
	
	public static void main(String[] args){

		for(int i=0;i<N;i++) didThis[i] = false;
		
		int[] p = new int[N];
		for(int i=2;i<N;i++) p[i]=1;
		for(int i=2;i<N;i++){
			if(p[i]==1){
				primes.add(i);
				for(int j=i*2;j<N;j+=i){
					p[j]=0;
				}
			}
		}
		
		for(int i=646;i<N;i++){
			if(is4Prime(i) && is4Prime(i+1) && is4Prime(i+2) && is4Prime(i+3)){
				System.out.println(i);
				break;
			}
//			if (is4Prime(i)) System.out.println(i);
		}
		
	}
	
	private static boolean is4Prime(int n){
		if (didThis[n] == true) return is4Prime[n];
		didThis[n] = true;
		Set<Integer> used = new HashSet<Integer>();
		int t = n;
		for(Integer p : primes){
			if (t%p==0){
				t/=p;
				used.add(p);
				if(used.size()==4) break;
			}
		}
		
		while(t!=1){
			boolean found = false;
			for(Integer pp : used){
				if (t%pp==0){
					t/=pp;
					found = true;
					break;
				}
			}
			if (found == false && t!=1){
				is4Prime[n]=false;
				return false;
			}
		}
		boolean answer = used.size()==4;
		is4Prime[n]=answer;
//		if (is4Prime[n]){ System.out.println(n+" is ");
//		for(Integer i : used) System.out.println(" "+i+" ");}
		return answer;
	}
}
