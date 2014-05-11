package p1_p50_Euler;
import java.util.Scanner;


public class P8 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int max = 0;
		StringBuilder sb = new StringBuilder();
		while(in.hasNext()){
			String numbers = in.next();
			sb.append(numbers);
		}
		String s = sb.toString();
		for(int i=0;i<s.length()-4;i++){
			int p = 1;
			for (int j=0;j<5;j++) p*=Integer.parseInt(""+s.charAt(i+j));
			if (p>max) max = p;
		}
		System.out.println(max);
	}
}
