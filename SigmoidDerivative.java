package v;

/**
 * The derivative activation of the double value
 * 
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 * @reference https://www.geeksforgeeks.org/derivative-of-the-sigmoid-function/ - GeeksforGeeks - 2023
 */
public class SigmoidDerivative {
	
	/**
	 * Returns a double value for the derivative 
	 * activation of the parameter
	 * 
	 * @param x
	 * @return
	 */
	public static double sigmoid_d(double x) {
		
		double y  = Sigmoid.sigmoidFunction(x);
		
		return y * (1.0 - y);
	}
}
