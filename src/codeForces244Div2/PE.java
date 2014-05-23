package codeForces244Div2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PE {

	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		long result = 0;
		
		ArrayList<Long> batches = new ArrayList<Long>();
		long cnt = 1;
		long init = in.nextLong();
		long pos=0;
		int N = n;
		while(n-->1){
			pos = in.nextInt();
			cnt++;
			if(cnt > m){
				batches.add(pos-init);
//				System.out.println(batches.get(batches.size()-1));
				init = pos;
				cnt = 1;
			}
		}
		if(pos-init > 0)batches.add(pos-init);
		
		if(batches.size() == 0){
			System.out.println(0);
			return;
		}
		
		long mid = batches.get(batches.size()/2);
//		System.out.println(mid);
		for(int i=0;i<batches.size()/2;i++){
			result+=batches.get(i)*2*(i+1);
//			System.out.println("added " + batches.get(i)*2*(i+1) );
		}
		int index = 0;
		for(int i=batches.size()-1;i>=batches.size()/2;i--){
			result+=batches.get(i)*2*(index+1);

//			System.out.println("added " + batches.get(i)*2*(index+1) );
			index++;
		}
		System.out.println(result);
	}
}
