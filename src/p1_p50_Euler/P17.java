package p1_p50_Euler;
public class P17 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			sum += spell(i);
//			System.out.println(sum);
//			if (i==342 || i ==115) System.out.println(spell(i));
		}
		sum+=11;
		System.out.println(sum);
	}

	private static int spell(int n) {
		if (n==0) return 0;
		else if (n < 10) {
			switch (n) {
			case 1:
				return 3;
			case 2:
				return 3;
			case 3:
				return 5;
			case 4:
				return 4;
			case 5:
				return 4;
			case 6:
				return 3;
			case 7:
				return 5;
			case 8:
				return 5;
			case 9:
				return 4;
			default:
				;
			}
		} else if (n>=10 && n<= 20){
			switch(n){
			case 10: return 3;
			case 11: return 6;
			case 12: return 6;
			case 13: return 8;
			case 14: return 8;
			case 15: return 7;
			case 16: return 7;
			case 17: return 9;
			case 18: return 8;
			case 19: return 8;
			case 20: return 6;
			}
		}
		else if (n >= 100) {
			if (n%100 == 0) return spell(n / 100) + 7;
			else return spell(n / 100) + 10 + spell(n % 100);
		} 
		else {
			int tens = n / 10;
			int remainder = n % 10;
			switch (tens) {
			case 2:
				return 6 + spell(remainder);
			case 3:
				return 6 + spell(remainder);
			case 4:
				return 5 + spell(remainder);
			case 5:
				return 5 + spell(remainder);
			case 6:
				return 5 + spell(remainder);
			case 7:
				return 7 + spell(remainder);
			case 8:
				return 6 + spell(remainder);
			case 9:
				return 6 + spell(remainder);
			default:
				;
			}
		}
		System.out.println(n);
		return 0;
	}
}
