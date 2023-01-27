package v;

/**
 * @reference Michael Adejoh 
 */

public class LoopOutput {
	
	/**
	 * calculate the output layer outputs
	 *  
	 * @param inputs
	 * @param outputLayerOutputs
	 * @param outputLayerWeights
	 * @param hiddenLayerOutputs
	 * @return
	 */
	
    public static double[] loop_output(double[] inputs, double[] outputLayerOutputs, double[][] outputLayerWeights, double[] hiddenLayerOutputs) {
		int a = 0;
		
	    for (double weights[] : outputLayerWeights) {
	        //calculate the summation between the hidden layer neurons and the output layer neurons
	        double summation = Summation.summation(hiddenLayerOutputs, weights);
	        //apply the step function
	        double neuronOutput = Threshold.threshold(summation);
	        //populate the outputlayer output
	        outputLayerOutputs[a] = neuronOutput;
	        a++;
	    }
	    System.err.println("Ouput Layer Outputs: " + outputLayerOutputs);
	    return outputLayerOutputs;
    }
}
