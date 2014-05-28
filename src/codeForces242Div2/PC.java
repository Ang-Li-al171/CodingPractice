package codeForces242Div2;
import java.util.Scanner;


public class PC {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
        int n = in.nextInt();

        int[] xor = new int[n+1];
        for (int i = 1; i <= n; i++) {
            xor[i] = xor[i-1] ^ i;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans ^= in.nextInt();

            int div = n/i;
            if (div % 2 == 1) {
                ans ^= xor[i-1];
            }
            int rem = n%i;
            ans ^= xor[rem];
        }

        System.out.println(ans);
	}
}
