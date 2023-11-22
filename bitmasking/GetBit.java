package bitmasking;

public class GetBit {

	public GetBit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=12;   // 1100
		int pos=3; 		//getting 4th bit
		
		int mask=1<<pos;
		int ans=(mask & number)!=0?1:0;          // 1100 & 1000 = 1000
		System.out.println(ans);
		

	}

}
