package codeForces242Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int sit=0, stand=0;
		int n = in.nextInt();
		char[] text = in.next().toCharArray();
		for(int i=0;i<text.length;i++){
			if(text[i]=='x') sit++;
			else stand++;
		}
		if(sit-stand>0){
			int diff = (sit-stand)/2;
			for(int i=0;i<text.length;i++){
				if(diff==0) break;
				if(text[i]=='x'){
					text[i]='X';
					diff--;
				}
			}
		} else {
			int diff = (stand-sit)/2;
			for(int i=0;i<text.length;i++){
				if(diff==0) break;
				if(text[i]=='X'){
					text[i]='x';
					diff--;
				}
			}
		}
		System.out.println(Math.abs(sit-stand)/2);
		System.out.println(text);
	}
}
