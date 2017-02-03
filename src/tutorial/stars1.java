package tutorial;

import javax.swing.JOptionPane;

public class stars1 {
	
	public static void main(String[] args){
		//define strings
		String str,star = "*";		
		//input number of stars to be printed and convert to int
		str = JOptionPane.showInputDialog(null,"Enter an integer");
		int x = Integer.parseInt(str);
		
		//use nested loop to print each line using 2 counters(one for location on line & 1 for which line)
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(star);
			}	
			System.out.print("\n");
		}
	}
}