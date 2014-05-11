package p1_p50_Euler;

public class P37 {
	
	static int N = (int) 1e7;
	
	public static void main(String[] args){
		new P37().go();
	}
	private void go(){
		int[] p = new int[N];
		for(int i=2;i<N;i++) p[i]=1;
		sieve(p);
		int count =0;
		int sum=0;
		for(int i=10;i<N;i++){
			if(p[i] == 1 && trunLeft(i, p) && trunRight(i, p)){
				count++;
				sum+=i;
				System.out.println(i);
			}
			if(count>=11) break;
		}
		System.out.println(sum);
	}
	
	private static boolean trunLeft(int n, int[] p){
		String ns = Integer.toString(n);
		while(ns.length()>1){
			ns = ns.substring(1);
			if (p[Integer.parseInt(ns)]==0) return false;
		}
		return true;
	}
	private static boolean trunRight(int n, int[] p){
		String ns = Integer.toString(n);
		while(ns.length()>1){
			ns = ns.substring(0, ns.length()-1);
			if (p[Integer.parseInt(ns)]==0) return false;
		}
		return true;
	}
	private static void sieve(int[] p){
		for(int i=2;i<N;i++){
			if(p[i]==1){
				for(int j=i+i;j<N;j+=i){
					p[j]=0;
				}
			}
		}
	}
}
