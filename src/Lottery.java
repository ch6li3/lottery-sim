/**
 * 
 */

/**
 * @author User Ian Chow Matriculation Number:150021126
 *
 */

import java.util.*;

public class Lottery extends LotterySet {

	private Set<Integer> numbers;
	private Set<Integer> LotteryNumbers;
	private Queue<Integer> score = new LinkedList();
	public static int lotteryRange = 6;
	private int winnings;

	/**
	 * 
	 */
	public Lottery() {
		// TODO Auto-generated constructor stub
		numbers = new TreeSet<Integer>();

		LotteryNumbers = new TreeSet<Integer>();
	}

	/**
	 * Randomly generates numbers between 1 to 100 to be added in a set which
	 * contains all the computer generated lottery numbers.
	 */
	public void setLotteryNums() {

		int max = 50;
		int min = 1;
		Random randomNum = new Random();

		while (LotteryNumbers.size() < lotteryRange) {
			int lotteryNum = min + randomNum.nextInt(max);

			LotteryNumbers.add(lotteryNum);

		}

	}

	/**
	 * Prompts user for the cardinality of the number set to set degree of
	 * difficulty of the lottery. The maximum number of cardinality is set to
	 * 20.
	 * 
	 * @param newRange
	 */
	public void setLotteryRange(int newRange) {
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("Please enter the range of lottery Numbers");
			newRange = sc.nextInt();

			if (newRange == 0) {
				throw new DataStructureException("0 is an invalid range.");
			} else if (newRange == 1) {
				throw new DataStructureException("1 is an invalid range.");
			} else if (newRange < 3) {
				throw new DataStructureException(
						" Invalid range. Range of numbers must be at least 3 or more but less than 20.");
			} else if (newRange > 20) {
				throw new DataStructureException("Range entered is too large! ");
			}

		} catch (Exception e) {

			System.out.println(e);
			System.out.println("Invalid Input. Only enter a number.");
			Menu.processUserChoices();
		}
		lotteryRange = newRange;

	}

	public int getLotteryRange() {
		return lotteryRange;
	}

	/**
	 * Reads in a set amount of numbers from the user to be added to a set which
	 * stores the users lottery number. The cardinality is determined by the
	 * parameter lotteryRange. Throws an exception if the value entered is less
	 * than 0 or more than 100.
	 * 
	 * @param lotteryRange
	 * @throws DataStructureException
	 */
	public void setPlayerNums(int lotteryRange) throws DataStructureException {

		Scanner sc = new Scanner(System.in);
		try {

			for (int count = 1; count <= lotteryRange; count++) {
				System.out.println("Please Input a number from 1-50.");
				int tempNum = sc.nextInt();

				if (numbers.contains(tempNum)) {

					throw new DataStructureException(
							"Numbered entered is the same. \nPlease enter different numbers each time.");
				} else if (tempNum <= 0 || tempNum > 50) {
					throw new DataStructureException("Numbered entered is out of bounds.");
				}

				else {
					numbers.add(tempNum);
				}
			}
		} catch (Exception e) {

			System.out.println(e);
			System.out.println("Only enter numbers between 1-50.\n");
			Menu.processUserChoices();
		}
	}

	public Set<Integer> getLotterNumber() {
		return LotteryNumbers;
	}

	public Set<Integer> getPlayerNumbers() {
		return numbers;
	}

	/**
	 * Displays the numbers lottery set for logical checking.
	 */
	public void displayLottoNums() {

		System.out.println("\nLottery Numbers:" + LotteryNumbers);

	}

	/**
	 * calculates the cardinality of the sets.
	 */
	public void numberSize() {
		System.out.println("Total Lottery Numbers:" + LotteryNumbers.size());

		// print cardinality
		System.out.println("Total Player Numbers:" + numbers.size());
	}

	/**
	 * Check if any numbers match between both sets and calculates the winnings.
	 * 
	 * @return
	 */
	public int checkWinnings() {
		Set<Integer> copy_set = new TreeSet<Integer>();

		// Create a copy of set numbers(players numbers)

		copy_set.addAll(numbers);

		// System.out.println("Copied Set:" + copy_set);

		copy_set.retainAll(LotteryNumbers);
		System.out.println("Winning Numbers:" + copy_set);

		if (copy_set.size() == 3) {
			System.out.println("You have won  £25 with numbers" + copy_set + "!");
			winnings += 25;
		} else if (copy_set.size() == 4) {
			System.out.println("You have won  £100 with numbers" + copy_set + "!");
			winnings += 100;
		} else if (copy_set.size() == 5) {
			System.out.println("You have won  £1000 with numbers" + copy_set + "!");
			winnings += 1000;
		} else if (copy_set.size() == 6) {
			System.out.println("Congragulations! You have won  £1,000,000 with numbers" + copy_set + "!");
			winnings += 1000000;
		} else if (copy_set.size() > 6) {
			winnings = 1000000 + ((copy_set.size() - 6) * 1000000);
			System.out.println("Congragulations! You have won" + winnings + " with numbers" + copy_set + "!");
		} else if (copy_set.size() == 0) {
			System.out.println("No matching numbers. Try again next time.");
		}

		return winnings;
	}

	/**
	 * Multiplayer gameplay of the lottery simulator. Reads in each players
	 * numbers and calculates players winnings.
	 * 
	 * @param newRange
	 */
	public void multiPlayer(int newRange) {
		Scanner sc = new Scanner(System.in);
		try {
			int players = 0;
			System.out.println("Enter number of players");
			players = sc.nextInt();

			if (players == 0) {
				throw new DataStructureException("0 is not a valid input!");
			} else if (players == 1) {
				throw new DataStructureException("1 is not a valid input!");
			}
			setLotteryRange(newRange);
			for (int count = 1; count <= players; count++) {
				System.out.println("\nPlayer" + count + ":");
				setPlayerNums(lotteryRange);
				setLotteryNums();
				checkWinnings();
				numbers.removeAll(numbers);
				score.add(winnings);

			}
			System.out.println(""); // spacing
			for (int count = 1; count <= players; count++) {
				int temp = score.poll();

				System.out.println("Player" + count + ": Won £" + temp);
			}

		}

		catch (Exception e) {

			System.out.println(e);
			System.out.println("Please only enter numbers.");

		}

	}

	/**
	 * Request the number of draws and a single set of numbers of user lottery
	 * Number set which is compared to the randomly generated draws. Each
	 * randomly generated draw has different sets of numbers. The winnings are
	 * calculated along with the gross profit.
	 * 
	 * @param newRange
	 */
	public void recurLottery(int newRange) {
		Scanner sc = new Scanner(System.in);
		try {
			int draws = 0;
			int total = 0;
			System.out.println("Please enter the number of Lottery draws. ");
			draws = sc.nextInt();

			if (draws == 0) {
				throw new DataStructureException("0 is not a valid input!");
			}

			setLotteryRange(newRange);

			int amountSpent = draws * 2;
			setPlayerNums(lotteryRange);
			for (int count = 1; count <= draws; count++) {
				System.out.println("\nDraw number:" + count);
				setLotteryNums();
				checkWinnings();
				displayLottoNums();
				LotteryNumbers.removeAll(LotteryNumbers);
				score.add(winnings);
				winnings = 0; // reset the winnings for next draw so that it can
								// be stored in the queue individually
			}
			for (int count = 1; count <= draws; count++) {
				int temp = score.poll();
				total = total + temp;

			}
			int profit = total - amountSpent;
			System.out.println("Player has won:" + "£" + total);
			System.out.println("Gross profit:" + "£" + profit);
		}

		catch (Exception e) {

			System.out.println(e);
			System.out.println("Please only enter numbers");
		}
	}

}