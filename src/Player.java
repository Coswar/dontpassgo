
public class Player {
	private String name;		
	private int position;			
	private int balance;		
	private int die1;		
	private int die2; 
	
	Player () {
		name = "Unset";
		balance = 1500;		
		die1 = (int)(Math.random()*6) + 1;		
		die2 = (int)(Math.random()*6) + 1;
		position = 0;
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
