package v;

/**
 * Ported from Spencer-Harper to 'think' on a 'situation'
 *  
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 * @reference https://medium.com/technology-invention-and-more/how-to-build-a-simple-neural-network-in-9-lines-of-python-code-cc8f23647ca1 - Spencer-Harper - 29/11/2022
 */

public class Think {
	
	/**
	 * Our Inputs [A] for the NN and the weights [B] respectively
	 * returns an activation result after a dot product is performed
	 * 
	 * @param inputs
	 * @param inputsB
	 * @return activation result
	 */
	public static double think(double[][] inputs, double[] inputsB) {
		System.out.println("Thinking...");
		
		double result1 = Dot.dot(inputs, inputsB);

		System.err.println("Thought Dot result is: " + result1);
		
		double result2 = Sigmoid.sigmoidFunction(result1);
		
		System.err.println("Thought Dot result is: " + result2);
		
		return result2;
	}
}
