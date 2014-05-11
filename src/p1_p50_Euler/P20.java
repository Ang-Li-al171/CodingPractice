package p1_p50_Euler;
import java.math.BigInteger;


public class P20 {

	public static void main(String[] args){
		BigInteger n = new BigInteger("1");
		for (int i=2;i<=100;i++){
			n=n.multiply(new BigInteger(Integer.toString(i)));
		}
		int sum = 0;
		for (char c : n.toString().toCharArray()){
			sum+= Integer.parseInt(""+c);
		}
		System.out.println(sum);
	}
}
