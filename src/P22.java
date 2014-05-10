import java.util.Arrays;
import java.util.Scanner;


public class P22 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String allname = in.next();
		String[] prenames = allname.split(",");
		String[] names = new String[prenames.length];
		for(int i=0;i<prenames.length;i++){
			names[i] = prenames[i].substring(1, prenames[i].length()-1);
			System.out.println(names[i]);
		}
		Arrays.sort(names);
		int sum=0;
		for(int i=0;i<names.length;i++){
			sum+=(i+1)*score(names[i]);
		}
		System.out.println(sum);
	}
	
	private static int score(String name){
		int s = 0;
		for (char c : name.toCharArray()){
			s+= c-'A'+1;
		}
		return s;
	}
}
