
public class P28 {

	public static void main(String[] args){
		long sum=1;
		int curr=1;
		for (int i=2;i<1001;i+=2){
			for (int j=0;j<4;j++){
				curr+=i;
				sum+=curr;
			}
		}
		System.out.println(sum);
	}
}
