public class Solution {
	
	public static void main(String[] args) {
		
		long sum = 10L;
		
		int[] nums = new int[500];
		nums[0] = 9;
		for(int i = 1;i<500;i++){
			nums[i] = nums[i-1]+8*(i+1);
			sum += nums[i];
		}
		for(int j = 0;j<3;j++){
			for(int i = 0; i<500;i++){
				nums[i] -= 2*(i+1);
				sum += nums[i];
			}
		}
		System.out.println(sum);
	}
}
