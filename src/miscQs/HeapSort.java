import java.util.Scanner;
import java.util.TreeSet;


public class HeapSort {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++){
			A[i]=in.nextInt();
		}
		A = heapSort(A);
		print(A);
	}
	static int[] heapSort(int[] A){
		TreeSet<Integer> heap = new TreeSet<Integer>();
		int[] ret = new int[A.length];
		for(int i=0;i<A.length;i++){
			heap.add(A[i]);
		}
		for(int i=0;i<A.length;i++){
			ret[i]=heap.pollFirst();
		}
		return ret;
	}
	
	static void print(int[] A){

		for(int i=0;i<A.length;i++){
			System.out.printf("%d ", A[i]);
		}
		System.out.println();
	}
}
