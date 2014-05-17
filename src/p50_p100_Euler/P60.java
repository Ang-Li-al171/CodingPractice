package p50_p100_Euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P60 {

	static List<Integer> primes = new ArrayList<Integer>();
	static Set<Integer> primeSet = new HashSet<Integer>();
	public static void main(String[] args){
		
		int N = (int) 5e3;
		int[] p = new int[N];
		for(int i=2;i<N;i++) p[i]=1;
		for(int i=2;i<N;i++){
			if(p[i]==1){
				primes.add(i);
				primeSet.add(i);
				for(int j=i*2;j<N;j+=i){
					p[j]=0;
				}
			}
		}
		System.out.println(primes.size());
		int min=Integer.MAX_VALUE;
		for(int i=0;i<primes.size();i++){
			for(int j=i+1;j<primes.size();j++){
				for(int k=j+1;k<primes.size();k++){
					for(int l=k+1;l<primes.size();l++){
						for(int m=l+1;m<primes.size();m++){
							int sum = check(primes.get(i),primes.get(j),primes.get(k),primes.get(l),primes.get(m));
							if(sum < 1e6){
								System.out.println(min);
								min = sum;
							}
						}
					}
				}
			}
		}
		
		System.out.println(min);
	}
	
	private static int check(int i, int j, int k, int l, int m){
		if(i+j+k+l+m < 792) return Integer.MAX_VALUE;
		for(int temp1=0;temp1<5;temp1++){
			for(int temp2=temp1+1;temp2<5;temp2++){
				if(primeSet.contains(Integer.toString(temp1) + Integer.toString(temp2)) &&
						primeSet.contains(Integer.toString(temp2) + Integer.toString(temp1))){
					continue;
				} else {
					return Integer.MAX_VALUE;
				}
			}
		}
		return i+j+k+l+m;
	}
}
