package v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
		int t_qty = 0;
		double sum = 0;
		
		for (int i = 0; i <= t_qty; i++) {
			
			// Calculate the error (The difference between the desired output
			// and the predicted output).
			for (int in = 0; in <= input.length-1; in++) {
				Error.error(input[in], outputLayerOutputs, output, hiddenLayerOutputs, outputLayerWeights, learningrate, hiddenLayerWeights);
			}
			
			//Surmise
			for (int s = 0; s <= input.length-1; s ++) { sum = Summation.summation(output, outputLayerWeights); }
		}
		
		sum -= (sum + sum);
		
		System.out.println("The summation of accuracy was: %" + sum);
		
		return Training.class;
	}
}
