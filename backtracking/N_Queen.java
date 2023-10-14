package backtracking;


	
	/*
	 * NXN chessboard in how many ways we can put N queens such that no two queens threaten each other
	 * For N=1,2,3 there is no possible way
	 * 
	 * 	Directions		   \|/
	 * 			  		  --Q--
	 * 			  		   /|\
	 * 
	 * 
	 * 	       1 x x x
	 * 		   x x 2 x
	 * 		   x x x x  (not possible so backtrack and check for next valid)
	 * 
	 * 
	 * 		   1 x x x
	 * 		   x x x 2
	 *         x 3 x x
	 *         x x x x (not possible so backtrack and chek for next valid)
	 *         
	 *         
	 *         1 x x x 
	 *         x x x 2
	 *         x x x x (not possible so backtrack and check for next valid)
	 *         
	 *         Now when we check for 2nd queen there is no valid so backtrack
	 *         
	 *         x 1 x x
	 *         x x x 2
	 * 		   3 x x x
	 * 		   x x 4 x  (possible so return)
	 * 
	 * 			OR
	 * 
	 * 		   x x 1 x 
	 * 		   2 x x x
	 * 		   x x x 3
	 * 		   x 4 x x	 (possible so return)
	 * 
	 */

import java.util.Arrays;
import java.util.Scanner;


/*
 * N-Queens Problem
 * 
 * Find all the possible positions on the NxN chess-board where all N-Queens are safe.
 * 
 * Constraints:
 * 1. No two Queens can be on the same column
 * 2. No two Queens can be on the same row
 * 3. No two Queens can be on the same diagonal
 * 
 * Hint: The Queen can move to all eight directions (Top, Down, Left, Right, Upper Right, Upper Left, Lower Right and Lower Left).
 * 
 * Strategy: Column by Column || Row by Row (opt any one to solve it)
 * 
 * 
 */
 
public class N_Queen {

	private static Scanner input;
	
	private int N;
	
	private int[][] iBoard;
	
	
	
	static {
		input = new Scanner(System.in);
	}
	
	
	public N_Queen(int N) {

		System.out.print("N: ");
		N = input.nextInt();
		this.N = N;
	
	}
	
	public int getN() {
		return N;
	}
	
	public void create_iBoard(int size) {
		
		iBoard = new int[size][size];
		
		System.out.println("iBoard: ");

		for (int i = 0; i < N; i++) {
			Arrays.fill(iBoard[i], 0);
		}
		
	}
	
	public int[][] get_iBoard(){
		return iBoard;
	}
	
	public void show_iBoard(int[][] _iBoard) {

		System.out.println();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {		
				System.out.print(_iBoard[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	

	
	
	
	/*
	 * isQueenSafe in a Column && isQueenSafe in a Column && isQueenSafe in a Diagonal
	 */
	//LOGIC BUIDING CODE - SUPPORTER
	private boolean isSafe(int row, int col) {
		 
		int x, y;
	        
	    //checking if there is a queen in row or column
	    for(x=0; x<N; x++) {
	    	if((iBoard[row][x] == 1) || (iBoard[x][col] == 1)) {
	    		return true;
	        }
	    }
	    
	    //checking for diagonals
	    for(x=0; x<N; x++) {
	    	for(y=0; y<N; y++) {	
	                //For (2,3)
	            	/*
	            	 * 	(1,2)			(1,4)
	            	 * 			(2,3)
	            	 *  (3,2)			(3,4)
	            	 * 
	            	 * 	= (1+4) == (2+3)
	            	 *  = (3+2) == (2+3)
	            	 *  = (1-2) == (2-3)
	            	 *  = (3-4) == (2-3)
	            	 *    
	            	 */
	    		if(((x + y) == (row + col)) || ((x - y) == (row - col))) {
	    			if(iBoard[x][y] == 1) {
	    				return true;
	                }
	            }
	        }
	    
	    }
	        
	    return false;

	}
	
	
	/*
	 * Place the Queen
	 */
	//LOGIC BUIDING CODE
	public boolean place_nQueen(int n) {
		    
        //base case for n == 0
        if(n==0) {
            return true;
        }
        
        for(int row=0; row<N; row++){
        	
            for(int col=0; col<N; col++){
            	
            	//Is it a safe to place a Queen here...?
            	//if((!isSafe(row, col)) && (iBoard[row][col] != 1)){
            	if((!isSafe(row, col))){
                    		
            		iBoard[row][col] = 1;
                    
                    //Can we put the next Queen with this arrangement? CALLING RECURSIVELY...
                    if( place_nQueen(n-1) ){
                        return true;
                    }
                            
                    iBoard[row][col] = 0;
                
            	}
            
            }
        }
		
		return false;
	}
	
	
	
	//DRIVER CODE
	public static void main(String[] args) {
	
		int N = 0;
		N_Queen obj = new N_Queen(N);
		
		obj.create_iBoard(obj.getN());

		
		obj.show_iBoard(obj.get_iBoard());				//1. First: 	Get the Board as EMPTY
	
		obj.place_nQueen(obj.getN());					//2. Second: 	Place the Queen on the Board
			
		obj.show_iBoard(obj.get_iBoard());				//3. Third: 	Show the Board with Queens

		
		
	}

}











