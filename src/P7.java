
public class P7 {

	public static void main(String[] args){
		int[] p = new int[(int) 1e6];
		int pCount = 0;
		for(int i=0;i<1e6;i++) p[i]=1;
		for(int i=2;i<1e6;i++){
			if (p[i] == 1){
				pCount++;
				if (pCount == 10001) System.out.println(i);
				for (int j=i;j<1e6;j+=i) p[j] = 0;
			}
		}
	}
}
