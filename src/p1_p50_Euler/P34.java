package p1_p50_Euler;

public class P34 {

	public static void main(String[] args){
		int[] fac = new int[10];
		for (int i=0;i<10;i++) fac[i] = factorial(i);
		int sum=0;
		for(int i=10;i<2e7;i++){
			if (i == facSum(i, fac)) sum+=i;
		}
		System.out.println(sum);
	}
	
	private static int factorial(int n){
		if(n<2) return 1;
		return n*factorial(n-1);
	}
	private static int facSum(int n, int[] f){
		int s = 0;
		for(char c : Integer.toString(n).toCharArray()){
			s+=f[Integer.parseInt(""+c)];
		}
		return s;
	}
}
