package p1_p50_Euler;
import java.util.ArrayList;
import java.util.List;


public class P35 {

	public static void main(String[] args){
		int[] p = new int[(int)1e6];
		for(int i=2;i<1e6;i++) p[i]=1;
		sieve(p);
		int count=0;
		for(int i=2;i<1e6;i++){
			if (p[i]==1){
				List<Integer> rotations = rotate(i);
				boolean circular = true;
				for(Integer k:rotations){
					if(p[k] == 0) circular = false;
				}
				if (circular == true) count++;
			}
		}
		System.out.println(count);
	}
	
	private static List<Integer> rotate(int n){
		List<Integer> r = new ArrayList<Integer>();
		String ns = Integer.toString(n);
		for(int i=1;i<ns.length();i++){
			r.add(Integer.parseInt(ns.substring(i) + ns.substring(0, i)));
		}
		return r;
	}
	private static void sieve(int[] p){
		for(int i=2;i<1e6;i++){
			if(p[i]==1){
				for(int j=i+i;j<1e6;j+=i){
					p[j]=0;
				}
			}
		}
	}
}
