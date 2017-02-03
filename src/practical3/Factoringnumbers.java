package practical3;

import javax.swing.JOptionPane;


public class Factoringnumbers {

	public static void main(String[] args){
		
		String str1,str2;
		int lower,higher;
		//ask for input 
		str1 = JOptionPane.showInputDialog(null,"Enter the first number");
		str2 = JOptionPane.showInputDialog(null,"Enter the second number");
		//convert string to double
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		//if statements to show relevant output
		if (num1 > num2)
		{ 
			lower = num2;
			higher = num1;
		}
		
		else 
		{
			lower = num1;
			higher = num2;
		}
		
		if (higher%lower == 0)
		{
			JOptionPane.showMessageDialog(null, lower +" is a factor of " +higher + ". \n "  + lower + " divides into " +higher +" "+ higher/lower + " times");
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, lower +" is not factor of " +higher + ". \n "  + lower + " divides into " +higher +" "+ higher/lower + " times, with a remainder of " + higher%lower);
		}

		
		System.exit(0);
		
	}
	
}
