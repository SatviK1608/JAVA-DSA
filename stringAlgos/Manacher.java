package stringAlgos;

import java.util.Arrays;

public class Manacher {
	
	/*
	 * 	Manacher Algo -> used to find longest palindromic substring
	 * 
	 * 	TC: O(n)    SC:O(n)
	 * 
	 * 	i/p: ABABABA
	 * 
	 * 	New string -> @#A#B#A#B#A#B#A#@
	 * 	Length will be (2n+3) which will make our new string of odd length 
	 * 	
	 * 
	 * 			@#A#B#A#B#A#B#A#@
	 * lps:		00000000000000000
	 * 
	 * finalLps:00103050705030100
	 * 
	 * 
	 * 
	 * 
	 */
	
	

	public Manacher() {
		
	}
	
	

	public static void main(String[] args) {
		
		
		String s=new String("ABABABA");
		
		int n=s.length();
		
		int n1=2*n+3;
		
		char[] new_string=new char[n1];
		new_string[0]='@';
		new_string[n1-1]='@';
		
		int index=1;
		for(char character : s.toCharArray()){
			new_string[index++]='#';
			new_string[index++]=character;
		}
		new_string[index]='#';
		
//		for(char c : new_string){
//			System.out.print(c);
//		}
//		System.out.println();
		
		//lpstable stores length of matched substring at that index
		int[] lpstable=new int[n1];
		Arrays.fill(lpstable,0);
		
		
		int center=0,maxRight=0;
		
		for(int i=1;i<n1-1;i++){
			
			int mirror=center-(i-center);
			
			if(i<maxRight){
				lpstable[i]=Math.min((maxRight-i),lpstable[2*center-i]);
			}
			
			
			//LHS=RHS : Comparing
			while((i-lpstable[i]-1)>0 && new_string[i-lpstable[i]-1]==new_string[i+lpstable[i]+1]){
				lpstable[i]++;
			}
			
			
			if(i+lpstable[i]>maxRight){
				center=i;
				maxRight=i+lpstable[i];
			}
		}
		
		System.out.println(new_string);
		//lps table printing
		for(int i=0;i<n1;i++){
			System.out.print(lpstable[i]);
		}
		System.out.println("\n");
		
		
int maxLength = 0, maxIndex = 0;
		
		for(int i = 0; i < n1 - 1; i++) {
			
			if(lpstable[i] > maxLength) {	
				maxLength = lpstable[i];
				maxIndex = i;				
			}
						
		}
		
		System.out.println(maxLength + " ");
		
		
		int startIndex = maxIndex - maxLength + 1;
		int actualIndex = ( startIndex - 2 ) / 2;
		
		System.out.println(s.substring(actualIndex, actualIndex + maxLength));
		
		
		
	}

}
