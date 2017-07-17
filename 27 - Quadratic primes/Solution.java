public class Solution {
	
	public static void main(String[] args) {		
		
		int consPrimes = 0;
		int prod = 0;
		for(int a = -1000;a<1000;a++){
			for(int b = -1000;b<1001;b++){
				int primeCnt = 0;
				for(int n = 0; n<1000;n++){
					long number = (long) Math.pow(n, 2) + a*n + b;
					if(isPrime(Math.abs(number))){
						primeCnt++;
					}
					else{
						break;
					}
				}
				if(primeCnt > consPrimes){
					consPrimes = primeCnt;
					prod = a*b;
				}
			}
		}
		System.out.println(prod);
	}
	
	static boolean isPrime(long n) {
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(long i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}
