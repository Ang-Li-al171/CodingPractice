package codeForces249Div2;
import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		
		char[][] out = new char[2000][1000];
		for(int i=0;i<2000;i++)
			Arrays.fill(out[i], ' ');
		Point curr = new Point(0, 0);
		int lowest = 0;
		int highest = 0;
		int farthest = 0;
		int indi=0;
		for(int i=0;i<n;i++){
			int p=in.nextInt();
			if(indi%2==0){
				while(p-->0){
					out[curr.y+1000][curr.x]='/';
					curr.x++;
					curr.y++;
					if(curr.y>highest){
						highest=curr.y;
					}
				}
			}else{
				while(p-->0){
					curr.y--;
					out[curr.y+1000][curr.x]='\\';
					curr.x++;
					if(curr.y<lowest){
						lowest=curr.y;
					}
				}
			}
			indi++;
			farthest = curr.x;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=highest+1000-1;i>=lowest+1000;i--){
			for(int j=0;j<farthest;j++){
				sb.append(out[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
