
/**
 * @author User Ian Chow Matriculation Number:150021126
 * 
 * Class inherits  the existing functionality of the exception class.
 */
import java.util.NoSuchElementException;

public class DataStructureException extends NoSuchElementException {

	/**
	 * Constructor
	 * 
	 * @param error
	 *            Error message
	 * 
	 *            Takes a string parameter and pass is to the superclass
	 *            constructor when the method detects an error situation, it
	 *            will throw the exception as a user defined error message.
	 */
	public DataStructureException(String error) {
		// TODO Auto-generated constructor stub
		super(error);
	}

}
