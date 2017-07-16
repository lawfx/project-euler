public class Solution {
	
	public static void main(String[] args) {
		
		int cntMondays = 0;
		int day = 1; //1 monday, 2 tuesday...
		for(int y = 1900; y < 2001; y++){
			for(int m=1;m<13;m++){
				
				if(y>1900 && day == 7){
					cntMondays++;
				}
				
				int daysToPass = 31;
				if(m == 4 || m == 6 || m == 9 || m == 11){
					daysToPass = 30;
				}
				else if(m == 2){
					daysToPass = 28;
					if(isLeapYear(y)){
						daysToPass = 29;
					}
				}
				for(int d = 1; d < daysToPass + 1; d++){
					day++;
					if(day == 8){
						day = 1;
					}
				}
			}
		}
		System.out.println(cntMondays);
		
	}
	
	static boolean isLeapYear(int year){
		if(year % 100 == 0){
			if(year % 400 == 0){
				return true;
			}
			return false;
		}
		else{
			if(year % 4 == 0){
				return true;
			}
			return false;
		}
	}
}
