import java.util.Scanner;


public class MergeSort {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++){
			A[i]=in.nextInt();
		}
		int[] results = mergeSort(A, 0, n-1);
		for(int i:results)
		System.out.println(i);
	}

	private static int[] mergeSort(int[] A, int l, int r){
		if(r-l<1) return new int[]{A[r]};
		int mid = (l+r)/2;
		int[] leftSorted = mergeSort(A, l, mid);
		int[] rightSorted = mergeSort(A, mid+1, r);
		return merge(leftSorted,rightSorted);
	}
	
	private static int[] merge(int[] left, int[] right){
		int l=0, r=0;
		int[] ret = new int[left.length+right.length];
		int index = 0;
		while(l<left.length && r<right.length){
			if(left[l]<right[r]){
				ret[index++]=left[l++];
			} else {
				ret[index++]=right[r++];
			}
		}
		while(l<left.length){
			ret[index++]=left[l++];
		}
		while(r<right.length){
			ret[index++]=right[r++];
		}
		return ret;
	}
}
