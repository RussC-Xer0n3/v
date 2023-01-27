package v;

/**
 * @reference Michael Adejoh
 */
public class LoopHidden {
	
	/**
	 * loop through the hidden layer weights
     * calculate the summation of the inputs to get the hidden layer outputs
	 * @param inputs
	 * @param hiddenLayerOutputs
	 * @param hiddenLayerWeights
	 * @return
	 */
	public static double[] loop_hidden(double[] inputs, double[] hiddenLayerOutputs, double[][] hiddenLayerWeights) {
	    int i = 0;
	    
		for (double[] weights : hiddenLayerWeights) {
	        //calculate the summation of each neuron
	        double summation = Summation.summation(inputs, weights);
	        //populate the hidden layer outputs array
	        hiddenLayerOutputs[i] = Sigmoid.sigmoidFunction(summation);
	        i++;
	    }
		System.err.println("Hidden Layer Ouputs: " + hiddenLayerOutputs);
	    return hiddenLayerOutputs;
	}
}
