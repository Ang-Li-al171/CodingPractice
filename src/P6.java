
public class P6 {
	
	public static void main (String[] args){
		int ss = 0;
		int sum = 0;
		for (int i=1;i<=100;i++){
			sum+=i;
			ss+=i*i;
		}
		System.out.println(sum*sum - ss);
	}
}
