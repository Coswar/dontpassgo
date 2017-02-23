
public class Player {
	
	private int position;
	private int balance;
	private String name;
	
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
	
}
