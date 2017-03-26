import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Monopoly {

	public static final int MAX_NUM_PLAYERS = 6;
	public static final int MIN_NUM_PLAYERS = 2;
	public static final int NUM_SQUARES = 40;
	public String[] site_owned = {"2", "0", "2", "0", "2", "0", "0", "2", "0", "0", "2", "0", "0", "0", "0", "0", "0", "2", "0", "0", 
			"2", "0", "2", "0", "0", "0", "0", "0", "0", "0", "2", "0", "0", "2", "0", "0", "2", "0", "2", "0"
		};
	public String[] site_owners = new String[40];

	private ArrayList<Player> players = new ArrayList<Player>();
	private UI ui = new UI(players);
	int roll_count = 0;
	int currentGamePlayerCnt = 0;
	int curr_pos = 0;
	int rent_check = 0;
	String check;

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
	
	private List<String> splitCommand(String command){
		List<String> matchList = new ArrayList<String>();
		Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
		Matcher regexMatcher = regex.matcher(command);
		while (regexMatcher.find()) {
		    if (regexMatcher.group(1) != null) {
		        // Add double-quoted string without the quotes
		        matchList.add(regexMatcher.group(1));
		    } else if (regexMatcher.group(2) != null) {
		        // Add single-quoted string without the quotes
		        matchList.add(regexMatcher.group(2));
		    } else {
		        // Add unquoted word
		        matchList.add(regexMatcher.group());
		    }
		} 
		
		return matchList;
	}

	private int echo(int current_player) {
		// The number of players is dynamic depending on user input, using that instead of 6
		if (current_player == currentGamePlayerCnt) {
			current_player = 0;
		}

		curr_pos = players.get(current_player).getPosition();
		String command;
		ui.display();
		
		check = site_owned[curr_pos];
		ui.displayString(check);
		
		switch(check){
		case "0":
			ui.displayString("You have landed on " + players.get(current_player).getSiteName(curr_pos) + " it is not owned \n" +
 
					"it costs: " + players.get(current_player).getPrice(curr_pos) + ". You may buy this property by inputting command: 'buy'!\n"
					+"\n" +"      Input Command for Player " 
					+ (current_player + 1) + ": " + players.get(current_player).getName() + "\n"
					+ "(Enter 'help' for more info):\n");
			
			break;
			
		case "1":
			ui.displayString("You have landed on " + players.get(current_player).getSiteName(curr_pos) + "\n it is owned by "
					+ site_owners[curr_pos] + "\n" + "You owe rent of: " +
					players.get(current_player).getRent(curr_pos) + "\n" + "you can pay this by entering command: pay rent" +"\n" +"      Input Command for Player " 
					+ (current_player + 1) + ": " + players.get(current_player).getName() + "\n"
					+ "(Enter 'help' for more info):\n");
			rent_check = 1;
			break;
			
		case "2":
			ui.displayString("You have landed on " + players.get(current_player).getSiteName(curr_pos) +"\n" +"      Input Command for Player " 
				+ (current_player + 1) + ": " + players.get(current_player).getName() + "\n"
				+ "(Enter 'help' for more info):\n");
			break;
		}
		 
		// Displaying text with players name, as it looks more user friendly.
 
		
		command = ui.getCommand();
		ui.displayString(command);
		
		if (command.contains("build")){
			List<String> matchList = splitCommand(command);
			if(matchList.size() == 3){
				String [] allProperties = players.get(current_player).site_info;
				int selectedProCtr = -1;
				for (int proCtr = 0; proCtr < allProperties.length; proCtr++){
					if(matchList.get(1).equals(allProperties[proCtr])){
						selectedProCtr = proCtr;
						break;
					}
				}
				if (selectedProCtr == -1){
					ui.displayString("Wrong property selected!");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.println("Sleep exeception.");
					}
				}
				else{
					String propColor = players.get(current_player).color_group[selectedProCtr];
					boolean allColorPropBought = isAllColorPropBrought(current_player, propColor);
					if(allColorPropBought == true){
						ui.displayString("Created " + matchList.get(2) + " at " + allProperties[selectedProCtr]);
					}
					else {
						ui.displayString("You don't own all the color groups");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							System.out.println("Sleep exeception.");
						}
					}
				}
			}
			else{
				ui.displayString("Incorrect Input, try again!");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				}
			}
		}
		else if(command.contains("demolish")){
			List<String> matchList = splitCommand(command);
			if(matchList.size() == 3){
				String [] allProperties = players.get(current_player).site_info;
				int selectedProCtr = -1;
				for (int proCtr = 0; proCtr < allProperties.length; proCtr++){
					if(matchList.get(1).equals(allProperties[proCtr])){
						selectedProCtr = proCtr;
						break;
					}
				}
				if (selectedProCtr == -1){
					ui.displayString("Wrong property selected!");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.println("Sleep exeception.");
					}
				}
				else{
					int site_cost = players.get(current_player).site_cost[selectedProCtr] / 2;
					players.get(current_player).withdrawFromBalance(-1 * site_cost);
					site_owned[selectedProCtr] = "0";
					site_owners[selectedProCtr] = null;
					ui.displayString("site demolished");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.println("Sleep exeception.");
					}
				}
			}
			else{
				ui.displayString("Incorrect Input, try again!");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				}
			}
		}
		else {
		
		switch (command) {
		
		case "roll":
			if (roll_count == 0){
				roll_count = roll_count + 1;
				ui.displayString("                                   Moving!");
				//ui.displayString("rollcount:"+roll_count);
				current_player = tour(current_player);
				echo(current_player);
			}
			else{
				ui.displayString("                                   To many moves, wait til next turn!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
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
			if(roll_count == 1){
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
			}
			else{
				ui.displayString("     You haven't rolled yet, please roll before moving to next player!");

				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				}
				//echo(current_player);
			}
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
			
		case "buy":
			if(site_owned[curr_pos] == "0"){
				int temp = current_player;
			site_owners[curr_pos] = players.get(temp).getName();
			site_owned[curr_pos] = "1";
			players.get(current_player).withdrawFromBalance(players.get(current_player).getPrice(curr_pos));
			ui.displayString("The site has been bought");
			}
			else{
			ui.displayString("This site is allready owned");
			}
			break;
		case "property":
			ui.displayString("You following properties with you");
			StringBuffer sb = new StringBuffer();
			for (int owners_cnt = 0; owners_cnt < site_owners.length; owners_cnt++) {
			    if(site_owners[owners_cnt] != null && site_owners[owners_cnt].equals(players.get(current_player).getName())){
			    	sb.append(players.get(current_player).getSiteName(owners_cnt) + ", ");
			    }
			}
			ui.displayString(sb.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case "bankrupt": 
			ui.displayString("Removing player : " + players.get(current_player).getName());
			//moving property back to bank after bankruptcy
			for (int owners_cnt = 0; owners_cnt < site_owners.length; owners_cnt++) {
			    if(site_owners[owners_cnt] != null && site_owners[owners_cnt].equals(players.get(current_player).getName())){
			    	site_owned[owners_cnt] = "0";
			    }
			}
			players.remove(current_player);
			currentGamePlayerCnt = currentGamePlayerCnt - 1;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.out.println("Sleep exeception.");
			}
			if(players.size() == 1){
				roll_count = 1;
				ui.displayString("Winner is: " + players.get(0).getName());
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				}
			}
			else {
				roll_count = 0;
				//current_player = (current_player + 1);
				echo(current_player);
			}
			break;
		case "help":
		
			ui.displayString("\n  Available Commands:\n " + "\n  'roll': roll dice and move\n "
					+ "\n 'balance': to get your current balance \n"
					+ "\n 'end turn': end your turn and switch to next player \n" + "\n  'exit': exit game\n"
					+ "\n 'buy': buys the current site"
					+ "\n 'property': to get list of properties you own"
					+ "\n 'build '<property-name>' '<units>'' : You can build house/hotel"
					+ "\n 'demolish '<property-name>' '<units>'' : You can demolish house/hotel"
					+ "\n 'bankrupt' : Declare bankruptcy"
					+ "\n Press enter to continue\n");
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
		}

		echo(current_player);
		return (current_player);

	}

	private boolean isAllColorPropBrought(int current_player, String propColor) {
		List <Integer> allIndexes = new ArrayList<Integer>();
		String [] allColors = players.get(current_player).color_group;
		for(int i = 0; i< allColors.length; i++){
			if(allColors[i].equals(propColor)){
				allIndexes.add(i);
			}
		}
		boolean allOwned = false;
		for (Integer indx : allIndexes) {
			
		}
		return allOwned;
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
		//game.tour(player_id);
		return;
	}
}