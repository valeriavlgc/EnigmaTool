package Enigma;

import java.util.ArrayList;
import java.util.List;

public class DecypherTool {

	protected int pseudoRandomNumber;
	protected List<char[]> rotors = new ArrayList<char[]>();
	protected String message;
	protected final char[] alphabet;
	
	public DecypherTool (int randomNumber, List<char[]> rotors) {
		this.pseudoRandomNumber = randomNumber;
		this.rotors             = rotors;
		this.alphabet           = ("abcdefghijklmnopqrstuvwxyz").toUpperCase().toCharArray();
	}	
	
	public String decode(String message) {
	char[] currentRotor;
    int newChar;
    String newMessage = "";
    char[] charMessage = message.toCharArray();
    int position = 0;
    String result;
    
    result = "Decripting -> " + message + "\n";
    
		for (int i = rotors.size() - 1; i >= 0; i--) {
	        
	        currentRotor = rotors.get(i);
	        	
	        	for(int j = 0; j < charMessage.length ; j++) {
	        		position = findChar(currentRotor, charMessage[j]);
	                charMessage[j] = alphabet[position];
	        	}
	        	
	       result += "Rotor " + (i+1) + ": " + String.valueOf(charMessage) + "\n";
	   	        	
		}    

	    for (int j = 0; j < message.length(); j++) {        
	       	 
	    	newChar = charMessage[j] - pseudoRandomNumber - j + 26;

           	while (newChar > 90) {
           		newChar = (newChar - 90) + 64;        		
           	}
	           	
	          newMessage += Character.toString(newChar);
	       	        	
	         }
	       	       
	   
	     result += "Last step (-" + pseudoRandomNumber + "): " + newMessage;
	   
	   return result;
		
	}
	
	public static int findChar(char[] rotor, char c) {
    int position = 0;
    boolean find = false;
    int i = 0;

        do {

            if (c == rotor[i]) {
            position = i;
            find = true;
          } 

            i++;

        }  while(!find && i < rotor.length);
        
        return position;

     }

}
