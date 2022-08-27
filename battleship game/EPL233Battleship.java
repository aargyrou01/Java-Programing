/**
 * @author Antria Argyrou ID=1038761
 * @version 4.0
 * @brief this is the class the creates the dashboard that the player doesnt see. It puts randomly the 4 watercrafts 
 * without overlaps. Also it has some other methods to play the game, like the "help" that prints some instuctions incase
 * the player needs them and the fire that find if the coordinates the the player gave have a watercraft or not
 * 
 *
 */
public class EPL233Battleship {
	public static final int T = 9;
	char arr[][];
	char dashboard[][];

	/**
	 * @brief this is the constructor it creates the 2 boards 
	 * and calls the createB, fill. fillarr and printarr
	 * @param arr
	 */
	public EPL233Battleship(String username) {
		arr = new char[T][T];
		dashboard = new char[T][T];
		createB();
		fill();
		fillarr(arr);
		printarr(dashboard);

	}


	/**
	 * @brief fills the array with -
	 * @param arr
	 */
	private void fill() {
		for (int x = 1; x < T; x++) {
			for (int y = 1; y < T; y++) {
				arr[x][y] = '-';
				dashboard[x][y]='-';
			}	
		}

	}
	/**
	 * @brief this method creates two tables. The one with the watercrafts that its hidden 
	 * from the player and the one that shows the tries of the player. It also calls the fill 
	 * method to fill the rest of the arrays with '-' 
	 * 
	 */
	private void createB() {
		int nums = 65;
		arr[0][0]=' ';
		dashboard[0][0]=' ';
		for (int i = 1; i < T; i++) {
			arr[0][i] = (char) nums;
			arr[i][0] = (char) nums;
			dashboard[i][0] = (char) nums;
			dashboard[0][i] = (char) nums;
			nums++;
		}
		fill();
			
		}
/**
 * @return the board that the player can see
 */
	protected char[][] getdashb() {
		return dashboard;
	}

	/**
	 * @brief this function creates a 2 cell watercraft at a random place in the
	 * array
	 * 
	 * @param arr[][] the array where the watercraft is going to be placed
	 */
	public void watercraft2(char arr[][]) {
		int hov = (int) (Math.random() * 2); // Horizontal or vertical
		int x = (int) (Math.random() * 7)+1;
		int y = (int) (Math.random() * 7)+1;
		
		if (hov == 0) {
			if ((x == 7 && y == 7) || x == 7) {
				x = (int) (Math.random() * 7)+1;
				y = (int) (Math.random() * 7)+1;
			}
			arr[x][y] = 'A';
			arr[x + 1][y] = 'A';
		}
		if (hov == 1) {
			if ((y == 7 && x == 7) || y == 7) {
				x = (int) (Math.random() * 7)+1;
				y = (int) (Math.random() * 7)+1;
			}
			arr[x][y] = 'A';
			arr[x][y + 1] = 'A';
		}

	}

	/**
	 * @brief this function creates a 3 cell watercraft at a random place in the
	 *        array and checks its okay to be created there (if there are not other
	 *        watercrafts there so that they wont overlap)
	 * @param arr[][] the array where the watercraft is going to be placed
	 */
	public void watercraft3(char arr[][]) {
		int hov = (int) (Math.random() * 2);
		int x = (int) (Math.random() * 7)+1;
		int y = (int) (Math.random() * 7)+1;

		if (hov == 0) {
			while (x >= 5 || arr[x][y] == 'A' || arr[x + 1][y] == 'A' || arr[x + 2][y] == 'A') {
				x = (int) (Math.random() * 5)+1;
			}
			arr[x][y] = 'B';
			arr[x + 1][y] = 'B';
			arr[x + 2][y] = 'B';

		}
		if (hov == 1) {
			while (y >= 5 || arr[x][y] == 'A' || arr[x][y + 1] == 'A' || arr[x][y + 2] == 'A') {
				y = (int) (Math.random() * 5)+1;
			}
			arr[x][y] = 'B';
			arr[x][y + 1] = 'B';
			arr[x][y + 2] = 'B';

		}
	}

