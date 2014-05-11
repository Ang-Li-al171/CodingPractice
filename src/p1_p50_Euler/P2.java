package p1_p50_Euler;

public class P2 {
	
	public static void main(String[] args){
		int result=0;
		int i=0,j=0;
		for(i=999;i>99;i--){
			for (j=999;j>99;j--){
				if (isPalindrome(i*j) && i*j>result)
					{ result = i*j;}
			}
		}
		System.out.println(result);
		System.out.println(isPalindrome(202));
	}
	
	private static boolean isPalindrome(int n){
		String s = Integer.toString(n);
		for (int i=0;i<s.length()/2;i++){
			if (s.charAt(i) == s.charAt(s.length()-1-i)){
				continue;
			} else{
				return false;
			}
		}
		return true;
	}
}
