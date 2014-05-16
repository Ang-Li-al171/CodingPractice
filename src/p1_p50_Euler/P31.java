package p1_p50_Euler;

public class P31 {

	public static void main(String[] args){
		
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		int[][] ways = new int[201][coins.length];
		
		for(int i=0;i<coins.length;i++) ways[0][i]=1;
		
		for(int i=1;i<201;i++){
			for(int j=0;j<coins.length;j++){
				ways[i][j] += value(ways, i, j-1) + value(ways, i-coins[j], j);
			}
		}
		
		System.out.println(ways[200][coins.length-1]);
	}
	
	private static int value(int[][] ways, int i, int j){
		if (i<0 || j<0) return 0;
		else return ways[i][j];
	}
}
