import java.util.ArrayList;
import java.util.HashSet;


public class P29 {

	public static void main(String[] args){
		new P29().go();
	}
	private void go(){
		ArrayList<HashSet<Integer>> lists = new ArrayList<HashSet<Integer>>();
		lists.add(new HashSet<Integer>());
		lists.add(new HashSet<Integer>());
		int[] count = new int[101];
		for(int i=2;i<=100;i++){
			lists.add(new HashSet<Integer>());
			int power = isPower(i);
			int base = getBase(i);
			
			for(int j=2;j<=100;j++){
				if (power>0){
					if (!lists.get(base).contains(j*power)){
						lists.get(base).add(j*power);
						count[i]++;
					}
				}
				else{
					lists.get(i).add(j);
					count[i]++;
				}
			}
		}
		int sum = 0;
		for(int n : count){
			sum+=n;
		}
		System.out.println(sum);
	}
	private int isPower(int n){
		for (int i=2;i<=10;i++){
			int temp = n;
			int p = 0;
			while(temp>1){
				p++;
				if(temp%i != 0) break;
				temp=temp/i;
			}
			if(temp == 1) return p;
		}
		return 0;
	}
	private int getBase(int n){
		for (int i=2;i<=10;i++){
			int temp = n;
			while(temp>1){
				if(temp%i != 0) break;
				temp=temp/i;
			}
			if(temp == 1) return i;
		}
		return 0;
	}
}
