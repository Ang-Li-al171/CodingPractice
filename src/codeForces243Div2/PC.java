package codeForces243Div2;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class PC {

	static List<Point> allSwaps = new ArrayList<Point>();
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		int max = maxSum(a);
//		System.out.println(max);
		findAllC2(n);
		for(int i=1;i<=k;i++){
			int ans = trySwapTimes(Arrays.copyOf(a, a.length), k);
			max = Math.max(max, ans);
		}
		System.out.println(max);
	}
	
	private static int maxSum(int[] a){
		int maxSum=0;
		int tempSum=0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			tempSum+=a[i];
			max = Math.max(max, a[i]);
			if(tempSum>0){
				maxSum+=tempSum;
				tempSum=0;
			}
		}
//		System.out.println(maxSum);
		return maxSum==0?max:maxSum;
	}
	
	private static void findAllC2(int n){
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				allSwaps.add(new Point(i, j));
			}
		}
	}
	
	private static void swap(int[] a, int l, int r){
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}
	
	private static int trySwapTimes(int[] a, int times){
		if(times == 0) return maxSum(a);
		int max = Integer.MIN_VALUE;
		for(int i=0;i<allSwaps.size();i++){
			Point p = allSwaps.get(i);
			swap(a, p.x, p.y);
			allSwaps.remove(i);
			max = Math.max(max, trySwapTimes(a, times-1));
			allSwaps.add(i, p);
		}
		return max;
	}
}
