import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
				
		long sum = 0L;
		ArrayList<long[]> counted = new ArrayList<long[]>();
		for(int i = 2; i<10000; i++){
			
			ArrayList<long[]> primeFactors = findPrimeFactors(i);
			ArrayList<Long> divisors = findFactors(primeFactors);
			
			long firstSum = 0;
			for(int j = 0; j<divisors.size(); j++){
				firstSum += divisors.get(j);
			}
			firstSum -= i;
			if(firstSum != i){
				primeFactors = findPrimeFactors(firstSum);
				divisors = findFactors(primeFactors);
				
				long secondSum = 0;
				for(int j = 0; j<divisors.size(); j++){
					secondSum += divisors.get(j);
				}
				secondSum -= firstSum;
				
				if(secondSum == i){
					boolean foundMatch = false;
					for(int k=0;k<counted.size();k++){
						if((counted.get(k)[0] == i && counted.get(k)[1] == firstSum) || 
							counted.get(k)[1] == i && counted.get(k)[0] == firstSum){
							foundMatch = true;
							break;
						}
					}
					if(!foundMatch){
						sum += i + firstSum;
						counted.add(new long[]{i, firstSum});
					}
				}
			}
		}
		
		System.out.println(sum);
		
	}
	
	static ArrayList<Long> findFactors(ArrayList<long[]> primeFactors){
		
		ArrayList<Long> divisors = new ArrayList<Long>();
		if(primeFactors.size() > 1){
			long[][] primeTable = new long[(int)primeFactors.get(0)[1]+1][(int)primeFactors.get(1)[1]+1];
			ArrayList<long[][]> tables = new ArrayList<long[][]>();
			for(int i=0;i<primeFactors.get(0)[1]+1;i++){
				long firstNum = (long)Math.pow(primeFactors.get(0)[0], i);
				for(int j=0;j<primeFactors.get(1)[1]+1;j++){
					long secondNum = (long)Math.pow(primeFactors.get(1)[0], j);
					primeTable[i][j] = firstNum * secondNum;
					divisors.add(primeTable[i][j]);
				}
			}
			tables.add(primeTable);
			for(int i = 2; i<primeFactors.size();i++){
				for(int j = 0;j<primeFactors.get(i)[1];j++){
					int addedtables = 0;
					for(int k=j; k<tables.size() - addedtables; k++){
						primeTable = new long[(int)primeFactors.get(0)[1]+1][(int)primeFactors.get(1)[1]+1];
						for(int g = 0;g<tables.get(k).length;g++){
							for(int l = 0;l<tables.get(k)[0].length;l++){
								primeTable[g][l] = tables.get(k)[g][l] * primeFactors.get(i)[0];
								divisors.add(primeTable[g][l]);
							}
						}
						tables.add(primeTable);
						addedtables++;
					}
				}
			}
		}
		else{
			long prod = 1L;
			if(primeFactors.get(0)[0] > 1){
				divisors.add(1L);
			}
			for(int i=1;i<primeFactors.get(0)[1]+1;i++){
				prod *= primeFactors.get(0)[0];
				divisors.add(prod);
			}
		}
		return divisors;
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
