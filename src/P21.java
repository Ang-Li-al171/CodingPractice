import java.util.HashSet;
import java.util.Set;


public class P21 {

	public static void main(String[] args){
		
		Set<Integer> amicable = new HashSet<Integer>();
		int[] div = new int[10000];
		
		for (int i=1;i<10000;i++){
			div[i] = sumOfDivs(i);
		}
		for (int i=1;i<10000;i++){
			for (int j=1;j<10000;j++){
				if (i==j) continue;
				if (div[i]==j && div[j]==i){
					amicable.add(i);
					amicable.add(j);
				}
			}
		}
		int sum=0;
		for(Integer n : amicable){
			System.out.println(n);
			sum+=n;
		}
		System.out.println(sum);
	}
	
	private static int sumOfDivs(int n){
		int divSum = 1;
		for(int i=2;i<=Math.sqrt(n);i++){
			if (i==Math.sqrt(n) && n%i==0) divSum+=i;
			else if (n%i==0) divSum+=i+n/i;
		}
		return divSum;
	}
}
