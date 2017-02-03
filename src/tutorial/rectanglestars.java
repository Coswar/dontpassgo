package tutorial;

//import JOption
import javax.swing.JOptionPane;

public class rectanglestars {
	
	public static void main(String[] args){
		//define string variables 
		String width,height,star = "*";		
		//prompt for input
		width = JOptionPane.showInputDialog(null,"Enter the width");
		height = JOptionPane.showInputDialog(null,"Enter the height");
		//convert input to integer
		int w = Integer.parseInt(width);
		int h = Integer.parseInt(height);
		int count = 0;
		//loop from the width down to 0
		for(int x = w; x>0; x--){
			//print out top line of stars
			System.out.print(star);
			//add to the counter of the line
			count++;
		}
		//new line
		System.out.print("\n");
		//print middle lines (spaces and lines)
		for(count = 1; count <=h-2; count++)
		{	
			System.out.print(star);
			//print spaces to the width minus the stars
			for(int x = 0; x<w-2;x++){
				
				System.out.print(" ");
			}
			//print the end star and a new line to continue shape
			System.out.print(star);
			System.out.print("\n");
			
		}
		//print base line 
		for(int x = w; x>0; x--){
			
			System.out.print(star);
		}
	

		System.exit(0);
	}
}