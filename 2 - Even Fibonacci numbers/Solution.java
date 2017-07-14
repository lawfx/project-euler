public class Solution {
	
	public static void main(String[] args) {
		
		long sum = 0L;
		
		sum = Fib(1, 2, 0);
		System.out.println(sum);

	}
	
	static long Fib(int one,int two, long evenSum){
		
		if(two > 4000000){
			return evenSum;
		}
		
		if(two % 2 == 0){
			evenSum += two;
		}
		
		int nextNum = one + two;
		evenSum = Fib(two, nextNum, evenSum);
		return evenSum;
		
	}

}
