package codeForces248Div2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PC {

	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		
		String[] num = line.split("\\s+");
		int n = Integer.parseInt(num[0]);
		int m = Integer.parseInt(num[1]);
		
		int[] low = new int[n+1];
		int[] high = new int[n+1];
		
		long flip = 0;
		
		line = in.readLine();
		num = line.split("\\s+");
		int prev = Integer.parseInt(num[0]);
		for(int i=1;i<m;i++){
			int p = Integer.parseInt(num[i]);
			if(p>prev){
				low[prev]++;
				high[p]++;
				flip+=p-prev;
			} else if(p==prev){
				;
			} else{
				high[prev]++;
				low[p]++;
				flip+=prev-p;
			}
			prev=p;
		}
		
		for(int i=1;i<=n;i++){
			
		}
	}
}
