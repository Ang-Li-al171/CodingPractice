package codeStrikeRound1;
import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int init=in.nextInt();
		String s = in.next();
		
		if(init>n/2){
			while(init<n){
				init++;
				System.out.println("RIGHT");
			}
		} else {
			while(init>1){
				init--;
				System.out.println("LEFT");
			}
		}
		
		if(init==1){
			for(int i=1;i<n;i++){
				System.out.printf("PRINT %c\n", s.charAt(i-1));
				System.out.printf("RIGHT\n");
			}
			System.out.printf("PRINT %c\n", s.charAt(n-1));
		}else{
			for(int i=n;i>1;i--){
				System.out.printf("PRINT %c\n", s.charAt(i-1));
				System.out.printf("LEFT\n");
			}
			System.out.printf("PRINT %c\n", s.charAt(0));
		}
	}
}
