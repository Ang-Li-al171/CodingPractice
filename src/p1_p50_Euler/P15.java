package p1_p50_Euler;

public class P15 {

	static long[][] routes = new long[21][21];
	
	public static void main(String[] args){
		routes[0][0]=1;
		for (int i=0;i<21;i++){
			for (int j=0;j<21;j++){
				if (i==0 && j==0) continue;
				routes[i][j] = sumOfPred(i, j);
			}
		}
		
		System.out.println(routes[20][20]);
	}
	
	private static long sumOfPred(int i, int j){
		long sum = 0;
		if (i>0){
			sum+=routes[i-1][j];
		}
		if (j>0){
			sum+=routes[i][j-1];
		}
		return sum;
	}
}
