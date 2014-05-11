package p1_p50_Euler;
import java.util.HashSet;
import java.util.Set;


public class P38 {

	public static void main(String[] args){
		
		int t1 = range(1, 10, 11);
		int t2 = range(10, 100, 6);
		int t3 = range(100, 1000, 4);
		int t4 = range(1000, 10000, 3);
		
		System.out.println(Math.max(t1, Math.max(t2, Math.max(t3, t4))));
	}
	
	private static int range(int low, int high, int nUpper){
		int max = 0;
		for(int i=low;i<high;i++){
			StringBuilder sb = new StringBuilder();
			Set<Character> digits = new HashSet<Character>();
			for(int n=1;n<nUpper;n++){
				int temp = i*n;
				sb.append(temp);
				for(char c : Integer.toString(temp).toCharArray()){
					if (c!='0') digits.add(c);
				}
			}
			if (digits.size()==9 && sb.length()==9){
				System.out.println(i);
				int ss = Integer.parseInt(sb.toString());
				if(ss > max) max = ss;
			}
		}
		return max;
	}
}
