package p1_p50_Euler;

import java.util.HashSet;
import java.util.Set;

public class P43 {

	public static void main(String[] args){
		Set<String> set = new HashSet<String>();
		for (int i=0;i<10;i++) set.add(Integer.toString(i));
		long sum=0;
		Set<String> per = permutate(set);
		System.out.println(per.size());
		for(String k : per){
//			System.out.println(k);
			if (checkSpecial(k)){
				sum+=Long.parseLong(k);
			}
		}
		System.out.println(sum);
	}
	
	private static boolean checkSpecial(String n){
		if(Long.parseLong(n)<1e9) return false;
		int[] p = {2, 3, 5, 7, 11, 13, 17};
		String ns = n;
		for(int i=1;i<8;i++){
//			System.out.println(ns.substring(i, i+3));
			if(Integer.parseInt(ns.substring(i, i+3)) % p[i-1] != 0) return false;
		}
		return true;
	}
	
	private static Set<String> permutate(Set<String> digits){
		if (digits.size()==1) return digits;
		Set<String> set = new HashSet<String>();
		Set<String> newDigits = new HashSet<String>();
		newDigits.addAll(digits);
		for(String n : digits){
			newDigits.remove(n);
//			System.out.println(newDigits.size());
			addAll(set, permutate(newDigits), n);
			newDigits.add(n);
//			System.out.println("level "+newDigits.size()+" size "+set.size());
		}
		return set;
	}
	private static void addAll(Set<String> target, Set<String> toAdd, String prefix){
		for(String i : toAdd){
//			System.out.println((prefix+i));
			target.add((prefix+i));
		}
	}
}
