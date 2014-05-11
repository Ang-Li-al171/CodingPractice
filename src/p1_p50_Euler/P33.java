package p1_p50_Euler;
import java.util.HashSet;
import java.util.Set;


public class P33 {

	public static void main(String[] args){
		int top=1;
		int bot=1;
		for(int i=10;i<100;i++){
			for(int j=i+1;j<100;j++){
				if (hasCommon(i, j)){
					double ii = i;
					double jj = j;
					if (Math.abs(ii/jj - elimiCommon(i,j)) < (0.0000000001)){
						System.out.println(i + " " + j + " "+ Math.abs(ii/jj - elimiCommon(i,j)));
						top*=i;
						bot*=j;
					}
				}
			}
		}
		while(gcd(top, bot) > 1){
			int g = gcd(top, bot);
			top/=g;
			bot/=g;
		}
		System.out.println(bot);
	}
	private static boolean hasCommon(int i, int j){
		Set<Character> seen = new HashSet<Character>();
		for(char c : Integer.toString(i).toCharArray()){
			seen.add(c);
		}
		for(char c : Integer.toString(j).toCharArray()){
			if(c!='0' && seen.contains(c)) return true;
		}
		return false;
	}
	private static double elimiCommon(int i, int j){
		Set<Character> seen = new HashSet<Character>();
		for(char c : Integer.toString(i).toCharArray()){
			seen.add(c);
		}
		char common = '0';
		for(char c : Integer.toString(j).toCharArray()){
			if(c!='0' && seen.contains(c)){
				common = c;
				break;
			}
		}
		if (common == '0') return 0;
		double r = Double.parseDouble(Integer.toString(i).replaceFirst(""+common, ""))/Double.parseDouble(Integer.toString(j).replaceFirst(""+common, ""));
//		System.out.println(i+" "+j+" "+r);
		return r;
	}
	
	private static int gcd(int a, int b){
		if (b == 0) return a;
		else return gcd(b, a%b);
	}
}
