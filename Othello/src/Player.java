
public class Player {
	private int player;
	private String name;
	
	
	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public Player(String name) {
		this.name = name;
	}
	public String getName(Player p) {
		return p.name;
	}
}

