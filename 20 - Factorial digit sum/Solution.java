import java.math.*;

public class Solution {
	
	public static void main(String[] args) {
		
		BigInteger numToFact = fact(BigInteger.valueOf(100));
		String str = numToFact.toString();
		String[] parts = str.split("");
		long cnt = 0L;
		for(int i = 0; i < str.length(); i++){
			cnt += Integer.parseInt(parts[i]);
		}
		System.out.println(cnt);
	}
	
	static BigInteger fact(BigInteger num){
			
			if(num.equals(BigInteger.valueOf(0))){
				return new BigInteger("1");
			}
			return num.multiply(fact(num.subtract(BigInteger.valueOf(1))));
		}
}
