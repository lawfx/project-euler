import java.math.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		
		String[] nums = new String[9801];
		int index = 0;
		for(int a=2;a<101;a++){
			for(int b=2;b<101;b++){
				BigInteger big = BigInteger.valueOf(a).pow(b);
				nums[index] = big.toString();
				index++;
			}
		}
		Arrays.sort(nums);
		int cnt = 1;
		String curr = nums[0];
		for(int i = 0;i<nums.length;i++){
			if(!curr.equals(nums[i])){
				cnt++;
				curr = nums[i];
			}
		}
		System.out.println(cnt);
		
	}
}
