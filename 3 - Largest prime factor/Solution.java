public class Solution {
	
	public static void main(String[] args) {
		
		long largest = 0L;
		
		long numToCheck = 600851475143L;
		
		long res = numToCheck;
		long div = 2;
		while(res != 1){
			if(res % div != 0){
				div++;
			}
			else{
				res = res / div;
				if(div > largest){
					largest = div;
				}
				else{
					div = 2;
				}
			}
		}
		
		System.out.println(largest);
	}
}
