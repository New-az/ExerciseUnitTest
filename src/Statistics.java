import java.util.Arrays;

/**
 * Methods for computing some common statistics,
 * such as average, variance, and correlation.
 * 
 * @author Thanaphon Keawjam
 */
public class Statistics {

	/**
	 * Compute the arithmetic average of an array of numbers.
	 * @param x is array to compute average of.  Must not be null.
	 * @return the arithmetic average of values in x, or 0 if x is empty.
	 * @throws NullpointerException if x is null.
	 */
	public static double average(double[] x) {
		// Some fun: sum using a Stream instead of a loop.
		if (x == null) throw new NullPointerException();
		int length = x.length;
		if (length == 0) return 0;
		double sum = Arrays.stream(x).sum();
		return sum/length;
	}
	
	/**
	 * Compute the variance of values in an array.
	 * Variance uses the formula sum(x[k]*x[k])/length(x) - average(x)^2.
	 * 
	 * @param x is the array of values. Must contain at least 1 element.
	 * @return the variance of x
	 * @throws IllegalArgumentException if x is empty
	 */
	public static double variance(double[] x) {
		double sum = 0;
		int length = x.length;
		
		if (length == 0) throw new IllegalArgumentException();
		
		for(int i=0; i<length; i++)
			sum = sum + (x[i]*x[i]);
		
		return sum/length - Math.pow(average(x), 2);
	}
	
	/**
	 * Compute the covariance between arrays x and y.
	 * The covariance is defined by
	 * 
	 * sum[ (x[k] - average(x)) * (y[k] - average(y)) ]/n
	 * where n is number of elements in the arrays.
	 * 
	 * But it is more efficient to compute using the equivalent formula:
	 * 
	 * sum( x[k]*y[k] )/n - average(x)*average(y)
	 * 
	 * Note that if x == y, this is the variance.
	 * 
	 * @param x is the first array of values.
	 * @param y is the second array of values
	 * @return the covariance between x and y
	 * @throws IllegalArgumentException if arrays are not same length or length is 0.
	 */
	public static double covariance(double[] x, double[] y) {
		int lengthX = x.length;
		int lengthY = y.length;
		double sum = 0;
		
		if(lengthX != lengthY || lengthX == 0 || lengthY == 0) throw new IllegalArgumentException();
	
		if(Arrays.equals(x, y)) return variance(x);
		
		double avgX = average(x);
		double avgY = average(y);
		
		for(int i=0; i<lengthX; i++) {
			sum = sum + ( (x[i] - avgX) * (y[i] - avgY) );
		}
		
		return sum/lengthX;
	}
	
}
