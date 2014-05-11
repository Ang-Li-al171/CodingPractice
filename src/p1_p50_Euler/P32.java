package p1_p50_Euler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P32 {

	public static void main(String[] args){
		Set<Integer> results = new HashSet<Integer>();
		for(int i=1;i<5000;i++){
			for(int j=1;j<5000;j++){
				if(hasExactly9Digits(i,j)){
					System.out.println(i+" "+j+" "+i*j);
					results.add(i*j);
				}
			}
		}
		long sum=0;
		for(Integer i : results){
			sum+=i;
		}
		System.out.println(sum);
	}
	
	private static boolean hasExactly9Digits(int i, int j){
		List<Character> results = new ArrayList<Character>();
		
		for(char c : Integer.toString(i).toCharArray()){
			if (results.contains(c) || c == '0')
				return false;
			results.add(c);
		}
		for(char c : Integer.toString(j).toCharArray()){
			if (results.contains(c) || c == '0')
				return false;
			results.add(c);
		}
		for(char c : Integer.toString(i*j).toCharArray()){
			if (results.contains(c) || c == '0')
				return false;
			results.add(c);
		}
		
		return results.size()==9;
	}
}
