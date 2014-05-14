package p1_p50_Euler;

import java.util.HashSet;
import java.util.Set;

public class P44 {

	public static void main(String[] args){
		Set<Long> pent = new HashSet<Long>();
		for(long i=1;i<1e4;i++){
			pent.add(i*(3*i-1)/2);
		}
		Long min = Long.MAX_VALUE;
		for(Long a : pent){
			for(Long b : pent){
				if (pent.contains(a+b) && pent.contains(Math.abs(a-b)) && a!=b){
					if (Math.abs(a-b) < min){
						System.out.println(a + "-" + b);
						min = Math.abs(a-b);
					}
				}
			}
		}
		
		System.out.println(min);
	}
}
