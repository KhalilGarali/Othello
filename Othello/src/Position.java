
public  class  Position {
	private char piece;
	public static final char UNPLAYABLE = '*';
	public static final char EMPTY = '#';
	public static final char BLACK = 'B';
	public static final char WHITE = 'W';
	
	
	public char setPiece(char piece) {
		return this.piece = piece;
	}
	
	public char getPiece() {
		return piece;
	}

	public boolean canPlay() {
		return false;
	}
}

