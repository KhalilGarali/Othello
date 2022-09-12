import java.io.FileNotFoundException;
import java.util.Scanner;

public class OthelloDriver {
	public static boolean load;
	
	public static void main(String[] args) {
		System.out.println("Welcome to Othello!");
		System.out.println("Please choose between these options:");
		System.out.println("1. Load a Game");
		System.out.println("2. Quit");
		System.out.println("3. Create a New Game");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		switch(option) {
			case 1: 
				System.out.println("Please enter the file name:");
				load = true;
				try {
				Board b = Game.load(scanner.next());
				Game othelloLoad = new Game(b);
				othelloLoad.play();
				}
				catch(FileNotFoundException e) {
					System.out.println("File not found...");
				}
				break;
			case 2: 
				System.out.println("Othello says bye!!");
				System.exit(0);
				break;
				
			case 3:
				load = false;
				System.out.println("Please enter the name for player 1");
				String name = scanner.next();
				Player p1 = new Player(name);
				p1.setPlayer(1);
				System.out.println("Please enter the name for player 2");
				Player p2 = new Player(scanner.next());
				p2.setPlayer(2);
				Game othello = new Game(p1,p2);
				othello.play();
				}
		}
		
}
