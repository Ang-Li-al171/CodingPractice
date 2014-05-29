package codeStrikeQualificationRound;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		int[] locked = new int[n];
		int[] lockedStates = new int[k+1];
		int[][] access = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				access[i][j]=in.nextInt();
			}
		}
		for(int j=0;j<m;j++){
			for(int i=0;i<n;i++){
				for(int ii=i+1;ii<n;ii++){
					if(locked[ii]>0 || locked[i]>0) continue;
					if(access[ii][j] == access[i][j] && access[i][j]>0){
						if(locked[ii]==0){
							locked[ii]=j+1;
							lockedStates[access[i][j]]=1;
						}
						if(locked[i]==0){
							locked[i]=j+1;
							lockedStates[access[i][j]]=1;
						}
					}
				}
			}
			for(int i=0;i<n;i++){
				if(lockedStates[access[i][j]]>0 && locked[i] ==0){
					locked[i]=j+1;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.println(locked[i]);
		}
	}
}
