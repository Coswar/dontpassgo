package tutorial;
//import joptionpane to process windows
import javax.swing.JOptionPane;

public class Wordslength2 {
	
	public static void main(String[] args){
		//create array to store the words
		String str[]= new String[100];
		//create strings to hold the words
		String forwards = "",backwards= "";
		//create integer as counter
		int i = 0;
		//do while loop to process strings into both forwards and backwards versions
		do
		{
			str[i] = JOptionPane.showInputDialog(null,"Enter a string");
			forwards = (str[i] + " " + forwards);
			backwards = (backwards + " " + str[i]);
			i++;
			
		}while(str[i-1].length() != 0); 
		// print out the strings in both versions
		JOptionPane.showMessageDialog(null,backwards );
		
		JOptionPane.showMessageDialog(null,forwards );
		
		System.exit(0);
	}
}