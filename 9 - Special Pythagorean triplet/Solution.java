public class Solution {
	
	public static void main(String[] args) {
		
		int prod = 0;
		for(int i = 1;i<1000;i++){
			for(int j=i;j<1000;j++){
				for(int k=j;k<1000;k++){
					if(Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2)){
						if(i+j+k == 1000){
							prod = i*j*k;
							break;
						}
					}
				}
				if(prod != 0){
					break;
				}
			}
			if(prod != 0){
				break;
			}
		}
		System.out.println(prod);
	}
}
