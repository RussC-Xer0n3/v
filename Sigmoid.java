package v;

/**
 * Activation function
 * @rference Michael Adejoh
 *
 */

public class Sigmoid {

	/**
	 * Sigmoid activation function
	 * @param sum
	 * @return
	 */
	public static double sigmoidFunction(double sum) {
		 	
		 System.err.println("Processing the sum: " + sum + " in Sigmoid function...");
		    
		 double result =  1.0 / (1.0 + Math.exp(-sum));
		    
		 System.err.println("Sigmoid result is: " + result);
		    
		 return result;
	}
}
