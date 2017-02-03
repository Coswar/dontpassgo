package practical3;

import javax.swing.JOptionPane;

public class Mysecret{
	
	public static void main(String[] args){
		//define string as name 
		String programmername = "Callum";
		//ask for input
		String inputname = JOptionPane.showInputDialog(null,"Enter your name");
		//use if statements to compare input to programmername
		if( inputname.equalsIgnoreCase(programmername))
		{
			String secret = JOptionPane.showInputDialog(null, "Hi," + inputname + ", tell me a secret!");
			//then ask for input if the names match, and prompt different dialogs based on size of input
			if(secret.length() < 20)
			{
				JOptionPane.showMessageDialog(null, "That's not much of a secret!");
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "That's a good secret, I'll never tell!");
			}
		}
		//do not prompt for input if the name is different
		else
		{
			JOptionPane.showMessageDialog(null, "Hello " +inputname +", nice to meet you.");
		}

			
		System.exit(0);
		
	}

}
