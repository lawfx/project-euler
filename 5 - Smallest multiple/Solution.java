public class Solution {
	
	public static void main(String[] args) {
		
		long number = 0L;
		for(long i = 20;i<Long.MAX_VALUE;i++){
			boolean divisible = true;
			for(int j = 2; j < 21 ; j++){
				if(i % j != 0){
					divisible = false;
					break;
				}
			}
			if(divisible){
				number = i;
				break;
			}
		}
		
		System.out.println(number);
	}
}
