import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		
		long triangle = 0L;
		
		for(long i = 1;i < Long.MAX_VALUE;i++){
			triangle += i;

			ArrayList<int[]> primeFactorCnt = new ArrayList<int[]>(); 
			
			long res = triangle;
			int div = 2;
			while(res != 1){
				if(res % div != 0){
					div++;
				}
				else{
					res = res / div;
					boolean foundIt = false;
					for(int j=0;j<primeFactorCnt.size();j++){
						if(primeFactorCnt.get(j)[0] == div){
							primeFactorCnt.get(j)[1]++;
							foundIt = true;
							break;
						}
					}
					if(!foundIt){
						primeFactorCnt.add(new int[]{div, 1});
					}
					div = 2;
				}
			}
			
			int prod = 1;
			for(int j=0;j<primeFactorCnt.size();j++){
				prod *= primeFactorCnt.get(j)[1] + 1;
			}
			
			if(prod > 500){
				break;
			}
		}
		System.out.println(triangle);
		
	}	
}
