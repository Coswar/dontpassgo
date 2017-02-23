
public class Player {
	
	private String name;
	private int position;
	private int balance;
	
	Player () {
		name = "Unset";
		position = 0;
		balance = 1500;
		return;
	}
	
	public void move (int squares) {
		position += position + squares;
		if (position < 0) {
			position += Monopoly.NUM_SQUARES;
		} else if (position >= Monopoly.NUM_SQUARES) {
			position += position % Monopoly.NUM_SQUARES;
		}
		return;
	}
	
	public int getPosition () {
		return position;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void withdrawFromBalance(int withdrawal) {
		this.balance -= withdrawal;
	}
	
	public void depositToBalance(int deposit) {
		this.balance += deposit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
	
}
