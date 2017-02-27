
public class Player {
	private int id; //Unique ID for each Player
	private String name;		
	private String tokenColour;
	private int position;			
	private int balance;		
	private int die1 = (int)(Math.random()*6) + 1;		
	private int die2 = (int)(Math.random()*6) + 1;
	private String[] tile_info = { "Go", "Mediterranean Avenue", "Community Chest", "Baltic Avenue", "Income Tax", "Reading Railroad",
			"Oriental Avenue", "Chance", "Vermont Avenue", "Connecticut Avenue", "Jail", "St.Charles Place", "Electric Company",
			"States Avenue", "Virginia Avenue", "Pennsylvania Railroad", "St.James Place", "Community Chest", "Tenessee Avenue",
			"New York Avenue", "Free Parking", "Kentucky Avenue", "Chance", "Indiana Avenue", "Illinois Avenue", "B&O Railroad",
			"Atlantic Avenue", "Ventnor Avenue", "Water Works", "Marvin Gardens", "Go To Jail", "Pacific Avenue", "North Carolina Avenue",
			"Community Chest", "Pennsylvania Avenue", "Short Line", "Chance", "Park Place", "Luxury Tax", "Boardwalk"
	};
	
	
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
	
	public void roll() {		
    	this.die1 = (int)(Math.random()*6) + 1;		
        this.die2 = (int)(Math.random()*6) + 1;		
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
}
