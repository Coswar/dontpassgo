
public class Player {
	private String name;		
	private String tokenColour;
	private int position;			
	private int balance;		
	private int die1 = (int)(Math.random()*6) + 1;		
	private int die2 = (int)(Math.random()*6) + 1;
	
	
	Player () {
		name = "Unset";
		tokenColour = "Unset";
		position = 1;
		balance = 1500;		
		die1 = (int)(Math.random()*6) + 1;		
		die2 = (int)(Math.random()*6) + 1;
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
