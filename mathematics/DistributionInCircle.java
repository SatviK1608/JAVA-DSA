package mathematics;

public class DistributionInCircle {

	public DistributionInCircle() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//a:Chocolates
		//b:Children
		//c:Starting pos
		//x:find the last position of the children who recieved a chocolate 
		
		int a=21,b=7,c=6;
		
		int x=(c+a-1)%b==0?b:(c+a-1)%b;
		System.out.println(x);
	}

}
