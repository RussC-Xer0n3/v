package v;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ArrayList;

/**
 * Adjusts output layer weights based on the desired output and the 
 * input values according to the learning rate and the
 * mean error calculated in Error class
 * 
 * @author xer0n3 - developing821@outlook.com - R. Clarke
 * @reference https://stackoverflow.com/questions/66570161/Sigmoid-function-in-java-rounds-up-positive-values-to-1#:~:text=Sigmoid%20Function%20in%20Java%20rounds%20up%20positive%20values,Digits%20Dataset%20from%20the%20UCI%20Machine%20Learning%20Repository. - michael adejoh - March 2021
 */
public class AdjustWeights {
	
	static double learning_rate = NeuralNet.getLearningrate();
	
	/**
	 * Repopulate the weights after they have been adjusted in the hidden layer
	 * we need both the hidden layer weights and the weights in the Neural Net to 
	 * be updated even though the hiddenLayerWeights are representative
	 * 
	 * @param desiredOutput
	 * @param input
	 * @param learning_rate
	 * @param error
	 */
	public static void adjustHiddenWeights(double[] desiredOutput, double[] input, double error) {
		
		double[] weights = new double[desiredOutput.length];
		
		for (int i = 0; i < input.length; i++) {
	        if (i < weights.length) {
	            weights[i] = weights[i] + learning_rate * error * input[i];
	        }
	    }
		
		NeuralNet.setHiddenLayerWeights(weights);
	}
}
