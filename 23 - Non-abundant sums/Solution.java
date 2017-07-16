import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		ArrayList<Long> abundants = new ArrayList<Long>();
		
		for(long i = 12; i < 28124; i++){
			ArrayList<Long> divisors = findFactors(findPrimeFactors(i));
			long sumDivisors = 0L;
			for(int j=0;j<divisors.size();j++){
				sumDivisors += divisors.get(j);
			}
			sumDivisors -= i;
			if(sumDivisors > i){
				abundants.add(i);
			}
		}
		long sum = 0L;
		for(int i = 1; i < 28124; i++){
			if(i <= abundants.get(0)){
				sum += i;
			}
			else{
				int maxToStart = -1;
				for(int j = 0; j < abundants.size(); j++){
					if(i == abundants.get(j) * 2){
						break;
					}
					if(abundants.get(j) >= i){
						maxToStart = j - 1;
						break;
					}
				}
				if(maxToStart != -1){
					boolean ended = false;
					while(!ended){
						boolean gotIn = false;
						for(int j = 0; j < maxToStart; j++){
							gotIn = true;
							if(abundants.get(maxToStart) + abundants.get(j) == i){
								ended = true;
								break;
							}
							if(abundants.get(maxToStart) + abundants.get(j) > i){
								maxToStart--;
								break;
							}
							if(abundants.get(maxToStart) + abundants.get(maxToStart - 1) < i){
								sum += i;
								ended = true;
								break;
							}
						}
						if(!gotIn){
							sum += i;
							break;
						}
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
