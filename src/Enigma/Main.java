package Enigma;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		
//My changes

		int pseudoRandomNumber = 9;
		
		CypherTool cypherTool = new CypherTool(pseudoRandomNumber, setRotors());
		DecypherTool decypherTool = new DecypherTool(pseudoRandomNumber, setRotors());
		
		String toEncript = "EVERYONEISWELCOMEHERE";
		String toDecript = "PQSACVVTOISXFXCIAMQEM";
		
		System.out.println(cypherTool.encode(toEncript));
		System.out.println(decypherTool.decode(toDecript));
		
		
		
	}
	
	//Personalize rotors.
	public static List<char[]> setRotors() {
	List<char[]> rotors = new ArrayList<char[]>();
	rotors.add("BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray()); 
    rotors.add("AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray());
    rotors.add("EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray());
    
       return rotors;
        
	}
}
