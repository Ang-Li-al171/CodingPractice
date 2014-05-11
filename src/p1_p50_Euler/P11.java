package p1_p50_Euler;
import java.util.Scanner;


public class P11 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[][] num = new int[20][20];
		int index=0;
		while(in.hasNext()){
			String[] s = in.nextLine().split("\\s+");
			for (int i=0;i<20;i++) num[index][i] = Integer.parseInt(s[i]);
			System.out.println(num[index][0] + " " + num[index][19]);
			index++;
		}
		int max = 0;
		for (int i=0;i<20;i++){
			for (int j=0;j<20;j++){
				int p = 0;
				if (j<17) {p = num[i][j]*num[i][j+1]*num[i][j+2]*num[i][j+3]; if (p>max) max = p;}
				if (i<17) {p = num[i][j]*num[i+1][j]*num[i+2][j]*num[i+3][j]; if (p>max) max = p;}
				if (j<17 && i>2) {p = num[i][j]*num[i-1][j+1]*num[i-2][j+2]*num[i-3][j+3]; if (p>max) max = p;}
				if (j<17 && i<17) {p = num[i][j]*num[i+1][j+1]*num[i+2][j+2]*num[i+3][j+3]; if (p>max) max = p;}
			}
		}
		System.out.println(max);
		
	}
}
