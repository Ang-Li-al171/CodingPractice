package codeForces247Div2;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int k=in.nextInt();
		int d=in.nextInt();
		
		long[][] count = new long[n+1][2];
		
		int i=1;
		count[0][0]=1;
		count[0][1]=0;
		
		while(i<=n){
			for(int j=1;j<=k;j++){
				if(j>i) break;
				if(j<d)
					count[i][0]+=count[i-j][0];
				else
					count[i][1]+=count[i-j][0];
				count[i][1]+=count[i-j][1];
				count[i][0]%=1000000007;
				count[i][1]%=1000000007;
			}
			i++;
		}
		
		System.out.println(count[n][1]%1000000007);
	}
}
