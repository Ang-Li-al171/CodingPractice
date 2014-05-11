package p1_p50_Euler;
import java.math.BigInteger;


public class P16 {

	public static void main(String[] args){
		BigInteger n = new BigInteger("1");
		for (int i=0;i<1000;i++){
			n = n.multiply(new BigInteger("2"));
		}
		int sum = 0;
		for (char c : n.toString().toCharArray()){
			sum+=Integer.parseInt(""+c);
		}
		System.out.println(sum);
	}
}
