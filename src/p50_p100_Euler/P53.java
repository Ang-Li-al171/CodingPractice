package p50_p100_Euler;

public class P53 {
	
	public static void main(String[] args){

		int count =0;
		for(int i=1;i<101;i++){
			for(int j=0;j<=i;j++){
				if(biggerThan1M(i,j)) count++;
			}
		}
		
		System.out.println(count);
	}
	
	private static boolean biggerThan1M(int n, int r){
		double result = 1;
		double tempR = r, tempN = n;
		while(tempR>1e-4 && tempN>n-r+1e-4){
			if(result > 1e6)
				result/=tempR--;
			else{
				result*=tempN--;
//				System.out.println("Result is "+result);
			}
		}
		if(result > 1e6 && tempR==0) { return true;}
		if(result < 1e6 && tempN==n-r) return false;
		if(result > 1e6 && tempN==n-r)
		{
			result/=tempR;
			while(--tempR>1e-4){
//				System.out.println("R is "+tempR);
				result/=tempR;
			}
			if(result>1e6) System.out.println(n+" "+r+" "+result);
			return result>1e6;
		}
		System.out.println("Shouldn't be here");
		if(result < 1e6 && tempR==0) return false;
		return false;

	}
}
