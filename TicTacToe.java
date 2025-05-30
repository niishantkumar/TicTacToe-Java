import java.util.*;

class TicTacToe {

	// func to check winning condition
	public static boolean won(char arr[][], int turns, char currChar, int row, int col) {
		if (turns < 5) {
			return false;
		}

		// diagonally left-right
		if (arr[0][0] == currChar && arr[1][1] == currChar && arr[2][2] == currChar) {
			return true;
		}

		// diagonally right-left
		if (arr[0][2] == currChar && arr[1][1] == currChar && arr[2][0] == currChar) {
			return true;
		}

		// vertically
		for (int i = 0; i < 3; i++) {
			if (arr[i][0] == currChar && arr[i][1] == currChar && arr[i][2] == currChar) {
				return true;
			}
		}

		// horizontally
		for (int i = 0; i < 3; i++) {
			if (arr[0][i] == currChar && arr[1][i] == currChar && arr[2][i] == currChar) {
				return true;
			}
		}

		return false;
	}

	// func to check if position is filled
	public static boolean notVacant(char arr[][], int pos) {
		int i = (pos - 1) / 3;
		int j = (pos - 1) % 3;

		return !(arr[i][j] == '-');
	}

	// func to print board
	public static void print(char arr[][]) {
		for (int i = 0; i < 3; i++) {
			System.out.print(" ");
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j]);
				if (j < 2) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if (i < 2) {
				System.out.println("---+---+---");
			}
		}
	}

	// func to empty board
	public static void emptyBoard(char arr[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = '-';
			}
		}
	}

	// new method to get validated user move
	public static int getPlayerMove(Scanner sc, char[][] arr) {
		int pos;
		while (true) {
			try {
				pos = sc.nextInt();
				if (pos < 1 || pos > 9) {
					System.out.println("Invalid position! Please enter a number between 1 and 9.");
					continue;
				}
				if (notVacant(arr, pos)) {
					System.out.println("That position is already filled. Try another one.");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a number.");
				sc.next();
			}
		}
		return pos;
	}

	// updated method to support computer play
	public static void ticTacToe(String p1, String p2, char arr[][], boolean vsComputer) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int pos = -1;
		int turns = 1;
		char currChar;

		print(arr);

		while (turns <= 9) {
			while (true) {
				try {
					if (turns % 2 != 0) {
						System.out.print(p1 + ", enter position (1-9): ");
					} else {
						if (vsComputer) {
							pos = rand.nextInt(9) + 1;
							while (notVacant(arr, pos)) {
								pos = rand.nextInt(9) + 1;
							}
							System.out.println(p2 + " chooses position " + pos);
							break;
						} else {
							System.out.print(p2 + ", enter position (1-9): ");
						}
					}

					if (!vsComputer || turns % 2 != 0) {
						pos = getPlayerMove(sc, arr);
					}

					break;

				} catch (InputMismatchException e) {
					System.out.println("Invalid input! Please enter a number.");
					sc.next();
				}
			}

			int row = (pos - 1) / 3;
			int col = (pos - 1) % 3;

			currChar = (turns % 2 != 0) ? 'X' : 'O';
			arr[row][col] = currChar;

			print(arr);

			if (won(arr, turns, currChar, row, col)) {
				if (currChar == 'X') {
					System.out.println("Congrats " + p1 + ", you won!!!");
				} else {
					System.out.println("Congrats " + p2 + ", you won!!!");
				}

				emptyBoard(arr);
				return;
			}

			turns++;
		}

		System.out.println("It's a draw.");
		emptyBoard(arr);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("-----------------WELCOME---------------");
		System.out.println();
		System.out.println("Below are the boxes with their position number.\nRemember the positions!\n");

		System.out.println(" 1 | 2 | 3 ");
		System.out.println("---+---+---");
		System.out.println(" 4 | 5 | 6 ");
		System.out.println("---+---+---");
		System.out.println(" 7 | 8 | 9 ");

		char arr[][] = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };

		String p1 = "Player1";
		String p2 = "Player2";

		int choice;
		while (true) {
			System.out.println();
			System.out.println("Now choose any one:");
			System.out.println("1. Player Name");
			System.out.println("2. Start game (2 Players)");
			System.out.println("3. Play vs Computer");
			System.out.println("4. Quit");

			while (true) {
				try {
					System.out.print("Enter your choice: ");
					choice = sc.nextInt();

					if (choice >= 1 && choice <= 4) {
						break;
					} else {
						System.out.println("Invalid choice! Please enter 1, 2, 3, or 4.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! Please enter a number.");
					sc.next();
				}
			}

			switch (choice) {
				case 1: {
					System.out.print("Enter name of player1 : ");
					sc.nextLine();
					p1 = sc.nextLine();

					System.out.print("Enter name of player2 : ");
					p2 = sc.nextLine();
				}
					break;

				case 2: {
					System.out.print("Choose who will begin (1-Player1, 2-Player2) : ");
					int begin = sc.nextInt();

					if (begin == 1) {
						ticTacToe(p1, p2, arr, false);
					} else {
						ticTacToe(p2, p1, arr, false);
					}
				}
					break;

				case 3: {
					p2 = "Computer";
					System.out.print("Do you want to go first? (y/n): ");
					sc.nextLine();
					String first = sc.nextLine();

					if (first.equalsIgnoreCase("y")) {
						ticTacToe(p1, p2, arr, true);
					} else {
						ticTacToe(p2, p1, arr, true);
					}
				}
					break;

				case 4: {
					sc.close();
					System.exit(0);
				}
			}
		}
	}
}