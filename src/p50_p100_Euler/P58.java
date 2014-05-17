package p50_p100_Euler;

public class P58 {

	public static void main(String[] args){
		
		int N = (int)1e8;
		int[] p = new int[N];
		for(int i=2;i<N;i++) p[i]=1;
		for(int i=2;i<N;i++){
			if(p[i]==1){
				for(int j=i*2;j<N;j+=i){
					p[j]=0;
				}
			}
		}
		int sideL = 2;
		int prime=0;
		int diagonal=1;
		for(long i=1;i<1e10;){
			for(int j=0;j<4;j++){
				i+=sideL;
				diagonal++;
				if(i<N){if (p[(int)i]==1) prime++;}
				else{if (isPrime(i)) prime++;}
			}
//			System.out.println(diagonal+" "+sideL+" "+prime);
			if(diagonal/prime>=10) break;
			sideL+=2;
		}
		
		System.out.println(sideL + " "+diagonal + " "+prime);
	}
	private static boolean isPrime(long n){
		for(long i=2;i<Math.sqrt(n)+1;i++){
			if (n%i == 0) return false;
		}
		return true;
	}
}
