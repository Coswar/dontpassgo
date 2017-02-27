import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Monopoly {

	public static final int MAX_NUM_PLAYERS = 6;
	public static final int MIN_NUM_PLAYERS = 2;
	public static final int NUM_SQUARES = 40;

	private ArrayList<Player> players = new ArrayList<Player>();
	private UI ui = new UI(players);
	int roll_count = 0;
	int currentGamePlayerCnt = 0;

	Monopoly() {
		// Not initialising players here any longer, instead just to show the UI.
		ui.display();
		return;
	}

	private int tour(int current_player) {
		int die1,die2,total_die;
		die1 = Player.roll(1);
		die2 = Player.roll(1);
		total_die = (die1+die2);
		
		for (int p = current_player; p < MAX_NUM_PLAYERS; p++) {
			for (int i = 0; i < NUM_SQUARES; i++) {
				players.get(p).move(+total_die);
				ui.display();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				}
				if(die1==die2){
					roll_count = 0;
					ui.displayString("Double Roll! Move again!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Sleep exeception.");
					}
					tour(current_player);
				}
				echo(current_player);
			}

			String[] options = new String[] { "Continue", "Switch" };
			int result = JOptionPane.showOptionDialog(null,
					"Player" + p + "'s moves are finished. Would you " + "like to continue or switch to input?",
					"Switch?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (result == JOptionPane.NO_OPTION) {
				current_player = MAX_NUM_PLAYERS;
			}
		}
		return (current_player);
	}

	private int echo(int current_player) {
		// The number of players is dynamic depending on user input, using that instead of 6
		if (current_player == currentGamePlayerCnt) {
			current_player = 0;
		}

		String command;
		ui.display();

		// Displaying text with players name, as it looks more user friendly.
		ui.displayString("                            Input Command for Player " + (current_player + 1) + ": "
				+ players.get(current_player).getName() + "\n"
				+ "                           (Enter 'help' for more info):\n");

		command = ui.getCommand();
		ui.displayString(command);

		// Using switch instead of if-if ladder, as it is more efficient
		switch (command) {
		
		case "roll":
			if (roll_count == 0){
				roll_count = roll_count + 1;
				ui.displayString("                                   Moving!");
				ui.displayString("rollcount:"+roll_count);
				current_player = tour(current_player);
				echo(current_player);
			}
			else{
				ui.displayString("                                   To many moves, wait til next turn!");
				
			}
			
			break;
		
		case "balance":
		
			ui.displayString("Your current balance: " + players.get(current_player).getBalance());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		
		case "end turn":
		
			ui.displayString("                                   Next Player!");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Sleep exeception.");
			}
			roll_count = 0;
			current_player = (current_player + 1);
			echo(current_player);
			break;

		case "exit":
		
			String[] options = new String[] { "Yes", "No" };
			int result = JOptionPane.showOptionDialog(null, "Are you sure you would like to Exit?", "Exit?",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

			if (result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			
			if (result == JOptionPane.NO_OPTION) {
				echo(current_player);
			}
			break;
		
		case "help":
		
			ui.displayString("\n  Available Commands:\n " + "\n  'roll': roll dice and move\n "
					+ "\n 'balance': to get your current balance \n"
					+ "\n 'end turn': end your turn and switch to next player \n" + "\n  'exit': exit game\n"
					+ "\n  Press enter to continue\n");
			command = ui.getCommand();
			ui.displayString(command);
			break;
		
		default:
		
			ui.displayString("                                   Incorrect Input, try again!");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Sleep exeception.");
			}
		}

		echo(current_player);
		return (current_player);

	}

	// This method will get all the prerequisites for the game
	private void getPreRequisites() {
		String command;
		boolean isValidPlayerCnt = false; // Assuming user will always give bad input

		// A valid input is a number [MIN_NUM_PLAYERS..MAX_NUM_PLAYERS]
		// Keep asking until valid input is input
		while (!isValidPlayerCnt) {
			
			if (currentGamePlayerCnt >= MIN_NUM_PLAYERS && currentGamePlayerCnt <= MAX_NUM_PLAYERS)
				isValidPlayerCnt = true;
			
			else {
				ui.display();
				ui.displayString("How many players? \nNumber of players allowed are " + MIN_NUM_PLAYERS + " to "
						+ MAX_NUM_PLAYERS);
				command = ui.getCommand();

				// try-catch to prevent crashing on bad input
			
				try {
					currentGamePlayerCnt = Integer.parseInt(command);
				} catch (NumberFormatException nfe) {
					System.out.println("Exception caught and waiting for valid input");
				}
			}
		}

		addPlayersToGame(currentGamePlayerCnt);
	}

	// Initialize players list and refresh UI each time a new player is added:
	private void addPlayersToGame(int currentGamePlayerCnt2) {
		String command;
		for (int i = 0; i < currentGamePlayerCnt; i++) {
			ui.display();
			ui.displayString("Enter name of Player: " + (i + 1));
			command = ui.getCommand(); // Taking input from user
			players.add(new Player(i, command)); // Adding player to game
		}

		ui.display();
	}

	private int decideWhoPlaysFirst() {
		int player_id = -1;
		int maxScore = 0;
		for (Player p : players) {
			int currentScore = p.getDie1() + p.getDie2();
			if (maxScore < currentScore) {
				maxScore = currentScore; 
				player_id = p.getId();
			}
		}
		return player_id;
	}

	public static void main(String args[]) {
		Monopoly game = new Monopoly();
		game.getPreRequisites();
		int player_id = game.decideWhoPlaysFirst();
		game.echo(player_id);
		game.tour(player_id);
		return;
	}
}