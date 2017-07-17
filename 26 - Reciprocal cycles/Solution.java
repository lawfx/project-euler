import java.math.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) {		
		
		int whichNum = 0;
		int chain = 0;
		for(int i=2;i<1000;i++){
			if(isRecurring(Integer.valueOf(i))){
				BigDecimal num = BigDecimal.valueOf(1).divide((BigDecimal.valueOf(i)), 2000, RoundingMode.UP);
				String numStr = String.valueOf(num);
				String decimal = numStr.split("\\.")[1];
				int currChain = 0;
				boolean foundMatch = false;
				int sameNumberCnt = 1;
				while(!foundMatch){
					String character = decimal.substring(0,1);
					for(int j=1;j<decimal.length();j++){
						if(decimal.substring(j,j+1).equals(character)){
							foundMatch = true;
							sameNumberCnt++;
						}
					}
					if(!foundMatch){
						decimal = decimal.substring(1, decimal.length());
					}
					if(sameNumberCnt == decimal.length()){
						currChain = 1;
					}
				}
				if(currChain == 0){
					if(decimal.length() % 2 != 0){
						decimal = decimal.substring(0, decimal.length() - 1);
					}
					
					int index = decimal.length() / 2;
					String subString1 = decimal.substring(0, index);
					String subString2 = decimal.substring(index,decimal.length());
					while(subString1.length() > 1){
						boolean isSame = true;
						for(int j=0;j<index;j++){
							if(!subString1.substring(j,j+1).equals(subString2.substring(j,j+1))){
								isSame = false;
								break;
							}
						}
						if(isSame){
							currChain = subString1.length();
						}
						decimal = decimal.substring(0, decimal.length() - 2);
						index = decimal.length() / 2;
						subString1 = decimal.substring(0, index);
						subString2 = decimal.substring(index,decimal.length());
					}
				}
				
				if(currChain > chain){
					chain = currChain;
					whichNum = i;
				}
			}
		}
		System.out.println(whichNum);
	}
	
	static boolean isRecurring(int num){
		
		ArrayList<long[]> primeFactors = findPrimeFactors(num);
		boolean isRec = false;
		for(int i=0;i<primeFactors.size();i++){
			if(primeFactors.get(i)[0] != 2 && primeFactors.get(i)[0] != 5){
				isRec = true;
				break;
			}
		}
		return isRec;
	}
	
	static ArrayList<long[]> findPrimeFactors(long num){
		
		ArrayList<long[]> primeFactors = new ArrayList<long[]>();
		
		if(num == 1){
			primeFactors.add(new long[]{1, 1});
			return primeFactors;
		}
		else if(num == 0){
			primeFactors.add(new long[]{0, 1});
			return primeFactors;
		}
		
		long div = 2;
		while(num != 1){
			if(num % div != 0){
				div++;
			}
			else{
				num = num / div;
				boolean foundIt = false;
				for(int j=0;j<primeFactors.size();j++){
					if(primeFactors.get(j)[0] == div){
						primeFactors.get(j)[1]++;
						foundIt = true;
						break;
					}
				}
				if(!foundIt){
					primeFactors.add(new long[]{div, 1});
				}
			}
		}
		return primeFactors;
	}
}
