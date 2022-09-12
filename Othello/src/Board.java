import java.util.Scanner;


public class Board {
	private int width = 8;
	private int height = 8;
	Player p1,p2;
	Position  [][] board = new Position [width][height];
	public static boolean option1;
	
	
	public Board() {
		
	}
	
	
	public void checkWin(Position[][] board) {
		int bCounter = 0;
		int wCounter =0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(board[i][j].getPiece()==Position.BLACK) {
					bCounter++;
					
				}
				else if(board[i][j].getPiece()==Position.WHITE) {
					wCounter++;
				}
			}
		}
		if( bCounter>wCounter) {
			System.out.println("Player " + p1.getName(p1) + "has won!");
		}
		else {
			System.out.println("Player " + p2.getName(p2) + "has won!");
		}
	}
	public void drawBoard() {
		for (int i = 0; i <width; i++) {
            for (int j = 0; j <height; j++) {
                System.out.print(board[i][j].getPiece());
            }
            System.out.println();
        }
	}
	
	public Board(String positions) {
		if(positions.equals("1")) {
			option1 = true;
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				board[i][j] = new PlayablePosition();
				board[i][j].setPiece(Position.EMPTY);
				}
		}
		board[2][2].setPiece(Position.WHITE);
		board[2][3].setPiece(Position.WHITE);
		board[2][4].setPiece(Position.BLACK);
		board[2][5].setPiece(Position.BLACK);
		board[3][2].setPiece(Position.WHITE);
		board[3][3].setPiece(Position.WHITE);
		board[3][4].setPiece(Position.BLACK);
		board[3][5].setPiece(Position.BLACK);
		board[4][2].setPiece(Position.BLACK);
		board[4][3].setPiece(Position.BLACK);
		board[4][4].setPiece(Position.WHITE);
		board[4][5].setPiece(Position.WHITE);
		board[5][2].setPiece(Position.BLACK);
		board[5][3].setPiece(Position.BLACK);
		board[5][4].setPiece(Position.WHITE);
		board[5][5].setPiece(Position.WHITE);
		board[7][2].setPiece(Position.UNPLAYABLE);
		board[7][3].setPiece(Position.UNPLAYABLE);
		board[7][4].setPiece(Position.UNPLAYABLE);
		board[7][5].setPiece(Position.UNPLAYABLE);
		drawBoard();
		}
		else if(positions.equals("2")){
			for(int i=0;i<width;i++) {
				for(int j=0;j<height;j++) {
					board[i][j] = new PlayablePosition();
					board[i][j].setPiece(Position.EMPTY);
					}
			}
			board[2][2].setPiece(Position.WHITE);
			board[2][3].setPiece(Position.BLACK);
			board[3][2].setPiece(Position.BLACK);
			board[3][3].setPiece(Position.WHITE);
			board[7][2].setPiece(Position.UNPLAYABLE);
			board[7][3].setPiece(Position.UNPLAYABLE);
			board[7][4].setPiece(Position.UNPLAYABLE);
			board[7][5].setPiece(Position.UNPLAYABLE);
			drawBoard();
		}
		else if(positions.equals("3")){
			for(int i=0;i<width;i++) {
				for(int j=0;j<height;j++) {
					board[i][j] = new PlayablePosition();
					board[i][j].setPiece(Position.EMPTY);
					}
			}
			board[2][4].setPiece(Position.WHITE);
			board[2][5].setPiece(Position.BLACK);
			board[3][4].setPiece(Position.BLACK);
			board[3][5].setPiece(Position.WHITE);
			board[7][2].setPiece(Position.UNPLAYABLE);
			board[7][3].setPiece(Position.UNPLAYABLE);
			board[7][4].setPiece(Position.UNPLAYABLE);
			board[7][5].setPiece(Position.UNPLAYABLE);
			drawBoard();
		}
		else if(positions.equals("4")){
			for(int i=0;i<width;i++) {
				for(int j=0;j<height;j++) {
					board[i][j] = new PlayablePosition();
					board[i][j].setPiece(Position.EMPTY);
					}
			}
			board[4][2].setPiece(Position.WHITE);
			board[4][3].setPiece(Position.BLACK);
			board[5][2].setPiece(Position.BLACK);
			board[5][3].setPiece(Position.WHITE);
			board[7][2].setPiece(Position.UNPLAYABLE);
			board[7][3].setPiece(Position.UNPLAYABLE);
			board[7][4].setPiece(Position.UNPLAYABLE);
			board[7][5].setPiece(Position.UNPLAYABLE);
			drawBoard();
		}
		else if(positions.equals("5")){
			for(int i=0;i<width;i++) {
				for(int j=0;j<height;j++) {
					board[i][j] = new PlayablePosition();
					board[i][j].setPiece(Position.EMPTY);
					}
			}
			board[4][4].setPiece(Position.WHITE);
			board[4][5].setPiece(Position.BLACK);
			board[5][4].setPiece(Position.BLACK);
			board[5][5].setPiece(Position.WHITE);
			board[7][2].setPiece(Position.UNPLAYABLE);
			board[7][3].setPiece(Position.UNPLAYABLE);
			board[7][4].setPiece(Position.UNPLAYABLE);
			board[7][5].setPiece(Position.UNPLAYABLE);
			drawBoard();
		}	
	}
		
	public void takeTurn(Player current) {
		Scanner scanner = new Scanner(System.in);
		PlayablePosition pp = new PlayablePosition();
		if(current.getPlayer() == 1) {
			System.out.println("Please enter the coordinates for your next moove: (x,y) ");
			boolean isValid = true;
			do {
				int x = scanner.nextInt();
				int y = scanner.nextInt();	
				if(!pp.canPlay(board,x,y,current)) {
				System.out.println("The position chosen cannot be played. Please enter valid coordinates:");
			}
			else {
				board [x][y].setPiece(Position.BLACK);
				isValid = false;
				break;
			}
			}while(isValid);
		}
		else {
			System.out.println("Please enter the coordinates for your next moove: (x,y) ");
			boolean isValid = true;
			do {
				int x = scanner.nextInt();
				int y = scanner.nextInt();	
				if(!pp.canPlay(board,x, y,current)) {
				System.out.println("The position chosen cannot be played. Please enter valid coordinates:");
				
			}
			else {
				board [x][y].setPiece(Position.WHITE);
				isValid = false;
				break;
			}
			}while(isValid);
		}
	}
	
	
	public char[][] getPositions() {
        char[][] chars = new char[8][8];

        for (int i = 0; i<8; i++) {
            for(int j=0; j<8; j++) {
                chars[i][j] = board[i][j].getPiece();
            }

        }
        return chars;
    }
	
	public void setPositions(Position[][] positionsArr) {
        this.board = positionsArr;
    }
}
	
