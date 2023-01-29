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
	
	private static double[] outputLayerWeights;
	private static double[] hiddenLayerWeights;
	static HashMap<Integer, ArrayList<Object>> hive;
	
	/**
	 * Update the outputLayerWeights according to the parameters
	 * @param desiredOutput
	 * @param input
	 * @param learning_rate
	 * @param error
	 */
	public static void adjustOutputWeights(double[] desiredOutput, double[] input, double learning_rate, double error) {

		System.err.println("Adjusting weights in the outPut Layer...");
		
		double[] weights = new double[outputLayerWeights.length-1];
		
		for (int i = 0; i < desiredOutput.length-1; i++) {
	        	
        	weights[i] = weights[i] + learning_rate * error * input[i];
    		
			for (int hl = 0; hl <= outputLayerWeights.length-1; hl++) {
				outputLayerWeights[hl] = weights[hl];
			}
	    }
		
		NeuralNet.setOutputLayerWeights(outputLayerWeights);
	}
	
	/**
	 * Repopulate the weights after they have been adjusted in the hidden layer
	 * 
	 * @param desiredOutput
	 * @param input
	 * @param learning_rate
	 * @param error
	 */
	public static void adjustHiddenWeights(double[] desiredOutput, double[] input, double learning_rate, double error) {

		System.err.println("Adjusting weights in the hidden Layer...");
		
		double[] weights = new double[hiddenLayerWeights.length-1];
		
		for (int i = 0; i < desiredOutput.length-1; i++) {
	        	
        	weights[i] = weights[i] + learning_rate * error * input[i];
    		
			for (int hl = 0; hl <= hiddenLayerWeights.length-1; hl++) {
				
				//Add the weights to hiddenLayerWeights
				hiddenLayerWeights[hl] = weights[hl];

				//In the entry set
				for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet()) {

					//get the weights as a value
					double val = (double) bee.getValue().get(7);
					
					//Surmise the old with the new
					double NewWeight = val + weights[hl];

					//replace the old value
					bee.getValue().set(7, NewWeight);
				}
			}
	    }
		
		NeuralNet.setHiddenLayerWeights(hiddenLayerWeights);
	}

	/**
	 * Returns the outputLayerWeights
	 * @return
	 */
	public static double[] getOutputLayerWeights() {
		return outputLayerWeights;
	}

	/**
	 * Sets the OutputLayerWeights
	 * @param outputLayerWeights
	 */
	public static void setOutputLayerWeights(double[] outputLayerWeights) {
		AdjustWeights.outputLayerWeights = outputLayerWeights;
	}
	
	/**
	 * Returns the hiddenLayerWeights
	 * @return
	 */
	public static double[] getHiddenLayerWeights() {
		return hiddenLayerWeights;
	}
	
	/**
	 * Sets the hiddenLayerWeights
	 * @param hiddenLayerWeights
	 */
	public static void setHiddenLayerWeights(double[] hiddenLayerWeights) {
		AdjustWeights.hiddenLayerWeights = hiddenLayerWeights;
	}
}
