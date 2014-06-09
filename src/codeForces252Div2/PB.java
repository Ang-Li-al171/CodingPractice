package codeForces252Div2;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int v = in.nextInt();
		
		int[] f = new int[3002];
		while(n-->0){
			int a = in.nextInt();
			int b = in.nextInt();
			f[a] += b;
		}
		
		int s = 0;
		int rem = 0;
		for(int i=1;i<=3001;i++){
			int round = 0;
			if(f[i]+rem<=v){
				s+=f[i]+rem;
				rem=0;
			}else{
				if(rem<v){
					round+=rem;
				}else{
					rem = f[i];
					s+=v;
					continue;
				}
				s+=v;
				rem=f[i]-(v-round);
			}
		}
		
		System.out.println(s);
	}
}
