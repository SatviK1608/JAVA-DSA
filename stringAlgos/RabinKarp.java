package stringAlgos;

public class RabinKarp {
	
	//TC:O(nm) in worst case and O(n+m) in general
	//SC:O(m)

	public RabinKarp() {
		
		
	}

	public static void main(String[] args) {
		
		String _s="BACBAABACABCBABB";
		String _patt="CBA";
		
		int n=_s.length();
		int m=_patt.length();
        int D=256;
		int sHV=0,pHV=0,HV=1,q=11,i,j;
		
		HV=(int)(Math.pow(D,m-1)%q);
		
		for(i=0;i<m;i++){
			pHV=(D*pHV+_patt.charAt(i))%q;
			sHV=(D*sHV+_s.charAt(i))%q;
		}
		
		for(i=0;i<=n-m;i++){
			if(pHV==sHV){
				for(j=0;j<m;j++){
					if(_s.charAt(i+j)!=_patt.charAt(j))
						break;
				}
				
				if(j==m)
					System.out.println("Pattern is found at position: "+(i));
				
			}
			
			if(i<n-m){
				sHV=((D*(sHV- _s.charAt(i)*HV))+_s.charAt(i+m))%q;
				
				if(sHV<0)
					sHV+=q;
			}
		}

	}

}
