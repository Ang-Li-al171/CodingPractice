package codeForces248Div2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class PB {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String line;
//		while ((line = bi.readLine()) != null)
//		    for (String numStr: line.split("\\s"))
//		        sum += Integer.parseInt(numStr);
		
		int n= Integer.parseInt(bi.readLine());
		int[] a = new int[n];
		int bSize = (int) Math.sqrt(n);
		long[] bSums = new long[(int)Math.sqrt(n)+2];
		long[] bSumsSorted = new long[(int)Math.sqrt(n)+2];
		long sum=0;
		line = bi.readLine();
		String[] num = line.split("\\s+");
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(num[i]);
			sum+=a[i];
			if(i>0 && i%bSize==0){
				bSums[i/bSize]=sum;
				sum=0;
			}
		}
		
		int[] aSorted = Arrays.copyOf(a, a.length);
		Arrays.sort(aSorted);
		sum=0;
		for(int i=0;i<n;i++){
			sum+=aSorted[i];
			if(i>0 && i%bSize==0){
				bSumsSorted[i/bSize]=sum;
				sum=0;
			}
		}
		
		int m=Integer.parseInt(bi.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++){
			line = bi.readLine();
			num = line.split("\\s+");
			int type = Integer.parseInt(num[0]);
			int l = Integer.parseInt(num[1])-1;
			int r = Integer.parseInt(num[2])-1;
			if(type == 1){
				rangeQ(l, r, bSize, a, bSums, sb);
			} else {
				rangeQ(l, r, bSize, aSorted, bSumsSorted, sb);
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void rangeQ(int l, int r, int bSize, int[] a, long[] bSums, StringBuilder sb){
		long s=0;
		if(r-l<bSize){
			for(int k=l;k<=r;k++){
				s+=a[k];
			}
		} else {
			int lowerB = l/bSize + 1;
			int upperB = r/bSize;
			for(int k=l;k<=bSize*lowerB;k++){
				s+=a[k];
			}
//			System.out.println("DEBUG: "+s);
			while(lowerB < upperB){
				s+=bSums[++lowerB];
			}
//			System.out.println(s);
			for(int k=upperB*bSize+1;k<=r;k++){
				s+=a[k];
			}
		}
		sb.append(s);
		sb.append('\n');
	}
}
