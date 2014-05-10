import java.util.HashSet;
import java.util.Set;


public class P23 {

	static Set<Integer> abundant = new HashSet<Integer>();
	
	public static void main(String[] args){
		
		for (int i=12; i<28124; i++){
			if (isAbundant(i)){
				abundant.add(i);
//				System.out.println(i);
			}
		}
		
		long sum=0;
		for (int i=1;i<28124;i++){
			if(!canBeAbundant(i)){
//				System.out.println(i);
				sum+=i;
			}
		}
		System.out.println(sum);
	}
	
	private static boolean isAbundant(int n){
		int sum = 1;
		for (int i=2;i<=Math.sqrt(n);i++){
			if (i==Math.sqrt(n) && n%i == 0) sum+=i;
			else if (n%i==0) sum+=i+n/i;
		}
		return (sum>n);
	}
	
	private static boolean canBeAbundant(int n){
		for(Integer a : abundant){
			if (abundant.contains(n-a)) return true;
		}
		return false;
	}
}
