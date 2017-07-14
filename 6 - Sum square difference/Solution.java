public class Solution {
	
	public static void main(String[] args) {
		
		long sumOfSquares = 0L;
		long squareOfSums = 0L;
		
		for(int i=1;i<101;i++){
			sumOfSquares += Math.pow(i, 2);
			squareOfSums += i;
		}
		
		squareOfSums = (long)Math.pow(squareOfSums, 2);
		
		System.out.println(squareOfSums - sumOfSquares);
	}
}
