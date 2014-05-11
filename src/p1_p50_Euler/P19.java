package p1_p50_Euler;

public class P19 {
	
	private static int startDay = 1;
	
	public static void main(String[] args){
		int sum=0;
		for(int i=1901;i<2001;i++){
			sum+=sundays(i);
		}
		System.out.println(sum);
	}
	
	private static int sundays(int year){
		int count = 0;
		if (startDay == 1) count++;
		startDay = (startDay + (31%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + ((isLeapYear(year)?29:28)%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (31%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (30%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (31%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (30%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (31%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (31%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (30%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (31%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (30%7 + 1)) % 7;
		if (startDay == 1) count++;
		startDay = (startDay + (31%7 + 1)) % 7;
		
		return count;
	}
	
	private static boolean isLeapYear(int year){
		if (year%4==0 && year%100!=0){
			return true;
		}
		else if (year%400 == 0){
			return true;
		}
		return false;
	}
}
