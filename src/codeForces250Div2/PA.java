package codeForces250Div2;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int[] l = new int[4];
		for(int i=0;i<4;i++)
			l[i] = in.next().length()-2;
		int special = 0;
		int longans = -1;
		int shortans = -1;
		
		for(int i=0;i<4;i++){
			int len = l[i];
			for(int j=0;j<4;j++){
				if(i==j) continue;
				if(len<2*l[j]) break;
				if(j==3 || (i==3 && j==2)){
					longans = i;
					special++;
				}
			}
		}
		
		for(int i=0;i<4;i++){
			int len = l[i];
			for(int j=0;j<4;j++){
				if(i==j) continue;
				if(len*2>l[j]) break;
				if(j==3 || (i==3 && j==2)){
					shortans = i;
					special++;
				}
			}
		}
//		System.out.println(shortans+" "+longans);
		if(special!=1){
			System.out.println("C");
		} else {
			System.out.printf("%c\n", 'A'+(longans==-1?shortans:longans));
		}
	}
}
