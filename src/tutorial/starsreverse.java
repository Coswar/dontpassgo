package tutorial;

import javax.swing.JOptionPane;

public class starsreverse {
	
	public static void main(String[] args){
		//define strings
		String str,star = "*";		
		//input number of stars to be printed and convert to Int
		str = JOptionPane.showInputDialog(null,"Enter an integer");
		int x = Integer.parseInt(str);
		
		//use nested loop to print each line using 2 counters(one for location on line & 1 for which line)
		//count down instead of up to reverse the output 
		for(int i=x;i>=0;i--)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(star);
			}	
			System.out.print("\n");
		}
		System.exit(0);
	}
}