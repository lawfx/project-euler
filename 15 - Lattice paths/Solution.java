import java.math.*;

public class Solution {
	
	public static void main(String[] args) {
		
		int gridSize = 20;
		
		BigInteger paths = countLatticePaths(gridSize);
		
		System.out.println(paths);
	}
	
	static BigInteger countLatticePaths(int gridSize){
		int topnum = gridSize + gridSize;
		int bottomnum = gridSize;
		BigInteger numerator = fact(BigInteger.valueOf(topnum));
		BigInteger denominator = fact(BigInteger.valueOf(bottomnum)).multiply(fact(BigInteger.valueOf(topnum).subtract(BigInteger.valueOf(bottomnum))));
		return numerator.divide(denominator);
	}
	
	static BigInteger fact(BigInteger num){
		
		if(num.equals(BigInteger.valueOf(0))){
			return new BigInteger("1");
		}
		return num.multiply(fact(num.subtract(BigInteger.valueOf(1))));
	}
}
