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
	
	public static String communityChest(int curplayer, int roll, int curpos, ArrayList<Player> players, UI ui){
		String check = Integer.toString(roll);
		
		switch(check){
			
		case "0":
			players.get(curplayer).changelocation(0,0);
			ui.display();
			break;
		case "1":
			players.get(curplayer).changelocation(1,0);
			ui.display();
			break;
		case "2":
			players.get(curplayer).changelocation(10,1);
			ui.display();
			break;
		case "3":
			players.get(curplayer).withdrawFromBalance(100);
			break;
		case "4":
			players.get(curplayer).withdrawFromBalance(50);
			break;
		case "5":
			players.get(curplayer).withdrawFromBalance(50);
			break;
		case "6":
			players.get(curplayer).depositToBalance(200);
			break;
		case "7":
			players.get(curplayer).depositToBalance(100);
			break;
		case "8":
			players.get(curplayer).depositToBalance(100);
			break;
		case "9":
			players.get(curplayer).depositToBalance(50);
			break;
		case "10":
			players.get(curplayer).depositToBalance(25);
			break;
		case "11":
			players.get(curplayer).depositToBalance(20);
			break;
		case "12":
			players.get(curplayer).depositToBalance(10);
			break;
		case "13":
			int i = 0;
			while(players.get(i) != null){
				players.get(i).withdrawFromBalance(10);
				i++;
			};
			players.get(curplayer).depositToBalance(10*i);
			break;
		case "14":
			players.get(curplayer).gotJailCard();
			break;
		case "15":
			String choice;
			ui.displayString("Enter 'fine' to pay fine of 10, or 'chance' to pick a chance card");
			
			choice = ui.getCommand();
			switch(choice){
			case"fine":
				players.get(curplayer).withdrawFromBalance(10);
			case"chance":
				int ran = (int)(Math.random()*16);
				Cards.chance(curplayer, ran, curpos, players, ui );
				roll = 16;
			}
			break;
			
		}
		
		return community_chest[roll];
	}
	
	public static String chance(int curplayer, int roll, int curpos, ArrayList<Player> players, UI ui){
		String check = Integer.toString(roll);
		
		switch(check){
			
		case "0":
			players.get(curplayer).changelocation(0,0);
			ui.display();
			break;
		case "1":
			players.get(curplayer).changelocation(31,0);
			ui.display();
			break;
		case "2":
			players.get(curplayer).changelocation(10,1);
			ui.display();
			break;
		case "3":
			players.get(curplayer).changelocation(5,0);
			ui.display();
			break;
		case "4":
			players.get(curplayer).changelocation(24,0);
			ui.display();
			break;
		case "5":
			players.get(curplayer).changelocation(39,0);
			ui.display();
			break;
		case "6":
			players.get(curplayer).move(curpos - 3);
			ui.display();
			break;
		case "7":
			// daire
		case "8":
			//daire
		case "9":
			players.get(curplayer).withdrawFromBalance(150);
			break;
		case "10":
			players.get(curplayer).withdrawFromBalance(20);
			break;
		case "11":
			players.get(curplayer).withdrawFromBalance(15);
			break;
		case "12":
			players.get(curplayer).depositToBalance(150);
			break;
		case "13":
			players.get(curplayer).depositToBalance(100);
			break;
		case "14":
			players.get(curplayer).depositToBalance(50);
			break;
		case "15":
			players.get(curplayer).gotJailCard();
			break;
		}
		return chance[roll];
	}
}