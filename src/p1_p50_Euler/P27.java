package p1_p50_Euler;

public class P27 {

	public static void main(String[] args){
		new P27().go();
	}
	private void go(){
		int[] p = new int[(int)1e6];
		for(int i=2;i<1e6;i++) p[i] = 1;
		sieve(p);
		int max = 0;
		int maxa = 0;
		int maxb = 0;
//		for(int i=2;i<1e6;i++) System.out.println(p[i]);
		for (int i=-999; i<1000;i++){
			for (int j=-999; j<1000;j++){
				int count = 0;
				while(isPrime(count, i, j, p)==1){
					count++;
				}
				if (count>max){
					max = count;
					maxa = i;
					maxb = j;
				}
			}
		}
		System.out.println(maxa + " "+ maxb + " " + (maxa*maxb) );
	}
	
	private int isPrime(int n, int a, int b, int[] p){
		if (n*n+a*n+b < 0) return 0;
		return p[n*n+a*n+b];
	}
	
	private void sieve(int[] p){
		for (int i=2;i<1e6;i++){
			if (p[i] == 1){
				for (int j=i+i;j<1e6;j+=i){
					p[j]=0;
				}
			}
		}
	}
}
