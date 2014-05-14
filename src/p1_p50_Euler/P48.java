package p1_p50_Euler;

public class P48 {

	public static void main(String[] args){
		long result = 0;
		for(int i=1;i<=1000;i++){
			result = (result+selfP(i))%(10000000000L);
		}
		System.out.println(result);
	}
	
	private static long selfP(int n){
		long sum = 1;
		for(int i=0;i<n;i++){
			sum = (sum*n)%(10000000000L);
		}
		return sum;
	}
}
