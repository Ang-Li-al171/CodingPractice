import java.util.Scanner;


public class QuickSort {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++) A[i]=in.nextInt();
		quickSort(A, 0, n-1);
		print(A);
	}
	
	static void quickSort(int[] A, int l, int r){
		if(l>=r) return;
		int pivot = A[l];
		int i=l, j=r;
		while(i<j){
			while(A[i]<pivot && i<r) i++;
			while(A[j]>=pivot && j>l) j--;
			if(i>=j){
				break;
			}
			int temp = A[i];
			A[i]=A[j];
			A[j]=temp;
			i++;
			j--;
		}
		quickSort(A, l, j);
		quickSort(A, j+1, r);
	}
	
	static void print(int[] A){

		for(int i=0;i<A.length;i++){
			System.out.printf("%d ", A[i]);
		}
		System.out.println();
	}
}
