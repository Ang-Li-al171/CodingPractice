package codeForces243Div2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class PCV2 {

	static int l;
	static int r;
	static boolean allneg = false;
	static boolean[] used;
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		used = new boolean[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
			used[i]=false;
		}
		int max = maxSum(a);
		if(allneg){
			System.out.println(max);
			return;
		}
		List<Integer> out = new ArrayList<Integer>();
		for(int i=0;i<l;i++){
			out.add(a[i]);
		}
		for(int j=r+1;j<n;j++){
			out.add(a[j]);
		}
		Collections.sort(out);
		System.out.println(l+" "+r);
		while(k-->0){
			int temp = findMostNeg(a);
			if(temp==0) break;
			if(out.size() > 0 && out.get(out.size()-1)>0){
				max-=temp;
				int t = out.get(out.size()-1);
				max+=t;
				out.remove(out.size()-1);
				System.out.println("minNeg="+temp+" outToIn="+t);
			} else{
				max-=temp;
			}
			System.out.println("k="+k+" max="+max);
		}
		while(k-->0 && out.size() > 0 && out.get(out.size()-1)>0){
			max+=out.get(out.size()-1);
			out.remove(out.size()-1);
		}
		
		System.out.println(max);
	}
	
	private static int maxSum(int[] a){
		int max = Integer.MIN_VALUE;
		int temp=0;
		int m = Integer.MIN_VALUE;
		int linit = 0;
		for(int i=0;i<a.length;i++){
			temp+=a[i];
			m = Math.max(m, a[i]);
			if(temp<0){
				temp=0;
				linit = i+1;
			} else if(temp>max){
				max = temp;
				l = linit;
				r = i;
			}
		}
		if(max==Integer.MIN_VALUE){
			allneg = true;
		}
		return max==Integer.MIN_VALUE?m:max;
	}
	
	private static int findMostNeg(int[] a){
		int min = 0;
		int minIndex = -1;
		for(int i=l;i<=r;i++){
			if(a[i]<min && used[i]==false){
				min = a[i];
				minIndex = i;
			}
		}
		if(minIndex > 0) used[minIndex]=true;
		return min;
	}
}
