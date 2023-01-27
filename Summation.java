package v;

/**
 * Returns a summation of inputs and weights
 * 
 * @author https://stackoverflow.com/questions/66570161/Sigmoid-function-in-java-rounds-up-positive-values-to-1#:~:text=Sigmoid%20Function%20in%20Java%20rounds%20up%20positive%20values,Digits%20Dataset%20from%20the%20UCI%20Machine%20Learning%20Repository. - michael adejoh - March 2021 
 *
 */

public class Summation {
	
	/**
	 * Surmises the values of two arrays of type double
	 * @param input
	 * @param weights
	 * @return double sum
	 */
	public static double summation(double[] input, double[] weights) {
	    double sum = 0;
	    for (int i = 0; i < input.length; i++) {
	        sum += input[i] * weights[i];
	    }
	    return sum;
	}
}
