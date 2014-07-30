package codeForces257Div2;
import java.util.Scanner;


public class PB {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
        long x = in.nextLong();
        long y = in.nextLong();
        int n = in.nextInt();
        
        long A[]=new long[10];
        A[0]=x;
        A[1]=y;
        for(int i=1;i<8;i++){
            A[i+1]=A[i]-A[i-1];
        }
        if(A[(n-1)%6]>=0){
            System.out.println(A[(n-1)%6]%((int)1e9+7));
        }
        else{
            if((1000000007+A[(n-1)%6])<0){
                System.out.println(1000000007*2+A[(n-1)%6]);
            }
            else{
                System.out.println((1000000007+A[(n-1)%6]));
            }
        }
	}
}
