package v;

/**
 * Rewritten to perform a dot product of a Matrix on double values
 * 
 * @author xer0n3 - developing821@outlook.com - R. Clarke
 * @reference https://javacodex.com/Math-Examples/Dot-Product#:~:text=In%20mathematics%2C%20the%20dot%20product%2C%20or%20scalar%20product,be%20defined%20either%20algebraically%20or%20geometrically.%20Source%3A%20%28DotProduct.java%29 - 2022
 *
 */

public class Dot {
	
	/**
	 * Calculates the dot product of an array matrix
	 * and returns the sum. 
	 * @param inputs
	 * @param inputsB
	 * @return sum
	 */
	public static double dot(double[][] inputs, double[] inputsB) {
		System.err.println("Starting to calculate the dot product...");
		double sum = 0;
		
		for (int i = 0; i < inputsB.length; i++) {
		    System.err.println("The inputsA length is same as the inputsB length");
	        sum += inputs[i][i] * inputsB[i];
	    }
		
		System.err.println("Dot product sum is: " + sum);
		return sum;
	}
}
