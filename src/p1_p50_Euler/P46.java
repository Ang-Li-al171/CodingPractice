package p1_p50_Euler;

public class P46 {

	public static void main(String[] args){
		int[] p = new int[(int)1e7];
		for(int i=2;i<1e7;i++) p[i]=1;
		for(int i=2;i<1e7;i++){
			if(p[i] == 1){
				for(int j=i*2;j<1e7;j+=i){
					p[j]=0;
				}
			}
		}
		
		int found = 0;
		for(int i=2;i<1e7;i++){
			if (p[(int)i] == 0){
				for(int j=i-1;j>=2;j--){
					if(isSquare((i-j)/2) && p[(int)j]==1){
//						System.out.println(i + "=" + j + "+" + (i-j)/2);
						break;
					}
					else if(j==2 && (!isSquare((i-j)/2))){
						System.out.println(i);
						found=1;
						break;
					}
				}
			}
			if (found==1) break;
		}
		System.out.println(isSquare(3));
	}
	
	private static boolean isSquare(double i){
		return Math.abs(Math.sqrt(i)-((double) Math.round(Math.sqrt(i)))) < (1e-10);
	}
}
