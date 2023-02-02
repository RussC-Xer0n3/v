package v;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Our output layer weights are adjusted according to our desired
 * output and are required to return a single value of either 1 or 0
 * 
 * The weights are then set as values here and in NeuralNet class for
 * adjustment and use making use of Getters and Setters
 *  
 * @author xer0n3 - developing821@outlook.com - R. Clarke
 * @TDOD complete
 */

public class OutputLayer {
	
	static HashMap<Integer, ArrayList<Object>> beehive;
	private static double[] outputLayerOutputs;
	private static double[] outputLayerWeights;
	
	/**
	 * Set our initial output layer weights
	 */
	public static void outputLayerInitialWeights () {
		System.err.println("Generating outputLayer Initial weights...");
		
		double[] initial = GenerateWeights.weights(4);
		for (int iw = 0; iw < initial.length; iw++) {
			System.err.println("Initial output weights: " + initial[iw]);
		}
		OutputLayer.setOutputLayerWeights(initial);
		NeuralNet.setOutputLayerWeights(initial);
	}

	/**
	 * Working with error calculation and adjustment of 
	 * our output layer to get a set of Integer results
	 */
	public static void output() {
		
		System.err.println("Beginning to calculate the the output layer weights and adjustments...");
		
		double sum = 0;
		double[] desiredOutputs = NeuralNet.getDesiredOutput();
		double[][] inputs = NeuralNet.getInputs();
		outputLayerWeights = NeuralNet.getOutputLayerWeights();
		
		sum = Summation.summation(desiredOutputs, outputLayerWeights);
		
		System.err.println("Adjusting hidden weights and weights of the output layer initially no adjustment...");
		
		if(sum <= 4) {
			//for (double[] g : inputs) {
			for (int layer = 0; layer < 4; layer++) {
				Error.error(inputs[layer], outputLayerOutputs, desiredOutputs, NeuralNet.getHiddenLayerOutputs(), outputLayerWeights, NeuralNet.getLearningrate(), NeuralNet.getHiddenLayerWeights());
			}
		}
		
		System.err.println("Setting our output Layer Ouputs a set of four digits...");

		double[] outputz = new double[4];
		
		/*
		 * Cycle through the outputLayerWeights and get a threshold
		 * Assign to Array
		 * and the the new outputs
		 */
		for (int outputs = 0; outputs < 4; outputs++) {
			if (Threshold.threshold(outputLayerWeights[outputs]) == 1) {
				outputz[outputs] = 1;
			} else{
				outputz[outputs] = 0;
			}
		}

		OutputLayer.setOutputLayerOutputs(outputz);		
		NeuralNet.setOutputLayerOutputs(outputLayerOutputs);
		NeuralNet.setOutputLayerWeights(outputLayerWeights);
	}
	
	//Getters and Setters
	public static double[] getOutputLayerOutputs() {
		return outputLayerOutputs;
	}
	
	public static void setOutputLayerOutputs(double[] d) {
		OutputLayer.outputLayerOutputs = d;
	}

	public static double[] getOutputLayerWeights() {
		return outputLayerWeights;
	}

	public static void setOutputLayerWeights(double[] outputLayerWeights) {
		OutputLayer.outputLayerWeights = outputLayerWeights;
	}
}
