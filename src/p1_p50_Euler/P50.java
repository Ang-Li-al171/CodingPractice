package p1_p50_Euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P50 {

	static final int N = (int)1e6;
	static List<Long> primes = new ArrayList<Long>();
	static Set<Long> primesSet = new HashSet<Long>();
	
	public static void main(String[] args){
		int[] p = new int[N];
		for(long i=2;i<N;i++) p[(int)i]=1;
		for(long i=2;i<N;i++){
			if(p[(int)i]==1){
				primes.add(i);
				primesSet.add(i);
				for(long j=i*2;j<N;j+=i){
					p[(int)j]=0;
				}
			}
		}
//		System.out.println(primes.size());
		
		long superSum = 0;
		for(int k=0;k<primes.size();k++){
			superSum+=primes.get(k);
		}

		long max = 0;
		
		for(int i=primes.size();i>0;i--){
			if(i<primes.size()) superSum-=primes.get(i);
//			System.out.println(superSum);
			if(superSum>1e6) continue;
			int j=0;
			long sum = superSum;
			boolean done = false;
			if(primesSet.contains(sum)){
				System.out.println(sum + " " + i);
				if(sum>max) max = sum;
				done=true;
//				break;
			}
		   
			while(j<primes.size()-i){
//				System.out.println(sum);
				if(sum>1e6) break;
				sum-=primes.get(j);
				sum+=primes.get(i+j);
				j++;
				
				if(primesSet.contains(sum)){
//					System.out.println(sum + " " + i);
					if(sum>max) max = sum;
					done=true;
					break;
				}
			}
			if(done){
				System.out.println(superSum);
				System.out.println(max + " " + i + " " + primes.get(j) + " " + primes.get(i+j-1));
//				long tempSum=0;
//				for(int kk=0;kk<i;kk++){System.out.println(primes.get(kk)); tempSum+=primes.get(kk);}
//				System.out.println(tempSum);
				break;
			}

		}
//		System.out.println(max);
	}
}
