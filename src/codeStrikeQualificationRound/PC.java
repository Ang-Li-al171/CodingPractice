package codeStrikeQualificationRound;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int[][] a = new int[4][2];
		
		for(int i=0;i<4;i++){
			a[i][0]=in.nextInt();
			a[i][1]=in.nextInt();
		}
		
		String result = "Draw";
		int t1A = -1;
		int t1D = -1;
		if(biggerThanT2D(Math.min(a[1][1], a[0][1]), a)){
			if(biggerThanT2A(Math.max(a[0][0], a[1][0]), a)){
				result = "Team 1";
			}
		} else if (a[0][1] > a[1][1] && biggerThanT2D(a[0][1], a)){
			t1D = 1;
			t1A = 0;
			if(biggerThanT2A(a[1][0], a)){
				result = "Team 1";
			}
		} else if (a[1][1] > a[0][1] && biggerThanT2D(a[1][1], a)){
			t1A = 1;
			t1D = 0;
			if(biggerThanT2A(a[0][0], a)){
				result = "Team 1";
			}
		} else {
			t1D = a[0][0]>a[1][0]?0:1;
			t1A = t1D==0?1:0;
		}
		
		if(t1D + t1A > 0){
			if(a[2][1] > a[t1D][0] && a[3][0] > a[t1A][1]){
				result = "Team 2";
			} else if(a[3][1] > a[t1D][0] && a[2][0] > a[t1A][1]){
				result = "Team 2";
			}
			if(result.equals("Team 2") && biggerThanT2D(Math.max(a[0][1], a[1][1])+1, a)){
				result = "Draw";
			} else if(result.equals("Team 2") && biggerThanT2A(Math.max(a[0][0], a[1][0])+1, a)){
				result = "Draw";
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean biggerThanT2D(int n, int[][] a){
		return n>a[2][0] && n>a[3][0];
	}
	
	private static boolean biggerThanT2A(int n, int[][] a){
		return n>a[2][1] && n>a[3][1];
	}
}
