package codeStrikeQualificationRound;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		String pw = in.next();
		
		boolean atLeast5 = false;
		boolean oneCap = false;
		boolean oneLower = false;
		boolean oneDigit = false;
		int count =0;
		for(char c : pw.toCharArray()){
			count++;
			if(c>='a' && c<='z') oneLower = true;
			else if(c>='A' && c<='Z') oneCap = true;
			else if (c>='0' && c<='9') oneDigit = true;
			if(count>=5) atLeast5=true;
		}
		
		System.out.println(atLeast5 && oneCap && oneLower && oneDigit?"Correct":"Too weak");
	}
}
