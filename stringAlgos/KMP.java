package stringAlgos;

public class KMP {
	
//	Knuth-Morris-Pratt Algorithm
//	TC : O(n+m)~O(n)    SC : O(m) 
//	The KMP performs some analysis on the word W before trying to find its occ in text T
/*
 *		It works on proper prefix(from LHS) and proper suffix(from RHS)
 * 		Uses pre generated table called longest proper prefix table
 * 		A prefix table helps to skip certain comparision
 * 
 * 
 * 		HELLO proper prefixes are H,HE,HEL,HELL and proper suffixes are O,LO,LLO,ELLO
 * 
 * 
 * 
 * 		THE PREFIX TABLE contains length of longest proper prefix that matches proper suffix in the same subpattern
 * 
 * 
 * 		Computing LPS approach
 * 			1. lps[0]=0,i=1,len=0;
 * 			2. run loop for i=1 to i<=m-1
 * 				2.i. if pat[i]=pat[len]
 * 					len++,lps[i]=len,i++
 * 				2.ii. else
 * 					2.ii.a if len!=0
 * 							len=lps[len-1]
 * 					2.ii.b else
 * 							lps[i]=0,i++
 * 		
 * 
 * 
 * 
 * 
 * 
 * 		Matching Overview
 *		txt = “AAAAABAAABA” 
 *
 *		pat = “AAAA”
 *		We compare first window of txt with pat
 *		
 *		txt = “AAAAABAAABA” 
 *		pat = “AAAA”  [Initial position]
 *		We find a match. This is same as Naive String Matching.
 *		
 *		In the next step, we compare next window of txt with pat.
 *		
 *		txt = “AAAAABAAABA” 
 *		pat =  “AAAA” [Pattern shifted one position]
 *		
 *		This is where KMP does optimization over Naive. In this second window, we only compare fourth A of pattern
 *		with fourth character of current window of text to decide whether current window matches or not. 
 *		Since we know first three characters will anyway match, we skipped matching first three characters. 
 * 		
 * 
 */
	
	private String s;
	private String pat;
	private int m,n;
	private int lps[];

	public KMP(String a,String b) {
		// TODO Auto-generated constructor stub
		s=new String(a);
		pat=new String(b);
		m=pat.length();
		n=s.length();
		lps=new int[m];
	}
	
	public void computelps(){
		
		lps[0]=0;
		int len=0,i=1;
		while(i<m){
			if(pat.charAt(i)==pat.charAt(len)){
				len++;
				lps[i]=len;
				i++;
			}
			else{               //mismatch
				if(len!=0){     
					len=lps[len-1];  //do not increment i
				}
				else{         //len is at 0 so we cannot get values using lps[len-1], so we eplicitly handelled it
					lps[i]=0;
					i++;
				}
			}
		} 
	}
	
	public void KMPsearch(){
		computelps();
		
//		values in lps array
		for(int i=0;i<m;i++){
			System.out.print(lps[i]+" ");
		}
		System.out.println();
		
		int i=0,j=0;
		while((n-i)>=(m-j)){
			if(pat.charAt(j)==s.charAt(i)){
				i++;
				j++;
			}
			
			//if found the match i.e. j==m, give the result and re-set the ptr j w.r.t lps table, to compare further
			//else if not found,re-set the pointer j w.r.t to lps table if j>0 or j!=0 to compare
			
			if(j==m){    //i.e all are matched and we reached end of pat string
				System.out.println("Found at index: "+(i-j));
				j=lps[j-1];
			}
			//mismatch
			else if(i<n && pat.charAt(j)!=s.charAt(i)){
				if(j!=0){
					j=lps[j-1]; //change j and now compare the i of string with j index of pat
								//as 0 to j-1 is already matched and we do not check it again
					//do not increment i
				}
				else{
					i++;  //inc i and now start comparing that i with first index of j
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ABABDABACDABABCABABCABABCDACDCCDABABCABAB";
		String pat="ABABCABAB";
//		pat="ABBCA";
		
		
		KMP obj=new KMP(s,pat);
		obj.KMPsearch();

	}

}
