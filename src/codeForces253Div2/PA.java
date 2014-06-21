package codeForces253Div2;
import java.util.HashSet;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		String line = in.nextLine();
		
		HashSet<Character> seen = new HashSet<Character>();
		for(char c : line.toCharArray()){
			if(c>='a' && c<='z' && !seen.contains(c)){
				seen.add(c);
			}
		}
		
		System.out.println(seen.size());
	}
}
