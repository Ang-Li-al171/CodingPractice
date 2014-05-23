package codeForces247Div2;
import java.util.Scanner;


public class PD {

	static long MAX = (long)1e18;
	static long MIN = 1;
	static int k;
	static long[] f = new long[64];
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		long m = in.nextLong();
		k=in.nextInt();
		f[0]=1; f[1]=1;
		
		while(MAX>MIN){
			long mid = (MAX+MIN)/2;
			long c = count(mid);
			if(c==m){
				System.out.println(mid);
				return;
			}else{
				if(c < m) MIN = mid+1;
				else MAX = mid-1;
//				System.out.println(MAX + " " + mid + " " + MIN);
			}
		}
		
	}
	
	private static long count(long n){
		long twon = n*2;
		String N = Long.toBinaryString(n);
		String twoN = Long.toBinaryString(twon);
		if(N.length()<k) return 0;
		String smallest = findSmall(N);
		String largest = findLarge(twoN);
		if(Long.parseLong(smallest, 2) < n || Long.parseLong(largest, 2) > twon) return 0;
		
		long count = 0;
		int firstZero = smallest.indexOf('0');
		String sub = smallest.substring(firstZero);
		count+=fac(sub.length())/fac(countOnes(sub))/fac(sub.length()-countOnes(sub));
		if(largest.length()>smallest.length()){
			int firstOne = largest.indexOf('1', 1);
			String sub2 = largest.substring(firstOne);
			count+=fac(sub2.length())/fac(countOnes(sub2))/fac(sub2.length()-countOnes(sub2));;
		}
		return count;
	}
	
	private static int countOnes(String s){
		int c = 0;
		for(char ch : s.toCharArray()){
			c+=ch=='1'?1:0;
		}
		return c;
	}
	
	private static String findSmall(String s){
		int n = countOnes(s);
		char[] newString=s.toCharArray();
		int index = s.length()-1;
		while(n<k && index>=0){
			if(newString[index]=='0'){
				newString[index]='1';
				n++;
			}
			index--;
		}
		int index2 = s.length()-1;
		while(n>k && index2>=0){
			if(newString[index]=='1'){
				long temp = Long.parseLong(new String(newString), 2);
				temp+= 1 << s.length()-1-index2;
				newString = Long.toBinaryString(temp).toCharArray();
				n = countOnes(Long.toBinaryString(temp));
			}
			index2--;
		}
		return new String(newString);
	}
	
	private static String findLarge(String s){
		int n = countOnes(s);
		char[] newString=s.toCharArray();
		int index = s.length()-1;
		while(n<k && index>=0){
			if(newString[index]=='0'){
				long temp = Long.parseLong(new String(newString), 2);
				temp-= 1 << s.length()-1-index;
				newString = Long.toBinaryString(temp).toCharArray();
				n = countOnes(Long.toBinaryString(temp));
			}
			index--;
		}
		int index2 = s.length()-1;
		while(n>k && index2>=0){
			if(newString[index]=='1'){
				newString[index] = '0';
				n--;
			}
			index2--;
		}
		return new String(newString);
	}
	
	private static long fac(int n){
		if(f[n] != 0) return f[n];
		f[n] = n*fac(n-1);
		return f[n];
	}
}
