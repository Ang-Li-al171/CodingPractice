package p1_p50_Euler;

public class P45 {

	public static void main(String[] args){
		long t = 1;
		long p = 1;
		long h = 1;
		long T=2, P=3, H=4;
		boolean firstTime=true;
		while(true){
			if (T<= P && T<=H){
				t++;
				T=t*(t+1)/2;
			} else if (P <= T && P <= H){
				p++;
				P=p*(3*p-1)/2;
			} else {
				h++;
				H=h*(2*h-1);
			}
			if (T == P && P == H){
				if (!firstTime) break;
				firstTime=false;
			}
//
//			System.out.println(P);
		}
		
		System.out.println(T);
	}
}