	/**
	 * @brief this function creates a 4 cell watercraft at a random place in the
	 *        array and checks its okay to be created there (if there are not other
	 *        watercrafts there so that they wont overlap)
	 * @param arr[][] the array where the watercraft is going to be placed
	 */
	public void watercraft4(char arr[][]) {
		int hov = (int) (Math.random() * 2);
		int x = (int) (Math.random() * 7)+1;
		int y = (int) (Math.random() * 7)+1;

		if (hov == 0) {
			while (x >= 4 || arr[x][y] != '-' || arr[x + 1][y] != '-' || arr[x + 2][y] != '-' || arr[x + 3][y] != '-') {
				x = (int) (Math.random() * 6)+1;
			}
			arr[x][y] = 'C';
			arr[x + 1][y] = 'C';
			arr[x + 2][y] = 'C';
			arr[x + 3][y] = 'C';

		}
		if (hov == 1) {
			while (y >= 4 || arr[x][y] != '-' || arr[x][y + 1] != '-' || arr[x][y + 2] != '-' || arr[x][y + 3] != '-') {
				y = (int) (Math.random() * 6)+1;
			}
			arr[x][y] = 'C';
			arr[x][y + 1] = 'C';
			arr[x][y + 2] = 'C';
			arr[x][y + 3] = 'C';
		}
	}

	/**
	 * @brief this function creates a 5 cell watercraft at a random place in the
	 *        array and checks its okay to be created there (if there are not other
	 *        watercrafts there so that they wont overlap.
	 * @param arr[][] the array where the watercraft is going to be placed
	 */
	public void watercraft5(char arr[][]) {
		int hov = (int) (Math.random() * 2);
		int x = (int) (Math.random() * 7)+1;
		int y = (int) (Math.random() * 7)+1;

		if (hov == 0) {
			while (x >= 3 || arr[x][y] != '-' || arr[x + 1][y] != '-' || arr[x + 2][y] != '-' || arr[x + 3][y] != '-'
					|| arr[x + 4][y] != '-') {
				x = (int) (Math.random() * 3)+1;
			}
			arr[x][y] = 'D';
			arr[x + 1][y] = 'D';
			arr[x + 2][y] = 'D';
			arr[x + 3][y] = 'D';
			arr[x + 4][y] = 'D';
		}
		if (hov == 1) {
			while (y >= 3 || arr[x][y] != '-' || arr[x][y + 1] != '-' || arr[x][y + 2] != '-' || arr[x][y + 3] != '-'
					|| arr[x][y + 4] != '-') {
				y = (int) (Math.random() * 3)+1;
			}
			arr[x][y] = 'D';
			arr[x][y + 1] = 'D';
			arr[x][y + 2] = 'D';
			arr[x][y + 3] = 'D';
			arr[x][y + 4] = 'D';
		}
	}

	/**
	 * @brief this function takes all the watercrafts and out them in one array
	 * @param arr[][] the array where the watercrafts are going to be placed
	 */
	public void fillarr(char arr[][]) {
		watercraft2(arr);
		watercraft3(arr);
		watercraft4(arr);
		watercraft5(arr);

	}

	/**
	 * @brief this function prints the array
	 * @param arr[][] the array that is going to be printed
	 */
	public void printarr(char arr[][]) {
		for (int i = 0; i < T; i++) {
			System.out.println();
			for (int j = 0; j < T; j++) {
				System.out.print(String.format("%5s", arr[i][j]));
			}
		}

	}

	/**
	 * @brief prints the help that the player needs
	 */
	public void help() {
		System.out.println("Here is your help: ");
		System.out.println("fire x y: Give a posintion to try and hit a boat");
		System.out.println("quit: Quit the game");
	}

	/**
	 * @brief this function takes the coordinates the the player gives cast them to integers and checks if 
	 * in the given coordinates are any watercrafts. If there is it markes the table that the player can see with an X
	 * if not it marks it with an O
	 * @param arr[][] the array where the watercraft is going to be placed
	 */
	public void fire(char x, char y) {
		int xc =(int) x-64;
		int yc = (int) y-64;

		if (arr[xc][yc] == '-') {
			System.out.println("Miss.Try again.");
			dashboard[xc][yc] = 'O';
			printarr(dashboard);

		} else {
			dashboard[xc][yc] = 'X';
			System.out.println("\nHit!");
			printarr(dashboard);
		}
	}
	
	}

