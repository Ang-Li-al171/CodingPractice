package p1_p50_Euler;
import java.util.ArrayList;
import java.util.List;


public class P24 {

	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		int n = (int) 1e6 - 1;
		int digits = 9;
		List<Integer> avai = new ArrayList<Integer>();
		for(int i=0;i<10;i++) avai.add(i);
		while(digits>=0){
			int numPer = fac(digits);
			sb.append(""+findNthAndRemove(avai, n/numPer));
			digits--;
			n = n%numPer;
		}
		System.out.println(sb.toString());
	}
	
	private static int findNthAndRemove(List<Integer> l, int target){
		int result = l.get(target);
		l.remove(target);
		return result;
	}
	private static int fac(int n){
		if (n==0) return 1;
		if (n==1) return 1;
		return n*fac(n-1);
	}
}
