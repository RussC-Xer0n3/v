package v;

/**
 * Calculate the adjustments required for each hidden and output layer weight
 * 
 * Ported from Michael Adejoh
 * 
 * @author xer0n3 - developing821@outlook.com - R. Clarke
 * @reference https://stackoverflow.com/questions/66570161/Sigmoid-function-in-java-rounds-up-positive-values-to-1#:~:text=Sigmoid%20Function%20in%20Java%20rounds%20up%20positive%20values,Digits%20Dataset%20from%20the%20UCI%20Machine%20Learning%20Repository. - michael adejoh - March 2021
 */

public class Error {
	
	double[] outputLayerOutputs = NeuralNet.getOutputLayerOutputs();
	
	/**
	 * Calculate the adjustments required for each 
	 * hidden and output layer weight and update them
	 * 
	 * @param input
	 * @param outputLayerOutputs
	 * @param desiredOutput
	 * @param hiddenLayerOutputs
	 * @param outputLayerWeights
	 * @param learningRate
	 * @param hiddenLayerWeights
	 */
	public static void error(double[] input, double[] outputLayerOutputs, double[] desiredOutput, double[] hiddenLayerOutputs, double[] outputLayerWeights, double learningRate, double[] hiddenLayerWeights) {
		//calculate the error in each outputlayer neuron
	    //loop through the output layer outputs
	    for (int b = 0; b < desiredOutput.length-1; b++) {
	        //compare each value with the desired outputs mapping to find the error
	        if (outputLayerOutputs[b] != desiredOutput[b]) {
	            //calculate the error for each output layer neuron (linear gradient descent)
	            double outputLayerNeuronError = desiredOutput[b] - outputLayerOutputs[b];
	            //calculate the error for each hidden layer neuron
	            for (int k = 0; k < hiddenLayerOutputs.length; k++) {
	                //hidden layer neuron error is always 0 since output layer outputs is binary
	                double hiddenLayerNeuronError = SigmoidDerivative.sigmoid_d(hiddenLayerOutputs[b]);//Last outputLayerWeights were [b][k] not [k]
	                //adjust the output layer weights
	                AdjustWeights.adjustOutputWeights(outputLayerWeights, hiddenLayerOutputs, outputLayerNeuronError);
	                //adjust the hidden layer weights
	                AdjustWeights.adjustHiddenWeights(hiddenLayerWeights, input, hiddenLayerNeuronError);
	            }
	
	        }
	    }
	}
}