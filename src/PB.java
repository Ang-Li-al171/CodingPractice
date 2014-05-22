import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int[][] happy = new int[5][5];
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				happy[i][j]=in.nextInt();
			}
		}
		
		int max = 0;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j==i) continue;
				for(int k=0;k<5;k++){
					if(k==j || k==i) continue;
					for(int l=0;l<5;l++){
						if(l==k || l==j || l==i) continue;
						for(int m=0;m<5;m++){
							if(m==i || m==j || m==k || m==l) continue;
							
							int result = happiness(i,j,k,m,l, happy);
							max = Math.max(result, max);
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	private static int happiness(int i, int j, int k, int l, int m, int[][] h){
		return h[i][j]+h[j][i]+h[k][l]+h[l][k]+h[j][k]+h[k][j]+h[l][m]+h[m][l]+h[k][l]+h[l][k]+h[l][m]+h[m][l];
	}
}
