package p50_p100_Euler;

import java.util.Scanner;

public class P59 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String inStr = in.next();
		String[] letters = inStr.split(",");
		int[] keys = {'a', 'a', 'a'};
		
		for(int i=0;i<26;i++){
			for(int j=0;j<26;j++){
				for(int k=0;k<26;k++){
					
					keys[0]='a'+i; keys[1]='a'+j;keys[2]='a'+k;
					boolean done = false;
					int currKey = 0;
					StringBuilder sb = new StringBuilder();
					for(String ascII : letters){
						int ascIIValue = Integer.parseInt(ascII);
						int decrypted = ascIIValue ^ keys[currKey++];
						char msgChar = (char)decrypted;
						sb.append(msgChar);
						if(currKey > 2) currKey=0;
					}
					int theIndex = sb.indexOf("the") + 1;
					int theCount = 1;
					while(theIndex > 0){
						theIndex = sb.indexOf("the", theIndex)+1;
						theCount++;
						if(theIndex < 0) break;
						if(theCount > 10) done = true;
					}
					if(done){
						int charSum = 0;
						System.out.println(sb.toString());
						for(char c : sb.toString().toCharArray()){
							charSum+=c;
						}
						System.out.println(charSum);
						return;}
					
				}
			}
		}
	}
}
