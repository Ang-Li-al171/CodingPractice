import java.util.HashMap;
import java.util.HashSet;


public class P12 {

	static HashMap<Integer, HashSet<Integer>> div = new HashMap<Integer, HashSet<Integer>>();

	public static void main(String[] args){
		int i=0;
		int sum = 0;
		for (i=1;i<Integer.MAX_VALUE;i++){
			HashSet<Integer> temp = dividers(i);
			div.put(i, temp);
			if (temp.size() > 500) break;
		}
		System.out.println(i);
	}
	
	private static HashSet<Integer> dividers(int n){
		HashSet<Integer> temp = new HashSet<Integer>();
		int i=1;
		for (i=2;i<n;i++){
			if (n%i == 0){
				temp = div.get(n/i);
				break;
			}
		}
		HashSet<Integer> temp2 = new HashSet<Integer>();
		for(Integer j : temp){
			temp2.add(i*j);
		}
		for (Integer j : temp2){
			temp.add(j);
		}
		return temp;
	}
}
