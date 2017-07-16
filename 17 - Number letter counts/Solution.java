public class Solution {
	
	public static void main(String[] args) {
		
		long sum = 0L;
		
		for(int i = 1; i < 1001; i++){
			
			String number = "";
			
			int thousands =  i / 1000;
			int hundreds = i / 100;
			if(hundreds > 9){
				hundreds = hundreds % 10;
			}
			int tens = i / 10;
			if(tens > 9){
				tens = tens % 10;
			}
			int units = i % 10;
			
			if(thousands == 1){
				number += "onethousand";
			}
			number += findUnit(hundreds);
			if(hundreds > 0){
				number +="hundred";
				if(tens > 0 || units > 0){
					number +="and";
				}
			}
			if(tens > 1){
				number += findTens(tens);
				number += findUnit(units);
			}
			else{
				if(tens == 1){
					number += findTeens(tens*10 + units);
				}
				else{
					number += findUnit(units);
				}
			}
			
			sum += number.length();
		}
		System.out.println(sum);
	}
	
	static String findTeens(int num){
		if(num == 10){
			return "ten";
		}
		else if(num == 11){
			return "eleven";
		}
		else if(num == 12){
			return "twelve";
		}
		else if(num == 13){
			return "thirteen";
		}
		else if(num == 14){
			return "fourteen";
		}
		else if(num == 15){
			return "fifteen";
		}
		else if(num == 16){
			return "sixteen";
		}
		else if(num == 17){
			return "seventeen";
		}
		else if(num == 18){
			return "eighteen";
		}
		else{
			return "nineteen";
		}
	}
	
	static String findTens(int num){
		if(num == 2){
			return "twenty";
		}
		else if(num == 3){
			return "thirty";
		}
		else if(num == 4){
			return "forty";
		}
		else if(num == 5){
			return "fifty";
		}
		else if(num == 6){
			return "sixty";
		}
		else if(num == 7){
			return "seventy";
		}
		else if(num == 8){
			return "eighty";
		}
		else{
			return "ninety";
		}
	}
	
	static String findUnit(int num){
		if(num == 1){
			return "one";
		}
		else if(num == 2){
			return "two";
		}
		else if(num == 3){
			return "three";
		}
		else if(num == 4){
			return "four";
		}
		else if(num == 5){
			return "five";
		}
		else if(num == 6){
			return "six";
		}
		else if(num == 7){
			return "seven";
		}
		else if(num == 8){
			return "eight";
		}
		else if(num == 9){
			return "nine";
		}
		else{
			return "";
		}
	}
}
