package practical3;

import javax.swing.JOptionPane;


public class comparetwonumbers {

	public static void main(String[] args){
		
		String str1,str2;
		//ask for input 
		str1 = JOptionPane.showInputDialog(null,"Enter the first number");
		str2 = JOptionPane.showInputDialog(null,"Enter the second number");
		//convert string to double
		Double num1 = Double.parseDouble(str1);
		Double num2 = Double.parseDouble(str2);
		//if statements to show relevant output
		if (num1 > num2)
		{ 
			JOptionPane.showMessageDialog(null, "The first number " +num1 + " is larger than " +num2);
		}
		
		if (num2 > num1)
		{
			JOptionPane.showMessageDialog(null, "The second number " +num2 + " is larger than " +num1);
		}
		
		System.exit(0);
		
	}
	
}
