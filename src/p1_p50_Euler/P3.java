package p1_p50_Euler;

public class P3 {

	public static void main(String[] args){
		long a = 600851475143L;
		boolean newF = true;
		long max = 0;
		while(newF){
			newF = false;
			for (int i=2;i<a;i++){
				if (a % i == 0){
					newF = true;
					a /= i;
					if (i>max) max = i;
				}
			}
		}
		if (a > max) max = a;
		System.out.println(max);
	}
}
