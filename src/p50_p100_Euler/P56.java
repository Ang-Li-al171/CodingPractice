package p50_p100_Euler;

import java.math.BigInteger;

public class P56 {

	public static void main(String[] args){
		
		int max = 0;
		
		for(int i=1;i<100;i++){
			for(int j=1;j<100;j++){
				int dSum = digitSum(power(i, j));
				if(dSum>max) max = dSum;
			}
		}
		
		System.out.println(max);
	}
	
	private static String power(int base, int p){
		String baseStr = Integer.toString(base);
		BigInteger n = new BigInteger(baseStr);
		while(p>0){
			n = n.multiply(new BigInteger(baseStr));
			p--;
		}
		return n.toString();
	}
	
	private static int digitSum(String bigInt){
		int sum = 0;
		for(char c:bigInt.toCharArray()){
			sum+=Integer.parseInt(""+c);
		}
		return sum;
	}
}
