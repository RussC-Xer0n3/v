package v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * The first training module to be extracted and made reusable
 * 
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 * @reference https://medium.com/technology-invention-and-more/how-to-build-a-simple-neural-network-in-9-lines-of-python-code-cc8f23647ca1 - Spencer-Harper - 2015
 * @TODO complete and modify
 */

public class Training {

	static HashMap<Integer, ArrayList<Object>> beehive = NeuralNet.getBeehive();
	static double learningrate = NeuralNet.getLearningrate();
	static double [] hiddenLayerWeights = NeuralNet.getHiddenLayerWeights();
	static double [] hiddenLayerOutputs = NeuralNet.getHiddenLayerWeights();
	static double [] outputLayerWeights = NeuralNet.getHiddenLayerWeights();
	static double [] outputLayerOutputs = NeuralNet.getOutputLayerWeights();
	
	/**
	 * Receives Neuron data and performs the training from within the 
	 * Nucleus of each Neuron
	 * 
	 * @param ID
	 * @return
	 * @throws IOException
	 */
	public static Object training(int ID) throws IOException {
	
		System.err.println("Neuron Training ID::" + ID);
		
		double[][] input = NeuralNet.getInputs();
		double[] output = NeuralNet.getDesiredOutput();
		HashMap<Integer, Integer> connections = NeuralNet.getConnections();
		int t_qty = 0;
		double sum = 0;
		
		for (int i = 0; i <= t_qty; i++) {
			
			/*
			 * Each connection index which has a value, cycle through the connections
			 * based on the ID and make the relevant updates to the weights and feed the
			 * inputs and outputs through them as a links and clusters of Neurons 
			 */
			
			for (Entry<Integer, Integer> connected : connections.entrySet() ) {
				int k = connected.getKey();
				
				if (Connected.connected(connected.getValue().intValue()) == true) {
					// Calculate the error (The difference between the desired output
					// and the predicted output).
					for (int in = 0; in <= input.length-1; in++) {
						Error.error(input[in], outputLayerOutputs, output, hiddenLayerOutputs, outputLayerWeights, learningrate, hiddenLayerWeights);
					}	
				}
			}
			
			/*
			 * We need to do another gradient descent after collating each cluster
			 * of outputs and surmising them in the Neural Net Interface.
			 */
			
			//TODO collate and surmise for every cluster
			
			//Surmise
			for (int s = 0; s <= input.length-1; s ++) { sum = Summation.summation(output, outputLayerWeights); }
		}
		
		sum -= (sum + sum);
		
		NeuralNet.clusterSum(sum);
		
		return Training.class;
	}
}
