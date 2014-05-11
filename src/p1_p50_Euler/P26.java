package p1_p50_Euler;
import java.util.ArrayList;
import java.util.List;


public class P26 {

	public static void main(String[] args){
		int max = 0;
		int maxI = 0;
		for(int i=2;i<1000;i++){
			int n = length(i);
			System.out.println(i + " has recurring length " + n);
			if (n>max){ maxI = i; max = n;}
		}
		System.out.println(maxI);
	}
	
	private static int length(int n){
		List<Integer> states = new ArrayList<Integer>();
		states.add(10);
		return divide(10, n, states);
	}
	
	private static int divide(int beingDiv, int divNum, List<Integer> prevStates){
		if (beingDiv % divNum == 0) return 0; //non-recurring
		int nextState = (beingDiv%divNum) * 10;
		int length = 0;
		for(int i=0;i<prevStates.size();i++){
			if (nextState == prevStates.get(i)){
				length = prevStates.size()-i;
				break;
			}
		}
		if(length>0) return length;
		else {
			prevStates.add(nextState);
			return divide(nextState, divNum, prevStates);
		}
	}
}
