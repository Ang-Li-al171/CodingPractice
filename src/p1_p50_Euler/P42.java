package p1_p50_Euler;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class P42 {

	public static void main(String[] args){
		Set<Integer> tri = new HashSet<Integer>();
		for(int i=1;i<1000;i++){
			tri.add(i*(i+1)/2);
		}
		Scanner in = new Scanner(System.in);
		int count=0;
		while(in.hasNext()){
			String s = in.next();
			String[] prewords = s.split(",");
			for(String w : prewords){
				if(isTri(w.substring(1, w.length()-1), tri)) count++;
			}
		}
		System.out.println(count);
	}
	private static boolean isTri(String s, Set<Integer> set){
		int v = 0;
		for(char c : s.toCharArray()){
			v+= c - 'A' + 1;
		}
		return set.contains(v);
	}
}
