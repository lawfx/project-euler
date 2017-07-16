import java.math.*;

public class Solution {

	static long index = 0L;
	
	public static void main(String[] args) {
		
		fib(BigInteger.valueOf(1), BigInteger.valueOf(1), 2);
		System.out.println(index);
		
	}
	
	static void fib(BigInteger one,BigInteger two, long currIndex){
				
		currIndex++;
		BigInteger nextNum = one.add(two);
		if(nextNum.toString().length() == 1000){
			index = currIndex;
			return;
		}
		
		fib(two, nextNum, currIndex);
		return;
		
	}
}
