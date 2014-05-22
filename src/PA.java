import java.util.Scanner;


public class PA {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		int a3 = in.nextInt();
		int a4 = in.nextInt();
		
		String s = in.next();
		int result = 0;
		for(char c : s.toCharArray()){
			if(c == '1') result+=a1;
			else if(c == '2') result+=a2;
			else if(c == '3') result+=a3;
			else result+=a4;
		}
		System.out.println(result);
	}
}
