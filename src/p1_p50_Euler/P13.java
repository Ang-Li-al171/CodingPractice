package p1_p50_Euler;
import java.math.BigInteger;
import java.util.Scanner;


public class P13 {

	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		BigInteger sum = new BigInteger("0");
		while(in.hasNext()){
			String s = in.next();
			BigInteger n = new BigInteger(s);
			sum = sum.add(n);
		}
		System.out.println(sum.toString());
	}
}
