public class Solution {
	
	public static void main(String[] args) {
		
		long totalSum = 0;
		for(int i = 10;i<200000;i++){
			String num = String.valueOf(i);
			
			long sum = 0;
			for(int j=0;j<num.length();j++){
				sum += Math.pow(Integer.valueOf(num.substring(j, j+1)), 5);
			}
			if(sum == i){
				totalSum += i;
			}
		}
		System.out.println(totalSum);
	}
}
