package p1_p50_Euler;

public class P40 {

	public static void main(String[] args){
		int count=0;
		int prod = 1;
		for(int i=1;i<Integer.MAX_VALUE;i++){
			for(int j=0;j<Integer.toString(i).length();j++){
				count++;
				if(count == 1 || count==10 || count==100 || count==1000 || count==10000
						|| count==100000 || count==1000000){
					try{
						prod*=Integer.parseInt(""+Integer.toString(i).charAt(j));
					} catch (Exception e){
						System.out.println(i + " " + j + " " + count);
					}
				}
			}
			if (count>1e6) break;
		}
		System.out.println(prod);
	}
}
