package bitmasking;

public class ToggleBit {

	public ToggleBit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=12;    // 1100
		int toggleBit=2;   
		
		int mask=1<<toggleBit;
		
		boolean checkBit = (num & mask)!=0?true:false;
		
		if(checkBit){

			//clearBit logic as ith bit is 1
			System.out.println( num & (~mask) );
			
		}
		else{
			
			//setBit logic as ith bit is 0
			System.out.println( num | mask );
			
		}

	}

}
