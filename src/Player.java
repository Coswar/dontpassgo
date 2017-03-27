
public class Player {
	private int id; //Unique ID for each Player
	private String name;		
	private String tokenColour;
	private int position;			
	private int balance;		
	private int die1 = (int)(Math.random()*6) + 1;		
	private int die2 = (int)(Math.random()*6) + 1;
	public String[] site_info = { "Go", "Mediterranean Avenue", "Community Chest", "Baltic Avenue", "Income Tax", "Reading Railroad",
			"Oriental Avenue", "Chance", "Vermont Avenue", "Connecticut Avenue", "Jail (just visiting)", "St.Charles Place", "Electric Company",
			"States Avenue", "Virginia Avenue", "Pennsylvania Railroad", "St.James Place", "Community Chest", "Tenessee Avenue",
			"New York Avenue", "Free Parking", "Kentucky Avenue", "Chance", "Indiana Avenue", "Illinois Avenue", "B&O Railroad",
			"Atlantic Avenue", "Ventnor Avenue", "Water Works", "Marvin Gardens", "Go To Jail", "Pacific Avenue", "North Carolina Avenue",
			"Community Chest", "Pennsylvania Avenue", "Short Line", "Chance", "Park Place", "Luxury Tax", "Boardwalk"
	};
	int[] site_cost = {0,60,0,60,0,200,100,0,100,120,0,140,150,140,160,200,180,0,180,200,0,220,0,220,240,200,260,260,150,280,0,300,300,0,
			320,200,0,350,0,400
		};
	int[] site_mortgage_value = {0,50,0,50,0,100,50,0,50,60,0,70,75,70,80,100,90,0,90,100,0,110,0,110,120,100,150,150,75,150,0,200,200,0,
			2000,100,0,175,0,200
		};
	
	public String [] color_group = {null, "brown", null, "brown", null, null, "lightblue", null,
			"lightblue", "lightblue", null, "pink", null, "pink", "pink", null, "orange", null,
			"orange", "orange", null, "red", null, "red", "red", null, "yellow", "yellow", null,
			"yellow", null, "green", "green", null, "green", null, null, "blue", null, "blue"};
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
	
	public int getRent(int currpos){
		return site_rent;
	}
	
	public int getPrice(int currpos){
		return site_cost[currpos];
	}
	
	public int getMortgage(int currpos){
		return site_mortgage_value[currpos];
	}
	
}