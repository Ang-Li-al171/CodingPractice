package codeForces252Div2;
import java.awt.Point;
import java.util.Scanner;


public class PD {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int[] a = new int[n+1];
		for(int i=0;i<n;i++){
			a[i+1]=in.nextInt();
		}
		int t = in.nextInt();
		
		int[] d = new int[n+1];
		int[] swap = new int[n+1];
		int cnt = 0;
		for(int i=1;i<=n;i++){
			if(a[i]==i){
				d[i]=0;
				swap[i]=0;
			}
			else if(a[a[i]]==i){
				cnt++;
				d[i]=2;
				d[a[i]]=2;
				swap[i]=a[i];
				swap[a[i]]=i;
			} else {
				cnt++;
				d[i]=1;
				swap[i]=-1;
			}
		}
		
		int index = 1;
		while(cnt<t){
			Point i = null;
			if(cnt<t-1){
//				i = nextDouble(index);
			}
			if(cnt>=t-1 || i.x < 0){
//				i = nextSingle(index);
			}
			
		}
	}
}
