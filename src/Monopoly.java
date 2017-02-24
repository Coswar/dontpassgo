import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Monopoly {

	public static final int MAX_NUM_PLAYERS = 6;
	public static final int NUM_SQUARES = 40;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private UI ui = new UI(players);
	
	Monopoly () {
		for (int p=0; p<MAX_NUM_PLAYERS; p++) {
			players.add(new Player());
		}		
		ui.display();
		return;
	}
	
	private void tour () {
			echo(0);
		for ( int p=0; p<MAX_NUM_PLAYERS; p++) {
			for (int i=0; i<NUM_SQUARES; i++) {
				players.get(p).move(+1);
				ui.display();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				} 
				p = echo(p);
			}
			
			String[] options = new String[] {"Continue", "Switch"};
			int result = JOptionPane.showOptionDialog(null, "Player"+p + "'s moves are finished. Would you "
					+ "like to continue or switch to input?", "Switch?",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
			if (result==JOptionPane.NO_OPTION) {
        	    p = MAX_NUM_PLAYERS; 
        	}
		}
		return;
	}
	
	private int echo (int p) {
		String command;
		ui.display();
		ui.displayString("  INPUT MODE\n" + "\n  Commands:\n " + "\n  'move': forward one square\n "
		+ "\n  'exit': exit game\n"+ "\n Enter player number (1-5) to switch to that player\n");
		do {
			command = ui.getCommand();
			ui.displayString(command);
			
			if(command.equals("exit")){
				String[] options = new String[] {"Yes", "No"};
				int result = JOptionPane.showOptionDialog(null, "Are you sure you would like to Exit?", "Exit?",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
				if (result==JOptionPane.YES_OPTION) {
	        	    System.exit(0);
	        	}
			}
			
			if (command.equals("1") || command.equals("2") || command.equals("3") || command.equals("4") || command.equals("5") || command.equals("6")){
				String command_2 = ui.getCommand();
				if(command_2.equals("move"))
				{
					return((Integer.valueOf((String) command))-1);
					}
		}
		
		} while (!command.equals("move"));
		
		ui.displayString("                                   Moving!");
		return(p);
	}
	
	public static void main (String args[]) {	
		Monopoly game = new Monopoly();		
		game.tour();
		game.echo(0);
		return;
	}
}