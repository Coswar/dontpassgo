package tutorial;

import javax.swing.JOptionPane;

public class WordsLength {
	
	public static void main(String[] args){
		//define strings and counter int
		String str = null;
		int totallen = 0;
		//loop for input while not blank
		do
		{
			str = JOptionPane.showInputDialog(null,"Enter a string");
			//add the lenght of each string to the current length total
			totallen = totallen + str.length();
		}while(str.length() != 0); 
		//output the length of strings combined
		JOptionPane.showMessageDialog(null, "The total amount of character(s) in the string(s) are "+ totallen);
		System.exit(0);
	}
}
