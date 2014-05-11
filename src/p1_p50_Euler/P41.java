package p1_p50_Euler;
import java.util.HashSet;
import java.util.Set;


public class P41 {

	static int N = (int)1e8;
	public static void main(String[] args){
		int[] p = new int[N];
		for(int i=2;i<N;i++) p[i]=1;
		sieve(p);
		int max = 0;
		for(int i=2;i<N;i++){
			if(p[i]==1 && isPanDigital(i)){
				if (i>max) max = i;
			}
		}
		System.out.println(max);
	}
	
	private static boolean isPanDigital(int n){
		Set<Character> seen = new HashSet<Character>();
		String ns = Integer.toString(n);
		for(char c : ns.toCharArray()){
			char maxC = (char) ('1' + ns.length());
			if (c!='0' && c<maxC) seen.add(c);
		}
		return seen.size() == ns.length();
	}
	
	private static void sieve(int[] p){
		for(int i=2;i<N;i++){
			if(p[i]==1){
				for(int j=i+i;j<N;j+=i){
					p[j]=0;
				}
			}
		}
	}
}
