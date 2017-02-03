package practical3;

import javax.swing.JOptionPane;

	public class radius{

	public static void main(String[] args)
	{
		//prompt for which type of shape the user would like to work with
		String str = JOptionPane.showInputDialog("Would you like to compute the area of a 'Square','triangle','Circle'?");
		//square if statement
		if(str.equals("square"))
		{
			//accept input of length and convert to double
			String side = JOptionPane.showInputDialog("Enter the length of the square's side: ");
			Double numside = Double.parseDouble(side);
			//find area and output
			if( numside > 0 )
			{
				JOptionPane.showMessageDialog(null, "The area of the square is " + numside*numside);
			}
			//catch input error
			else
			{
				JOptionPane.showMessageDialog(null, "Length value less than zero: cannot compute square area.");
			}
			
		}
		
		if(str.equals("circle"))
		{
			//accept input of radius and convert to double
			String radius = JOptionPane.showInputDialog("Enter the length of the circle's radius: ");
			Double numradius = Double.parseDouble(radius);
			//find area and output
			if( numradius > 0 )
			{
				JOptionPane.showMessageDialog(null, "The area of the circle is " + numradius*numradius*3.1416);
			}
			//catch input error
			else
			{
				JOptionPane.showMessageDialog(null, "Radius value less than zero: cannot compute circle area.");
			}
			

		}
		
		if(str.equals("triangle"))
		{
			//accept input of length and height and convert to double
			String trside = JOptionPane.showInputDialog("Enter the height of the triangle: ");
			String trbase = JOptionPane.showInputDialog("Enter the length of the triangle's base: ");
			Double trnumside = Double.parseDouble(trside);
			Double trnumbase = Double.parseDouble(trbase);
			//find area and output
			if( trnumside > 0 && trnumbase > 0)
			{
				JOptionPane.showMessageDialog(null, "The area of the triangle is " + 0.5*trnumbase*trnumside);
			}
			//catch input error
			else
			{
				JOptionPane.showMessageDialog(null, "Height/length value less than zero: cannot compute triangle area.");
			}
			
		}
		//catch error in choice of shape
		else
		{
			JOptionPane.showMessageDialog(null, "Incorrect input, please re-try");
		}
		
		System.exit(0);
	}
	
	}
