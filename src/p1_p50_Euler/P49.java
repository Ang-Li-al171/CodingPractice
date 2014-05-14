package p1_p50_Euler;

import java.util.ArrayList;
import java.util.List;

public class P49 {


	static final int N = (int)1e4;
	static List<Integer> primes = new ArrayList<Integer>();
	
	public static void main(String[] args){
		
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
		
		for(int i=0;i<primes.size();i++){
			for(int j=i+1;j<primes.size();j++){
				for(int k=j+1;k<primes.size();k++){
					if (isPermutate(primes.get(i),primes.get(j)) && isPermutate(primes.get(j), primes.get(k))){
						if (primes.get(j)-primes.get(i) == primes.get(k)-primes.get(j)){
						System.out.println(primes.get(i)+" "+primes.get(j)+" " + primes.get(k));
						}
					}
				}
			}
		}
	}
	
	private static boolean isPermutate(int i, int j){
		int[] a = new int[10];
		int[] b = new int[10];
		
		String si = Integer.toString(i);
		String sj = Integer.toString(j);
		for(char ii : si.toCharArray()){
			a[Integer.parseInt(""+ii)]++;
		}
		for(char jj : sj.toCharArray()){
			b[Integer.parseInt(""+jj)]++;
		}
		
		for(int ti=0;ti<10;ti++){
			if (a[ti] != b[ti]) return false;
		}
		return true;
	}
}
