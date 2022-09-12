import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Game {
	Board b;
	Player p1,p2,current;
	private static Player p1Load, p2Load, currentLoad;
	
	
	
	public Game(Player p1, Player p2) {
		this.p1=p1;
		this.p2=p2;
	}
	 public Game(Board board) {
	        this.b = board;
	        p1 = p1Load;
	        p2 = p2Load;
	        current = currentLoad;
	    }
	
	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean isValid = true;
		do {
			try {
		System.out.println("Please choose your starting position:");
		System.out.println("1. four by four starting position");
		System.out.println("2. offset starting position 1 (top-left)");
		System.out.println("3. offset starting position 2 (top-right)");
		System.out.println("4. offset starting position 3 (bottom-left)");
		System.out.println("5. offset starting position 4 (bottom-right)");
		int position = scanner.nextInt();
			//switch(position) {
			//case 1:
		if(position != 1 && position!=2 && position!=3 && position!=4 && position!=5) {
			isValid = true;
			System.out.println("Please enter an Integer between 1-5:");
		}
		else {
				b = new Board(Integer.toString(position));
				isValid = false;
			}	
		}
			
			catch(InputMismatchException e) {
				System.out.println("Wrong input!");
				scanner.next();
			}
		} while(isValid);
		
	}
	
	public static Board load(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
        String[] posArr = new String[64];
        Position[][] positionsArr = new Position[8][8];
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            p1Load = new Player(br.readLine());
            p1Load.setPlayer(1);

            p2Load = new Player(br.readLine());
            p2Load.setPlayer(2);

            String current = br.readLine();
            if(current.equals(p1Load.getName(p1Load))) currentLoad = p1Load;
            else currentLoad = p2Load;

            posArr = br.readLine().split(",");
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
        } catch(IOException e) {
            System.out.println("error reading file");
            e.printStackTrace();
        }

        int z = 0;  
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(posArr[z].equals("#")) {
                    positionsArr[i][j] = new PlayablePosition();
                    positionsArr[i][j].setPiece(Position.EMPTY);
                }if(posArr[z].equals("*")) {
                    positionsArr[i][j] = new PlayablePosition();
                    positionsArr[i][j].setPiece(Position.UNPLAYABLE);
                }if(posArr[z].equals("W")) {
                    positionsArr[i][j] = new PlayablePosition();
                    positionsArr[i][j].setPiece(Position.WHITE);
                }if(posArr[z].equals("B")) {
                    positionsArr[i][j] = new PlayablePosition();
                    positionsArr[i][j].setPiece(Position.BLACK);
                }
                z++;
            }
        }

        Board b = new Board();
        b.setPositions(positionsArr);
        b.drawBoard();

        return b;
		
		
	}
	
	
	public void play() {
		if(OthelloDriver.load == false) {
		this.start();
		}
		int counter;
		if(Board.option1==true) {
			counter=44;
		}
		else {
			counter = 56;
		}
		
		int mooves =0;
		int index =0;
		while(mooves<counter) {
		System.out.println("What would you like to do:");
		System.out.println("1. Make a Move");
		System.out.println("2. Concede");
		System.out.println("3. Save");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		switch(option) {
			case 1:
					if((index % 2)==0) {
					current =p1;
					System.out.println("Turn: Black");
					b.takeTurn(p1);
					b.drawBoard();
					mooves++;
					}
					else {
					current =p2;
					System.out.println("Turn: White");
					b.takeTurn(p2);
					b.drawBoard();
					mooves++;
					}
					index++;
					break;
				
			case 2:
				if(current==p1) current = p2;
                else current = p1;
				index++;
				break;
				
			case 3:
				if(index % 2 == 0) current = p1;
				else current = p2;
				save();
				System.exit(0);
				break;
			}
				
				
				
		}
		
		b.checkWin(b.board);

	}
	
	private void save() {
		System.out.println("Please enter filename...");

        try{
            Scanner scanner = new Scanner(System.in);
            String file = scanner.nextLine();

            String toSave = p1.getName(p1) + "\n" + p2.getName(p2) + "\n" + current.getName(current) + "\n";

            char[][] characters = b.getPositions();

            File save = new File(file);

            if(!save.exists()) save.createNewFile();
           
            FileWriter writer = new FileWriter(save);
            BufferedWriter bwriter = new BufferedWriter(writer);
            StringBuilder strbuilder = new StringBuilder();

            strbuilder.append(toSave);

            for (int i=0; i<8; i++) {
                for (int j=0; j<8; j++) {
                    strbuilder.append(characters[i][j]);
                    if(j<8) strbuilder.append(",");
                }
            }

            bwriter.write(strbuilder.toString());
            bwriter.close();

        } catch(IOException e) {
            System.out.println("Unexpected error...");
            
        }

    }
	
	
}
