package codeForces260Div2;
import java.math.BigInteger;
import java.util.Scanner;


public class PB {

	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		BigInteger i = new BigInteger(s);
		int result = 1;
		switch(i.mod(new BigInteger("4")).intValue()){
		case 1 : result+=9; break;
		case 2 : result+=9; break;
		case 3 : result+=9; break;
		case 0 : result+=3; break;
		default:;
		}
		System.out.println(result%5);
	}
}
