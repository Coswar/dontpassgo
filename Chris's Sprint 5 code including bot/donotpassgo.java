import java.util.ArrayList;

public class donotpassgo implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects

	// check to see if bot has jailcard
	int jailcard = 0;
	
	// check to see if rolled
	int roll = 0;
	
	//array to decide whether or not to buy site
	//0 is sites that are unbuyable and thus does not change
	// higher the number greater want to buy site
	int[] buy_site = {0,6,0,6,0,6,1,0,1,1,0,2,6,2,2,6,3,0,3,3,0,4,0,4,4,6,5,5,6,5,0,6,6,0,
			6,6,0,7,0,7
		};
	
	//array to decide which site to be mortgaged first
	// 0 is n/a, 1 is unowned
	//lower number more allowed to mortgage
	int[] mortgage_site = {0,1,0,1,0,1,1,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,0,
			1,1,0,1,0,1
		};
	
	donotpassgo (BoardAPI board, PlayerAPI player, DiceAPI dice) {
		return;
	}
	
	public String getName () {
		return "donotpassgo";
	}
	
	public String getCommand () {
		// First call should be to roll
		//       NEED TO IMPLEMENT FOR DOUBLE ROLL CASE
		if(roll == 0){
			roll = 1;
		    return "roll";
		}
		
		
		
		//Last call to end turn
		return "done";
	}
	
	public boolean canAutoUseJailcard(Player player){
		if(player.isInJail() && jailcard > 0){
			return true;
		}
		return false;
	}
	
	public Property mortageHouse(Player player, int money){
		ArrayList<Property> propertyList = player.getProperties();
		if (propertyList.size() == 0) {
			System.out.println("Bankrupt");
			return null;
		}
		else{
			Property closestProperty = null;
			int diff = 99999;
			for(Property p : propertyList){ 
				if (p instanceof Site) {
					Site site = (Site) p;
					if (site.getNumBuildings() >= 1) { //Avoiding hotel and houses
						continue;
					}
				}
				int currDiff = p.getMortgageValue() - money;
				if(currDiff >= 0 && diff < currDiff){
					diff = currDiff;
					closestProperty = p;
				}
			}
			
			if (closestProperty == null) {
				for(Property p : propertyList){
					if (p instanceof Site) {
						Site site = (Site) p;
						if (site.getNumBuildings() == 5) { // hotel
							continue;
						}
					}
					int currDiff = p.getMortgageValue() - money;
					if(currDiff >= 0 && diff < currDiff){
						diff = currDiff;
						closestProperty = p;
					}
				}
			}
			
			if (closestProperty == null) {
				for(Property p : propertyList){
					int currDiff = p.getMortgageValue() - money;
					if(currDiff >= 0 && diff < currDiff){
						diff = currDiff;
						closestProperty = p;
					}
				}
			}
			
			System.out.println(closestProperty.getShortName());
			return closestProperty;
		}
	}
	public Property buySite(Player player, int money) {
		ArrayList<Property> propertyList = player.getProperties();
		if (propertyList.size() == 0) {
			System.out.println("Bankrupt");
			return null;
		}
		else{
			Property closestProperty = null;
			int diff = 99999;
			for(Property p : propertyList){ 
				if (p instanceof Site) {
					Site site = (Site) p;
					if (site.getNumBuildings() >= 1) { //Avoiding hotel and houses
						continue;
					}
				}
				int currDiff = p.getMortgageValue() - money;
				if(currDiff >= 0 && diff < currDiff){
					diff = currDiff;
					closestProperty = p;
				}
			}
			
			if (closestProperty == null) {
				for(Property p : propertyList){
					if (p instanceof Site) {
						Site site = (Site) p;
						if (site.getNumBuildings() == 5) { // hotel
							continue;
						}
					}
					int currDiff = p.getMortgageValue() - money;
					if(currDiff >= 0 && diff < currDiff){
						diff = currDiff;
						closestProperty = p;
					}
				}
			}
			
			if (closestProperty == null) {
				for(Property p : propertyList){
					int currDiff = p.getMortgageValue() - money;
					if(currDiff >= 0 && diff < currDiff){
						diff = currDiff;
						closestProperty = p;
					}
				}
			}
			
			System.out.println(closestProperty.getShortName());
			return closestProperty;
		}
		
		
	}
	public String getDecision () {
		// code deciding to pay fine or take chance card
		// better to take chance
		return "chance";
	}
	
}
