
public class Player {
	
	private int position;
	
	Player () {
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
	
	public int getPosition () {
		return position;
	}
	
}
