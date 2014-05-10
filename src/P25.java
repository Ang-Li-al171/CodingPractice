import java.math.BigInteger;


public class P25 {

	public static void main(String[] args){
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		int index = 2;
		while(b.toString().length()<1000){
			BigInteger temp = b.add(a);
			a = b;
			b = temp;
			index++;
		}
		System.out.println(index);
	}
}
