package bitmasking;

public class CheckBit {

	public CheckBit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=12;
		int checkBit=2;
		
		int mask=1<<checkBit;
		boolean isBitSet=(num & mask)!=0?true:false;
		System.out.println(isBitSet);

	}

}
