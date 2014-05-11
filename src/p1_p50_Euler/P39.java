package p1_p50_Euler;

public class P39 {

	public static void main(String[] args){
		int max=0, maxP=0;
		for(int i=3;i<=1000;i++){
			int count=0;
			for(int a=1;a<i/2;a++){
				for(int b=1;b<a;b++){
					int c = i-a-b;
					if (c > i/2) continue;
					if(c*c+b*b==a*a) count++;
				}
			}
			if (count>max){
				max = count;
				maxP = i;
			}
		}
		System.out.println(maxP);
	}
}
