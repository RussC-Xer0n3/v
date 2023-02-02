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
	static double[] out;
	static HashMap<Integer, ArrayList<Object>> hive = NeuralNet.getBeehive();
	static double learning_rate = Sigmoid.sigmoidFunction(NeuralNet.getLearningrate());
	static ArrayList<Double> hiddenOut = NeuralNet.getHiddenOut();
	static ArrayList<Double> hiddenWeights = NeuralNet.getHiddenWeights();
	static HashMap<Integer, Integer> connections = NeuralNet.getConnections();
	
	/**
	 * Update the outputLayerWeights according to the parameters
	 * and then assign the output thresholds
	 * @param desiredOutput
	 * @param input
	 * @param learning_rate
	 * @param error
	 */
	public static void adjustOutputWeights(double[] desiredOutput, double[] input, double error) {

		System.err.println("Adjusting weights in the outPut Layer...");
		
		double[] weights = new double[outputLayerWeights.length-1];
		double[] weight = new double[outputLayerWeights.length-1];
		double opt_sum = 0;
		
		for (int i = 0; i < desiredOutput.length-1; i++) { //for every desired output i
	        	
        	weights[i] = weight[i] + learning_rate * error * input[i]; //recalculate the weights
        	
        	//Clear the ArrayList and assign new weights
        	hiddenOut.clear();
        	
        	//Update the weights
			for (int hl = 0; hl <= outputLayerWeights.length-1; hl++) {

				outputLayerWeights[hl] = weights[hl];
				
				hiddenOut.add(weights[i]);
			
				/*
				 * Cycle through the outputLayerWeights and get a sum
				 * Assign to Array
				 */
				opt_sum += outputLayerWeights[hl]; 
			}
			
			//Divide the sum per ith iteration
			opt_sum /= 4;
			
			//get the Threshold per ith iteration
			if (Threshold.threshold(opt_sum) == 1) {
				out[i] = 1;
			} else {
				out[i] = 0;
			}
		}
		
		NeuralNet.setOutputLayerOutputs(out);
		NeuralNet.setOutputLayerWeights(outputLayerWeights); //Array
		NeuralNet.setHiddenOut(hiddenOut); //ArrayList
		
	}
	
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

		System.err.println("Adjusting weights in the hidden Layer...");
		
		double[] weights = new double[hiddenWeights.size()];
		
		for (int i = 0; i < desiredOutput.length-1; i++) {
	        	
        	weights[i] = weights[i] + learning_rate * error * input[i];
    		
			for (int hl = 0; hl <= hiddenLayerWeights.length-1; hl++) {
				
				//Add the weights to hiddenLayerWeights
				hiddenLayerWeights[hl] = weights[hl];
			}
	    }
		
		for (int i = 0; i < desiredOutput.length-1; i++) {
			//go through the connections in the arrayList, update the weights and assign them to the correct value (bee)
			for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet()) {
				
				for (Entry<Integer, Integer> connection : connections.entrySet()) {
				
					if (connection.equals(bee.getKey()) || connection.equals(bee.getValue())) {
						
						//summise the weights
						double old_weight = (double) bee.getValue().get(7);
						
						double new_weight = old_weight + learning_rate * error * input[i];
						
						//Set the new weight
						bee.getValue().set(7, new_weight);
					}
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
