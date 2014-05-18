package codeForces246Div2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class PD {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		
		StringBuilder result = new StringBuilder();
		int resultCount=0;
		Set<Integer> prevIndexes = new HashSet<Integer>();
		boolean first=true;
		for(int l=1;l<=s.length();l++){
			String target = s.substring(0, l);
			if(s.endsWith(target)){
				resultCount++;
				int count=0;
				if(first){
					first=false;
					for(int i=0;i<s.length()-l+1;i++){
						if(s.substring(i, i+l).equals(target)){
							prevIndexes.add(i);
							count++;
						}
					}
					result.append(String.format("%d %d\n", l, count));
				}else{
					Set<Integer> toRemove = new HashSet<Integer>();
					for(Integer index:prevIndexes){
						if(index+l<=s.length() && s.substring(index, index+l).equals(target)){
							count++;
						} else{
							toRemove.add(index);
						}
					}
					prevIndexes.removeAll(toRemove);
					result.append(String.format("%d %d\n", l, count));
				}
			}
		}
		System.out.println(resultCount);
		System.out.println(result.substring(0, result.length()-1));
	}
}
