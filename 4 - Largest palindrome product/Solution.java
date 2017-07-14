public class Solution {
	
	public static void main(String[] args) {
		
		int largest = 0;
		for(int i = 999;i>99;i--){
			for(int j = i;j>99;j--){
				int prod = i*j;
				if(prod < largest){
					break;
				}
				if(isPalindrome(i*j)){
					if(prod > largest){
						largest = prod;
					}
				}
			}
		}
		System.out.println(largest);
	}
	
	static boolean isPalindrome(int toCheck){
		
		String str = String.valueOf(toCheck);
		String[] parts = str.split("");
		boolean isSame = true;
			for(int i=0;i<parts.length/2;i++){
				if(!parts[i].equals(parts[parts.length - 1 - i])){
					isSame = false;
					break;
				}
			}
			return isSame;
	}
}
