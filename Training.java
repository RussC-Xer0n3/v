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
		int t_qty = NeuralNet.getT_qty();
		double sum = 0;
		
		for (int i = 0; i <= t_qty; i++) {
			
			for (int in = 0; in < input.length; in++) {
				Error.error(input[in], outputLayerOutputs, output, hiddenLayerOutputs, outputLayerWeights, learningrate, hiddenLayerWeights);
			}
			
			//adjust the output layer weights
	        AdjustWeights.adjustOutputWeights(outputLayerWeights, hiddenLayerOutputs, NeuralNet.getOuputNeuronError());
	        
	        //adjust the hidden layer weights
	        AdjustWeights.adjustHiddenWeights(output, hiddenLayerWeights, NeuralNet.getHiddenNeuronError());
	        
	        		
			for (int s = 0; s <= input.length-1; s ++) { sum = Summation.summation(output, outputLayerWeights); }
		}
		
		sum -= (sum + sum);
		System.out.println(sum);
		
		return Training.class;
	}
}
