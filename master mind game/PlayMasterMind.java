/**
* Author: Antria Argyrou & Nikolas Vaki 
* Written: 10/03/2020
* Last updated: 17/03/2020
*
* Compilation command: javac PlayMasterMind.java
* Execution command: java PlayMasterMind.java
*
* Edw ginete i enopiisi twn dio klasewn PlayerComputerMM Kai PlayerUserMM
* To programma lamvani apo tin grammi endolis to megisto arithmo prospathion gia kathe pehnidi
* kai to plithos ton paihnidiwn pou tha dieksahthoun enalax anamesa stous dio pehtes USER kai COMPUTER
* (TO Pios tha arhisi epilegete pali tihea)
* 
*
*/
import java.util.Scanner;
public class PlayMasterMind {
	Scanner scan =new Scanner(System.in);
	public static boolean WIN = false;

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		boolean userToPlay = Math.random() < 0.5;
		int tries = Integer.parseInt(args[0]);
		int times = Integer.parseInt(args[1]);
		int userWins = 0, computerWins = 0;
		System.out.println("\n\n***** WELCOME TO MASTER MIND *****");
		System.out.println("\nNumber of Games = " + times);
		System.out.println("\nFor each game the maximum number of guesses is ");
		System.out.print(tries + "\n");
		for (int i = 1; i <= times; i++) {
			WIN = false;
			if (userToPlay) {
				PlayerUserMM.Play(tries);
				if (WIN) {
					userWins++;
					System.out.println("\nThis GAME goes to the User");
				} else {
					computerWins++;
					System.out.println("\nThis GAME goes to the Computer");
				}
				userToPlay = false;
			} else {
				PlayerComputerMM.Play(tries);
				if (WIN) {
					computerWins++;
					System.out.println("This GAME goes to the Computer");
				} else {
					userWins++;
					System.out.println("This GAME goes to the User");
				}
				userToPlay = true;
			}
		}
		System.out.println("\n\nThe User has won " + userWins+" games and the Computer " + computerWins + "\n\n");
		scan.close();
	}
}