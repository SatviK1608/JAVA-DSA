package backtracking;

public class PrintingAllPossiblePermutations {

	//TC:O(n*n!)

	public PrintingAllPossiblePermutations() {
		
	}
	
	public void printPermutation(String s,String permu){
		
		if(s.length()==0){
			System.out.println(permu);
			return;
		}
		for(int i=0;i<s.length();i++){
			char currChar=s.charAt(i);
			String newSubString=s.substring(0,i)+s.substring(i+1,s.length());
			
			printPermutation(newSubString, permu+currChar);
		}
		
	}

	public static void main(String[] args) {
		
		PrintingAllPossiblePermutations obj=new PrintingAllPossiblePermutations();
		obj.printPermutation("ABC", "");
		
	}

}
