/**
 * Some utility methods for Strings.
 * @author Vichakorn
 */
public class StringUtil {
	/**
	 * Find the index of a String (arg) in an array of Strings.
	 * @param arg is the string to search for
	 * @param array is an array of Strings to examine
	 * @return the index of first occurence of arg, or -1 if it is not in the array.
	 */
	public static int indexOf(String arg, String[] array) {		
		int index = -1;
		int length = array.length;
		for(int k=0; k<length; k++) {
			if (array[k].equals(arg)) return k;
		}
		return index;
	}
}
