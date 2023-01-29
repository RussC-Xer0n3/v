package v;

/**
 * Create a threshold for when to trigger an output 
 * into another Neuron
 * 
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 *
 */
public class Threshold {

	/**
	 * The sum of the activation function from think
	 * is our threshold to be assessed if 1 send data
	 * 
	 * Set a high threshold to ensure our accuracy
	 * 
	 * @param sum
	 * @return numerical 1
	 * @reference Michael Adejoh
	 */
	public static int threshold(double sum) {
	    int res = 0;
	    
	    if (sum >= 0.5) {
	        res = 1;
	    }
	    
	    return res;
	}
}
