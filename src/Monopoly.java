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
		
		if (current_player == 6){
			current_player = 0; 
		}
		String command;
		ui.display();
		ui.displayString("                            Input Command for Player " +(current_player+1) +"\n"
	                    +"                           (Enter 'help' for more info):\n");
		
			command = ui.getCommand();
			ui.displayString(command);
			
			if(command.equals("move")){
				ui.displayString("                                   Moving!");
				current_player = tour(current_player);
				echo(current_player);
				
			}
			
			if (command.equals("end turn")){
				ui.displayString("                                   Next Player!");
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				} 
				
				current_player = (current_player + 1);
				echo(current_player);
			}
		
			if(command.equals("exit")){
		
				String[] options = new String[] {"Yes", "No"};
				int result = JOptionPane.showOptionDialog(null, "Are you sure you would like to Exit?", "Exit?",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
			
				if (result==JOptionPane.YES_OPTION) {
		    	    System.exit(0);
		    	}
				if (result==JOptionPane.NO_OPTION) {
		    	    echo(current_player);
		    	}
			}
			
			if(command.equals("help")){
				ui.displayString("\n  Available Commands:\n " + "\n  'move': forward one square\n "
						+ "\n 'end turn': end your turn and switch to next player \n"
						+ "\n  'exit': exit game\n"+ "\n  Press enter to continue\n");
				command = ui.getCommand();
				ui.displayString(command);
			}
			else{
				ui.displayString("                                   Incorrect Input, try again!");
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				} 
			}
			
		echo(current_player);
		return(current_player);
		
	}
	
	public static void main (String args[]) {	
		Monopoly game = new Monopoly();
		game.echo(0);
		game.tour(0);
		return;
	}
}