import java.util.Scanner;

/**
 * 
 */

/**
 * @author User Ian Chow Matriculation Number:150021126
 *
 */
public class Menu extends Lottery {

	/**
	 * 
	 */

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Displays the Menu options
	 */
	private static void displayMenu() {
		splitter();
		System.out.println("\nPlease select one of the options below\n");
		System.out.println("1. Single Player Lottery");
		System.out.println("2. Multi-player Lottery");
		System.out.println("3. Recur Lottery");
		System.out.println("4. Test");
		System.out.println("5. Instructions");
		System.out.println("6. Exit");
	}

	/**
	 * Displays the instructions to use the Lottery Simulator.
	 */
	public static void instructions() {
		System.out.println("1. Only numbers between 1-50 can be entered as \npossible lottery Numbers.");
		System.out.println("2.The maximum range that can be entered is 20.");
		System.out.println("3.The minimum range that can be entered is 3.");
		System.out.println(
				"4.Numbers entered cannot be same from previous \nnumbers when entering lottey numbers to be bought.");
		System.out.println(
				"5.Winnings: \na) 3 Matches=  £25 \nb) 4 Matches =  £100 \nc) 5 Matches = £1000 \nd) 6 Matches = £1,000,000 \ne)Subsequent Matches after 6 =  £1,000,000 ");

	}

	/**
	 * process the selected choice made by the user and loads the subsequent
	 * methods.
	 */
	public static void processUserChoices() {
		LotterySet newSet = new LotterySet();
		Lottery myLotto = new Lottery();
		boolean decision = true; // used to determine if the user has made the
									// choice to exit the program
		displayMenu();
		do {
			String choice; // to determine which Menu choice was chosen by the
							// user;leave as string to prevent any errors.

			Scanner sc8 = new Scanner(System.in);
			choice = sc8.nextLine();

			switch (choice) {
			case ("1"):
				splitter();

				myLotto.setLotteryRange(lotteryRange);
				myLotto.setLotteryNums();
				myLotto.setPlayerNums(lotteryRange);
				myLotto.checkWinnings();
				myLotto.displayLottoNums();
				processUserChoices();
				break;

			case ("2"):
				splitter();
				myLotto.multiPlayer(lotteryRange);
				myLotto.displayLottoNums();
				processUserChoices();

				break;

			case ("3"):

				splitter();
				myLotto.recurLottery(lotteryRange);

				processUserChoices();

				break;
			case ("4"):

				splitter();
				Tester testing = new Tester();
				testing.testAll();
				processUserChoices();

				break;
			case ("5"):

				splitter();
				instructions();

				processUserChoices();

				break;

			case ("6"):
				exit();
				break;

			default:

				System.out.println("Invalid Option was selected,please select again.");
				displayMenu();
				break;

			}
		} while (decision == true);

	}

	/**
	 * Displays message to notify the user the program has been closed.
	 * 
	 * @return
	 */
	public static void exit() {

		System.out.println("\nGoodbye");
		return;

	}

	/**
	 * A splitter line used to present the program in a more readable format
	 * with the line denoting the end of various methods.
	 */
	public static void splitter() {
		System.out.println("_________________________________________________");
		System.out.println(""); // creates an extra line of space

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		processUserChoices();
	}

}
