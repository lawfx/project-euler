public class Solution {
	
	public static void main(String[] args) {
		
		long index = 0L;
		long number = 0L;
		for(long i=0;i<Long.MAX_VALUE;i++){
			if(isPrime(i)){
				index++;
			}
			if(index == 10001){
				number = i;
				break;
			}
		}
		System.out.println(number);
	}
	
	public static boolean isPrime(long n) {
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
