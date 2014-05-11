package p1_p50_Euler;

public class P36 {

	public static void main(String[] args){
		int sum=0;
		for(int i=0;i<1e6;i++){
			if(isDoublePalindrome(i)){
				sum+=i;
			}
		}
		System.out.println(sum);
	}
	
	private static boolean isDoublePalindrome(int n){
		return isPanlindrome(Integer.toBinaryString(n)) && isPanlindrome(Integer.toString(n));
	}
	
	private static boolean isPanlindrome(String s){
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
		}
		return true;
	}
}
