package p1_p50_Euler;

public class P30 {

	public static void main(String[] args){
		int sum=0;
		for(int i=2;i<1e7;i++){
			int dsum=0;
			for(char c:Integer.toString(i).toCharArray()){
				dsum+=Math.pow(Integer.parseInt(""+c), 5);
			}
			if (dsum==i){ sum+=i; System.out.println(i);}
		}
		System.out.println(sum);
	}
}
