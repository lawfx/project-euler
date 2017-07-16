import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		//Run the program, paste the whole text with the names and press Enter to execute
		
		Scanner in = new Scanner(System.in);
		
		String line = in.nextLine();
		String[] names = line.split(",");
		in.close();
		for(int i = 0; i < names.length; i++){
			names[i] = names[i].substring(1, names[i].length() - 1);
		}
		Arrays.sort(names);
		
		long total = 0L;
		for(int i = 1;i<names.length + 1;i++){
			total += calculateNameScore(names[i - 1]) * i;
		}
		System.out.println(total);
	}
	
	static long calculateNameScore(String name){
		
		long nameScore = 0L;
		for(int i=0;i<name.length();i++){
			String character = name.substring(i, i+1);
			nameScore += characterScore(character);
		}
		return nameScore;
	}
	
	static int characterScore(String character){
		character = character.toUpperCase();
		if(character.equals("A")){
			return 1;
		}
		else if(character.equals("B")){
			return 2;
		}
		else if(character.equals("C")){
			return 3;
		}
		else if(character.equals("D")){
			return 4;
		}
		else if(character.equals("E")){
			return 5;
		}
		else if(character.equals("F")){
			return 6;
		}
		else if(character.equals("G")){
			return 7;
		}
		else if(character.equals("H")){
			return 8;
		}
		else if(character.equals("I")){
			return 9;
		}
		else if(character.equals("J")){
			return 10;
		}
		else if(character.equals("K")){
			return 11;
		}
		else if(character.equals("L")){
			return 12;
		}
		else if(character.equals("M")){
			return 13;
		}
		else if(character.equals("N")){
			return 14;
		}
		else if(character.equals("O")){
			return 15;
		}
		else if(character.equals("P")){
			return 16;
		}
		else if(character.equals("Q")){
			return 17;
		}
		else if(character.equals("R")){
			return 18;
		}
		else if(character.equals("S")){
			return 19;
		}
		else if(character.equals("T")){
			return 20;
		}
		else if(character.equals("U")){
			return 21;
		}
		else if(character.equals("V")){
			return 22;
		}
		else if(character.equals("W")){
			return 23;
		}
		else if(character.equals("X")){
			return 24;
		}
		else if(character.equals("Y")){
			return 25;
		}
		else{
			return 26;
		}
	}

}
