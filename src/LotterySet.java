import java.util.Collection;
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
public class LotterySet {

	/**
	 * 
	 */
	private Set<Integer> mySet = new TreeSet<Integer>();
	protected Set<Integer> intersection = new TreeSet<Integer>();

	public LotterySet() {
		// TODO Auto-generated constructor stub
	}

	// display the contents of the set data to the user
	public void printSet() {

		System.out.println("Numbers in set:" + mySet);
	}

	// Add a number to the set
	public void addToSet(int numbers) {
		mySet.add(numbers);

	}

	// returns true if the set is empty, false otherwise
	public boolean isSetEmpty() {
		if (mySet.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	// returns the cardinality of the set
	public int getCardinality() {
		return mySet.size();
	}

	// returns true if the given number is in the set already
	public boolean isInSet(int number) {
		if (mySet.contains(number)) {
			return true;
		} else {
			return false;
		}

	}

	// performs a set intersection operation by creating a copy of the current
	// set, doing a retainAll with setB and returning the result as a new MySet
	// object
	public Set<Integer> intersection() {
		Set<Integer> copy_set = new TreeSet<Integer>();
		System.out.println(mySet);
		copy_set.addAll(mySet);

		System.out.println("Copied Set:" + copy_set);

		copy_set.retainAll(mySet);
		System.out.println("Winning Numbers:" + copy_set);
		intersection.addAll(copy_set);
		return intersection;
	}
}
