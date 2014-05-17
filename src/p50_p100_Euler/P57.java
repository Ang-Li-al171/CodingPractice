package p50_p100_Euler;

import java.math.BigInteger;

public class P57 {

	public static void main(String[] args){
		
		BigInteger top = new BigInteger("3");
		BigInteger bot = new BigInteger("2");
		
		int count = 0;
		
		for(int i=1;i<1000;i++){
			top = top.add(bot);
			BigInteger temp = top;
			top = bot;
			bot = temp;
			top = top.add(bot);
			if(top.toString().length() > bot.toString().length()) count++;
//			System.out.println(top + " " + bot);
		}
		
		System.out.println(count);
		
	}
}
