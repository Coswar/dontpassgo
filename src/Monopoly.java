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
		//ui.displayString("TOUR MODE");
		for (int p=0; p<MAX_NUM_PLAYERS; p++) {
			for (int i=0; i<NUM_SQUARES; i++) {
				players.get(p).move(+1);
				ui.display();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				} 
				echo();
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
	
	private void echo () {
		String command;
		ui.display();
		ui.displayString("   INPUT MODE" + "\n  Commands:" + "\n  'move'"+ "\n  'exit'");
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
		} while (!command.equals("move"));
		
		ui.displayString("Moving!");
		return;
	}
	
	public static void main (String args[]) {	
		Monopoly game = new Monopoly();		
		game.tour();
		game.echo();
		return;
	}
}