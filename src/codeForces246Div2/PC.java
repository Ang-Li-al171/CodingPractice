package codeForces246Div2;
import java.util.Scanner;


public class PC {

	static int N;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt()+1;
		int[] p = new int[N];
		for(int i=2;i<N;i++) p[i]=1;
		for(int i=2;i<N;i++){
			if(p[i]==1){
				for(int j=i*2;j<N;j+=i){
					p[j]=0;
				}
			}
		}
		
		int[] a = new int[N];
		int[] index = new int[N];
		for(int i=1;i<N;i++){
			int inNum = in.nextInt();
			a[i]=inNum;
			index[inNum]=i;
		}
		
		StringBuilder sb = new StringBuilder();
		int count=0;
		for(int i=1;i<N;i++){
			int minIndex = index[i];
			int target = i;
			while(minIndex != target){
//				System.out.println(target+" "+minIndex);
				while(p[minIndex-target+1]!=1){
					target++;
				}
				index[a[minIndex]] = target;
				index[a[target]] = minIndex;
				int temp = a[minIndex];
				a[minIndex] = a[target];
				a[target] = temp;
//				System.out.println(a[target]+" "+minIndex);
				count++;
				sb.append(String.format("%d %d\n", target, minIndex));
				minIndex = target;
				target = i;
			}
		}
		System.out.println(count);
		if(sb.length()>0) System.out.println(sb.substring(0, sb.length()-1));
	}
}
