package codeStrikeRound1;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		String[] a = new String[n];
		int maxL = 0;
		for(int i=0;i<n;i++){
			a[i]=in.next();
			maxL = Math.max(maxL, a[i].length());
		}
		StringBuilder result=new StringBuilder();
		for(int i=0;i<maxL;i++){
			char init = '0';
			for(int j=0;j<n;j++){
				if(a[j].length()>i && a[j].charAt(i)!='?'){
					if(init=='0'){
						init=a[j].charAt(i);
					} else if(a[j].charAt(i) != init){
						init='?';
						break;
					}
				}
			}
			if(init=='0') init='a';
			result.append(init);
		}
		
		System.out.println(result.toString());
	}
}
