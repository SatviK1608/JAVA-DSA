package bitmasking;

public class ClearBit {

	public ClearBit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=14;           // 1110
		int pos=1;
		
		int mask=~(1<<pos);  // ~(0010) = 1101
		 
		System.out.println(num & mask);  // 1110 & 1101 = 1100

	}

}
