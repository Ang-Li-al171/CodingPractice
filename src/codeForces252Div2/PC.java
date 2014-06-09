package codeForces252Div2;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int m=in.nextInt();
		int t=in.nextInt();
		
		int[][] out = new int[n][m];
		int[] count = new int[t+1];
		int each = n*m/t;
		int curr = 1;
		int cnt = 0;
		int dir = -1;
		for(int i=0;i<n;i++){
			dir *= -1;
			if(dir == 1){
				for(int j=0;j<m;j++){
					out[i][j]=curr;
					cnt++;
					if(cnt>=each && curr<t){
						count[curr]=cnt;
						curr++;
						cnt=0;
					}
				}
			} else {
				for(int j=m-1;j>=0;j--){
					out[i][j]=curr;
					cnt++;
					if(cnt>=each && curr<t){
						count[curr]=cnt;
						curr++;
						cnt=0;
					}
				}
			}
		}
		count[curr]=cnt;
		StringBuilder sb = new StringBuilder();
		int c = 1;
		int current = 1;
		dir = -1;
		sb.append(count[current]+" ");
		for(int i=0;i<n;i++){
			dir *= -1;
			if(dir == 1){
				for(int j=0;j<m;j++){
					if(c>count[current]){
						current++;
						sb.append('\n');
						sb.append(count[current]+" ");
						c=1;
					}
					sb.append(i+1);
					sb.append(' ');
					sb.append(j+1);
					sb.append(' ');
					c++;
				}
			} else {
				for(int j=m-1;j>=0;j--){
					if(c>count[current]){
						current++;
						sb.append('\n');
						sb.append(count[current]+" ");
						c=1;
					}
					sb.append(i+1);
					sb.append(' ');
					sb.append(j+1);
					sb.append(' ');
					c++;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
