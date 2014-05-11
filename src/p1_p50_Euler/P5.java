package p1_p50_Euler;

public class P5 {
	public static void main(String[] args){
		int result=0;
		for (int i=1;i<Integer.MAX_VALUE;i++){
			int j;
			for (j=1;j<21;j++){
				if (i%j != 0){
					break;
				}
			}
			if (j == 21){
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
