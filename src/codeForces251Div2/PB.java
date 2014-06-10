package codeForces251Div2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class PB {

	public static void main(String[] rags) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] l = in.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int total = n;
		long c = Long.parseLong(l[1]);
		ArrayList<Integer> chpts = new ArrayList<Integer>();
		int index = 0;
		l = in.readLine().split(" ");
		while(n-->0){
			chpts.add(Integer.parseInt(l[index]));
			index++;
		}
		Collections.sort(chpts);
		long result = 0;
		for(int i=0;i<total;i++){
//			System.out.println(chpts[i]+" "+c);
			result+=c*((long)chpts.get(i));
			if(c>1) c--;
			else{
				i++;
				while(i<total){
					result+=chpts.get(i);
					i++;
				}
			}
		}
		System.out.println(result);
	}
}
