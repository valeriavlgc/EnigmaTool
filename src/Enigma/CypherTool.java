package Enigma;

import java.util.ArrayList;
import java.util.List;

public class CypherTool  {
	
	protected int pseudoRandomNumber;
	protected List<char[]> rotors = new ArrayList<char[]>();
	protected final char[] alphabet;
	
	public CypherTool (int randomNumber, List<char[]> rotors) {
		this.pseudoRandomNumber = randomNumber;
		this.rotors             = rotors;
		this.alphabet           = ("abcdefghijklmnopqrstuvwxyz").toUpperCase().toCharArray();
		
	}

	public String encode(String message) {
    char[] currentRotor;
    int newChar;
    String newMessage = "";
    int position = 0;
    String result;
    
    result = "Encripting -> " + message + "\n";
	
        for (int j = 0; j < message.length(); j++) {        
          	
            newChar = message.charAt(j) + pseudoRandomNumber + j;

              	while (newChar > 90) {
              		newChar = (newChar - 90) + 64;        		
              	}
              	
            newMessage += Character.toString(newChar);          	        	
         }
          	        

       result += "First step " + "(" + pseudoRandomNumber + "): " + newMessage + "\n";
           
	 char[] charMessage = newMessage.toCharArray();
              
           //Rotors
       for (int i = 0; i < rotors.size(); i++) {
       
       currentRotor = rotors.get(i);
       	
	       	for(int j = 0; j < charMessage.length ; j++) {
	       		position = findChar(charMessage[j]);
	               charMessage[j] = currentRotor[position];
	       	}
       	
        result += "Rotor " + (i+1) + ": " + String.valueOf(charMessage) + "\n";
  	        	
  	    }
       
       return result;
		
	}

	public int findChar(char c) {
	int position = 0;
    boolean find = false;
    int i = 0;

	    do {
	
	        if (c == alphabet[i]) {
	        position = i;
	        find = true;
	      } 
            i++;
         }  while (!find && i < alphabet.length);
        
        return position;

	}

}
