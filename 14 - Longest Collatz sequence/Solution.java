public class Solution {
	
	public static void main(String[] args) {
		
		long startNum = 999999L;
		
		int largestChain = 0;
		long finalNum = startNum;
		
		for(long i=startNum;i>0;i--){
			long currNum = i;
			int chain = 1;
			while(currNum > 1){
				if(currNum % 2 == 0){
					currNum = currNum / 2;
				}
				else{
					currNum = 3 * currNum + 1;
				}
				chain++;
			}
			if(chain > largestChain){
				largestChain = chain;
				finalNum = i;
			}
		}
		System.out.println(finalNum);
	}
}
