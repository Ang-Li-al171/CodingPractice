package p1_p50_Euler;
import java.util.HashMap;
import java.util.HashSet;


public class P12 {

	static HashMap<Integer, HashSet<Integer>> div = new HashMap<Integer, HashSet<Integer>>();

	public static void main(String[] args){
		int i=0;
		int sum = 0;
		for (i=1;i<Integer.MAX_VALUE;i++){
			sum+=i;
			int divs = dividers(sum);
			if (divs > 500) break;
		}
		System.out.println(sum);
	}
	
	private static int dividers(int n){ // assumes n >= 1
		int count=1; // 1 is always a divider
		int i=0;
		for (i=2;i<=Math.sqrt(n);i++){
			if (n%i == 0){
				if (i == Math.sqrt(n))
					count+=1;
				else
					count+=2;
			}
		}
		return count;
	}
}
