/**
 * @author Antria Argyrou ID:1038761
 * @version 1.0
 * @brief this is the main of the game. It creates the object and tells to the player if the hit a watercraft or not
 * if the counter wrecked goes to 14 it means the the player have hit all the watercrafts that have been randomly put by
 * the computer. The player can quit the game any time.
 * 
 *
 */
import java.util.Scanner;

public class TestBattleship {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String uname, command;
		char firex = '0', firey = '0', gamepanel[][];
		int wrecked = 1, count = 1;
		System.out.println("Welcome to the naval battleship game \n Enter username:");
		uname = scan.next();
		EPL233Battleship battle = new EPL233Battleship(uname);

		System.out.println("\n" + "Player " +uname+ " you now can start playing \n Good luck!");
		System.out.println("Round " + count);
		
		command = scan.nextLine();
		command = scan.nextLine();
		
		
		while (wrecked < 14) {
			if (command.equals("quit")) {
				System.out.println("You just quited succesfully the game");
				break;
			} 
			else if (command.equals("help"))
				battle.help();
			else if (command.substring(0, 4).equals("fire")) {
				gamepanel = battle.getdashb();
				firex = command.charAt(5); 
				firey = command.charAt(7); 
				battle.fire(firex, firey);
				
				for (int i = 0; i < gamepanel.length; i++) {
					for (int j = 0; j < gamepanel.length; j++) {
						if (gamepanel[i][j] == 'X')
							wrecked++;
					}
				}
				if (wrecked != 14)
					wrecked = 1;

			} else {
				System.out.println("Wrong Command!");
				battle.help(); 
				command = scan.nextLine();
			}
			count++;
			System.out.println("\nRound " + count);
			System.out.println("Enter new command.");
			command = scan.nextLine();

		}
		if (wrecked == 14)
			System.out.println("Player "+uname+" no more watercrafts \n Congratulations!Thanks for playing");
		
    scan.close();
	}

}
