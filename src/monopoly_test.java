import java.util.ArrayList;

import javax.swing.JOptionPane;

public class monopoly_test {

	public static final int MAX_NUM_PLAYERS = 6;
	public static final int NUM_SQUARES = 40;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private UI ui = new UI(players);
	
	monopoly_test () {
		for (int p=0; p<MAX_NUM_PLAYERS; p++) {
			players.add(new Player());
		}		
		ui.display();
		return;
	}
	
	private int tour(int current_player) {
	
		for ( int p=current_player; p<MAX_NUM_PLAYERS; p++) {
			for (int i=0; i<NUM_SQUARES; i++) {
				players.get(p).move(+1);
				ui.display();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				} 
				echo(current_player);
			}
			
			String[] options = new String[] {"Continue", "Switch"};
			int result = JOptionPane.showOptionDialog(null, "Player"+p + "'s moves are finished. Would you "
					+ "like to continue or switch to input?", "Switch?",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
			
			if (result==JOptionPane.NO_OPTION) {
        	    current_player = MAX_NUM_PLAYERS; 
        	}
		}
		return(current_player);
	}
	
	private int echo (int current_player) {
		String command;
		ui.display();
		ui.displayString("  INPUT MODE\n" + "\n  Commands:\n " + "\n  'move': forward one square\n "
		+ "\n  'exit': exit game\n"+ "\n Enter player number (1-5) to switch to that player\n");
		
		do {
			command = ui.getCommand();
			ui.displayString(command);
			
			if(command.equals("move")){
				current_player = tour(current_player);
				echo(current_player);
				ui.displayString("                                   Moving!");
			}
			
			if (command.equals("end turn")){
				current_player = tour(current_player + 1);
				echo(current_player);
		}
		
		} while (!command.equals("exit"));
		
		String[] options = new String[] {"Yes", "No"};
		int result = JOptionPane.showOptionDialog(null, "Are you sure you would like to Exit?", "Exit?",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
		if (result==JOptionPane.YES_OPTION) {
    	    System.exit(0);
    	}
		return(current_player);
		
	}
	
	public static void main (String args[]) {	
		monopoly_test game = new monopoly_test();
		game.echo(0);
		game.tour(0);
		return;
	}
}