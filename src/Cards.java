import java.util.ArrayList;

public class Cards{
	public static String[] community_chest = {
		"Advance to go",
		"Go back to Mediterranian Avenue",
		"Go to jail",
		"Pay hospital 100",
		"Doctor's fee. Pay 50",
		"Pay your insurance premium of 50",
		"Bank error in your favour. Collect 200",
		"Annuity matures. Collect 100",
		"You inherit 100",
		"From sale of stock you get 50",
		"Receive interest on 7% preference shares: 25",
		"Income tax refund. Collect 20",
		"You have won second prize in a beauty contest. Collect 10",
		"It is your birthday. Collect 10 from each player",
		"Get out of jail free",
		"You payed fine of 10",
		"You chose chance"
	};
	
	public static String[] chance = {
		"Advance to go",
		"Advance to Charles place",
		"Go to jail",
		"Take a trip to Reading railroad",
		"Advance to Illinois Avenue",
		"Advance to boardwalk",
		"Go back three spaces",
		"Make general repairs on all of your houses. For each house pay 25. For each hotel pay 100",
		"You are assessed for street repairs: 40 per house, 115 per hotel",
		"Pay school fees of 150",
		"Drunk in charge fine of 20",
		"Speeding fine of 15",
		"Your building loan matures. Recieve 150",
		"You have won a crossword competition. Collect 100",
		"Bank pays you dividend of 50",
		"Get out of jail free"
		};
	
	public static String communityChest(int curplayer, double roll, int curpos, ArrayList<Player> players, UI ui){
		String check = Double.toString(roll);
		
		switch(check){
			
		case "0":
			players.get(curplayer).changelocation(0);
			ui.display();
		case "1":
			players.get(curplayer).changelocation(1);
			ui.display();
		case "2":
			players.get(curplayer).changelocation(10);
			ui.display();
		case "3":
			players.get(curplayer).withdrawFromBalance(100);
		case "4":
			players.get(curplayer).withdrawFromBalance(50);		
		case "5":
			players.get(curplayer).withdrawFromBalance(50);	
		case "6":
			players.get(curplayer).depositToBalance(200);
		case "7":
			players.get(curplayer).depositToBalance(100);	
		case "8":
			players.get(curplayer).depositToBalance(100);	
		case "9":
			players.get(curplayer).depositToBalance(50);	
		case "10":
			players.get(curplayer).depositToBalance(25);
		case "11":
			players.get(curplayer).depositToBalance(20);
		case "12":
			players.get(curplayer).depositToBalance(10);
		case "13":
			int i = 0;
			while(players.get(i) != null){
				players.get(i).withdrawFromBalance(10);
				i++;
			};
			players.get(curplayer).depositToBalance(10*i);
		case "14":
			players.get(curplayer).gotJailCard();
		case "15":
			String choice;
			ui.displayString("Enter 'fine' to pay fine of 10, or 'chance' to pick a chance card");
			
			choice = ui.getCommand();
			switch(choice){
			case"fine":
				players.get(curplayer).withdrawFromBalance(10);
			case"chance":
				double ran = Math.random()*16;
				Cards.chance(curplayer, ran, curpos, players, ui );
				roll = 16;
			}
			
		}
		int temp = (int)roll;
		return community_chest[temp];
	}
	
	public static String chance(int curplayer, double roll, int curpos, ArrayList<Player> players, UI ui){
		String check = Double.toString(roll);
		
		switch(check){
			
		case "0":
			players.get(curplayer).changelocation(0);
			ui.display();
		case "1":
			players.get(curplayer).changelocation(31);
			ui.display();
		case "2":
			players.get(curplayer).changelocation(10);
			ui.display();
		case "3":
			players.get(curplayer).changelocation(5);
			ui.display();
		case "4":
			players.get(curplayer).changelocation(24);
			ui.display();
		case "5":
			players.get(curplayer).changelocation(39);
			ui.display();
		case "6":
			players.get(curplayer).move(curpos - 3);
		case "7":
			// daire
		case "8":
			//daire
		case "9":
			players.get(curplayer).withdrawFromBalance(150);
		case "10":
			players.get(curplayer).withdrawFromBalance(20);
		case "11":
			players.get(curplayer).withdrawFromBalance(15);
		case "12":
			players.get(curplayer).depositToBalance(150);
		case "13":
			players.get(curplayer).depositToBalance(100);
		case "14":
			players.get(curplayer).depositToBalance(50);
		case "15":
			players.get(curplayer).gotJailCard();
		}
		int temp = (int)roll;
		return chance[temp];
	}
}