import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author User Ian Chow Matriculation Number:150021126
 *
 */
public class Tester extends Lottery {

	/**
	 * 
	 */
	public Tester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Test functionality of the lottery class method and the set.
	 */
	public void testAll() {

		// Adding 6 numbers into the set
		Lottery lottoTest = new Lottery();
		Set<Integer> LotteryNumbers = new TreeSet<Integer>();
		LotteryNumbers.add(10);
		LotteryNumbers.add(15);
		LotteryNumbers.add(16);
		LotteryNumbers.add(18);
		LotteryNumbers.add(100);
		LotteryNumbers.add(88);
		System.out.println("Test adding 6 numbers into the set");
		System.out.println("Lottery Numbers:" + LotteryNumbers);
		System.out.println("Numbers in lottery set:" + LotteryNumbers.size() + "\n");
		LotteryNumbers.clear(); // removes all numbers in set for next test

		// Adding numbers of the same value
		LotteryNumbers.add(8);
		LotteryNumbers.add(8);
		System.out.println("\nTest Adding numbers of the same value");
		System.out.println("Lottery Numbers:" + LotteryNumbers);
		System.out.println("Numbers in lottery set:" + LotteryNumbers.size() + "\n");
		LotteryNumbers.clear(); // removes all numbers in set for next test

		// Testing copy set
		LotteryNumbers.add(8);
		LotteryNumbers.add(10);
		LotteryNumbers.add(16);
		LotteryNumbers.add(18);
		Set<Integer> copy_set = new TreeSet<Integer>();
		copy_set.addAll(LotteryNumbers);
		System.out.println("\nTesting copy set");
		System.out.println("Copied set:" + copy_set + "");
		System.out.println("Numbers in copied set:" + copy_set.size() + "\n");
		LotteryNumbers.clear(); // removes all numbers in set for next test
		copy_set.clear(); // removes all numbers in set for next test

		// Testing intersection
		Set<Integer> numbers = new TreeSet<Integer>();
		LotteryNumbers.add(8);
		LotteryNumbers.add(10);
		LotteryNumbers.add(16);
		LotteryNumbers.add(18);
		System.out.println("\nTesting intersection of setA and setB");
		System.out.println("Numbers in Set A:" + LotteryNumbers);
		System.out.println("Size of Set A:" + LotteryNumbers.size() + "\n");
		numbers.add(8);
		numbers.add(10);
		numbers.add(55);
		numbers.add(88);
		System.out.println("Numbers in Set B:" + numbers);
		System.out.println("Size of Set B:" + numbers.size());
		copy_set.addAll(numbers);
		copy_set.retainAll(LotteryNumbers);
		System.out.println("Intersect numbers:" + copy_set + "\n");
		System.out.println("Numbers in set B" + numbers); // tests that set B
															// values are not
															// deleted or lost.
		copy_set.clear(); // removes all numbers in set for next test
		LotteryNumbers.clear(); // removes all numbers in set for next test
		numbers.clear();// removes all numbers in set for next test

		// Test values are removed from set.
		LotteryNumbers.add(23);
		LotteryNumbers.add(15);
		LotteryNumbers.add(18);
		System.out.println("\nTest removing values from setA");
		System.out.println("Set A:" + LotteryNumbers);
		LotteryNumbers.clear();
		System.out.println("Set A:" + LotteryNumbers);

		// Testing that each randomly generated number is added and no
		// duplicates occur, is ordered and exactly 6 numbers are stored.
		int max = 10;
		int min = 1;
		int lotteryRange = 6;
		Random randomNum = new Random();

		System.out.println("\nTest random generation of numbers withn a range and sorting.");
		while (LotteryNumbers.size() < lotteryRange) {
			int lotteryNum = min + randomNum.nextInt(max);

			System.out.println("Generated number:" + lotteryNum);

			LotteryNumbers.add(lotteryNum);

			System.out.println("Lottery Numbers:" + LotteryNumbers);
		}
		// Testing multiplayer mode
		Queue<Integer> score = new LinkedList();
		int winnings = 0;
		int players = 3;
		System.out.println("\n" + "Testing multiplayer mode and calculation of winnings");
		System.out.println("Number of players: 3");

		int lotteryRange1 = 6;

		for (int count = 1; count <= players; count++) {
			while (numbers.size() < lotteryRange1) {
				int max1 = 10;
				int min1 = 1;

				Random randomNum1 = new Random();
				int num = min1 + randomNum1.nextInt(max1);
				numbers.add(num);

			}
			copy_set.addAll(numbers);

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

			score.add(winnings);
			System.out.println("Players" + count + ":" + numbers + "\n");
			numbers.clear();
			winnings = 0;
		}
		for (int count = 1; count <= players; count++) {
			int temp = score.poll();
			System.out.println("Player" + count + ":" + " £" + temp);
		}
		System.out.println("\nLottery Numbers:" + LotteryNumbers);
		copy_set.clear(); // clear set for next test
		score.clear();// clear queue for next test

		// test running lottery for multiple draws
		int draws = 5;
		int total = 0;
		int winning = 0;
		System.out.println("\nTest running lottery for multiple draws and calculating profits.");

		while (numbers.size() < lotteryRange1) {
			int max1 = 10;
			int min1 = 1;

			Random randomNum1 = new Random();
			int num = min1 + randomNum1.nextInt(max1);
			numbers.add(num);

		}
		copy_set.addAll(numbers);

		int amountSpent = draws * 2;

		for (int count = 1; count <= draws; count++) {
			System.out.println("\nDraw number:" + count);
			int max3 = 100;
			int min3 = 1;
			Random randomNum3 = new Random();

			while (LotteryNumbers.size() < lotteryRange) {
				int lotteryNum = min3 + randomNum.nextInt(max3);

				LotteryNumbers.add(lotteryNum);

			}
			copy_set.addAll(numbers);

			copy_set.retainAll(LotteryNumbers);
			System.out.println("Winning Numbers:" + copy_set);

			if (copy_set.size() == 3) {
				System.out.println("You have won  £25 with numbers" + copy_set + "!");
				winning += 25;
			} else if (copy_set.size() == 4) {
				System.out.println("You have won  £100 with numbers" + copy_set + "!");
				winning += 100;
			} else if (copy_set.size() == 5) {
				System.out.println("You have won  £1000 with numbers" + copy_set + "!");
				winning += 1000;
			} else if (copy_set.size() == 6) {
				System.out.println("Congragulations! You have won  £1,000,000 with numbers" + copy_set + "!");
				winning += 1000000;
			} else if (copy_set.size() > 6) {
				winning = 1000000 + ((copy_set.size() - 6) * 1000000);
				System.out.println("Congragulations! You have won" + winning + " with numbers" + copy_set + "!");
			} else if (copy_set.size() == 0) {
				System.out.println("No matching numbers. Try again next time.");
			}
			System.out.println("Lottery Numbers:" + LotteryNumbers);
			LotteryNumbers.clear();
			score.add(winning);
			winning = 0;
		}
		System.out.println("Winnings in each draw:" + score);
		for (int count = 1; count <= draws; count++) {
			int temp = score.poll();
			total = total + temp;

		}
		int profit = total - amountSpent;
		System.out.println("Player has won:" + "£" + total);
		System.out.println("Gross profit:" + "£" + profit);

	}
}
