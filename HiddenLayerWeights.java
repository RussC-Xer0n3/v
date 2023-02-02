package v;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Get the randomised Weights and assign them to each Neuron index 7
 * 
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 */

public class HiddenLayerWeights {
	
	static HashMap<Integer, ArrayList<Object>> beehive;
	static double[] hiddenLayerWeights;
	
	public static void hidden () {
		System.err.println("Begginning to set hidden layer weights to each neuron....");
		beehive = NeuralNet.getBeehive();
		hiddenLayerWeights = NeuralNet.getHiddenLayerWeights();
		
		//Go through the hidden layer weights which were generated and assign them to each Neuron index 7
		for (int hl = 0; hl <= beehive.size(); hl++) {
			for (Entry<Integer, ArrayList<Object>> cells : beehive.entrySet()) {
				cells.getValue().set(7, hiddenLayerWeights[hl]);
				hl++;
			}
		}
		
		//Go through and put each weight value from each cell into an array
		double [] weights = new double[NeuralNet.getN_qty()];
		
		for (int hlw = 0; hlw <= beehive.size(); hlw++) {
			for (Entry<Integer, ArrayList<Object>> cells : beehive.entrySet()) {
				weights[hlw] = (double) cells.getValue().get(7);
				hlw++;
			}
		}
		
		//Add the array to NeuralNet system
		NeuralNet.setHiddenLayerWeights(weights);
		
	}
}
