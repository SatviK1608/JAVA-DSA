package bitmasking;

public class SetBit {

	public SetBit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=10;       	// 1010
		int setBit=2;     	// setting 3rd bit
		
		int mask=1<<setBit;
		
		System.out.println(num|mask);       // 1010 | 0100 = 1110

	}

}
