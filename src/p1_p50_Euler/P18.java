package p1_p50_Euler;
import java.util.Scanner;


public class P18 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[][] num = new int [100][100];
		int index=0;
		while(in.hasNext()){
			String line = in.nextLine();
			String[] nums = line.split("\\s+");
			int col = 0;
			for(String n : nums){
				num[index][col++] = Integer.parseInt(n);
			}
			index++;
		}
		for (int i=1;i<100;i++){
			for (int j=0;j<=i;j++){
				if (j==0) num[i][j]=num[i][j]+num[i-1][j];
				else if (j==i) num[i][j]=num[i][j]+num[i-1][j-1];
				else num[i][j]=num[i][j]+Math.max(num[i-1][j], num[i-1][j-1]);
			}
		}
		
		int max = 0;
		for (int i=0;i<100;i++){
			if (num[99][i]>max) max = num[99][i];
		}
		
		System.out.println(max);
	}
}
