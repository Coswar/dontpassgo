
public class Player {
	private int id; //Unique ID for each Player
	private String name;		
	private String tokenColour;
	private int position;			
	private int balance;		
	private int die1 = (int)(Math.random()*6) + 1;		
	private int die2 = (int)(Math.random()*6) + 1;
	public String[] site_info = { "Go", "Mediterranean Avenue", "Community Chest", "Baltic Avenue", "Income Tax", "Reading Railroad",
			"Oriental Avenue", "Chance", "Vermont Avenue", "Connecticut Avenue", "Jail", "St.Charles Place", "Electric Company",
			"States Avenue", "Virginia Avenue", "Pennsylvania Railroad", "St.James Place", "Community Chest", "Tenessee Avenue",
			"New York Avenue", "Free Parking", "Kentucky Avenue", "Chance", "Indiana Avenue", "Illinois Avenue", "B&O Railroad",
			"Atlantic Avenue", "Ventnor Avenue", "Water Works", "Marvin Gardens", "Go To Jail", "Pacific Avenue", "North Carolina Avenue",
			"Community Chest", "Pennsylvania Avenue", "Short Line", "Chance", "Park Place", "Luxury Tax", "Boardwalk"
	};
	public String[] site_owned = {"2", "0", "2", "0", "2", "0", "0", "2", "0", "0", "2", "0", "0", "0", "0", "0", "0", "2", "0", "0", 
			"2", "0", "2", "0", "0", "0", "0", "0", "0", "0", "2", "0", "0", "2", "0", "0", "2", "0", "2", "0"
		};
	int[] site_cost = {0,60,0,60,0,200,100,0,100,120,0,140,150,140,160,200,180,0,180,200,0,220,0,220,240,200,260,260,150,280,0,300,300,0,
			320,200,0,350,0,400
		};
	public String[] site_owners;
	int site_rent = 100;
	
	
	
	//Constructor now receives id and name:
	Player (int id, String name) {
		this.id = id;
		this.name = name;
		this.tokenColour = "Unset";
		this.position = 0;
		this.balance = 1500;		
		this.die1 = (int)(Math.random()*6) + 1;		
		this.die2 = (int)(Math.random()*6) + 1;
		return;
	}

	public void move (int squares) {
		position = position + squares;
		if (position < 0) {
			position = position + Monopoly.NUM_SQUARES;
		} else if (position >= Monopoly.NUM_SQUARES) {
			position = position % Monopoly.NUM_SQUARES;
		}
		return;
	}
	
	public static int roll(int die1) {		
    	die1 = (int)(Math.random()*6) + 1;		
        return (die1);
    }	
	
	public String getName() {		
		return name;		
	}
	
	public void setName(String name) {		
		this.name = name;		
	}
    
	public String getTokenColour() {
		return tokenColour;
	}

	public void setTokenColour(String tokenColour) {
		this.tokenColour = tokenColour;
	}

	public int getPosition () {
		return position;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {		
		return balance;		
	}				
			
	public void withdrawFromBalance(int withdrawal) {		
		this.balance -= withdrawal;		
	}		
			
	public void depositToBalance(int deposit) {		
		this.balance += deposit;		
	}		
	public int getDie1() {		
		return die1;		
	}		
	public int getDie2() {		
		return die2;		
	}
	
	public String getSiteName(int currpos){
		return site_info[currpos];
	}
	
	public String siteInfo(int currpos){
		return site_owned[currpos];
	}
	
	public String getOwner(int currpos){
		return site_owners[currpos];
	}
	
	public int getRent(int currpos){
		return site_rent;
	}
}
