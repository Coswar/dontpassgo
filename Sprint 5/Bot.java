
public interface Bot {
	
	public String getName ();
	public String getCommand ();
	public String getDecision ();
	public boolean canAutoUseJailcard(Player player);
	public Property mortageHouse(Player player, int money);
}
