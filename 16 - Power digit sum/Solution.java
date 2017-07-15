import java.math.*;

public class Solution {
	
	public static void main(String[] args) {
		
		BigInteger big = new BigInteger("2");
		big = big.pow(1000);
		String bigStr = big.toString();
		String[] parts = bigStr.split("");
		int sum = 0;
		for(int i = 0; i < bigStr.length();i++){
			sum += Integer.valueOf(parts[i]);
		}
		
		System.out.println(sum);
	}
}
