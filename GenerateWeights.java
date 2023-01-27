package v;

import java.util.Random;

/**
 * Generate a set of seeded weights for each n of neurons
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 * @reference Oracle Java API 
 */

public class GenerateWeights {

	/**
	 * Receives the number of Neurons, creates weights for them
	 * Then assigns the weights per Neuron on call.
	 * 
	 * @param n
	 * @return
	 */
	@SuppressWarnings("null")
	public static double[] weights (int n) {
		
		float max = (float) 1.0;
		int neuron_count = n;
		double[] weights = new double[n];
				
		Random rand_neuron = new Random();
		
        rand_neuron.setSeed((long) 0.4479655791986254972);

        for (int x = 0; x < neuron_count; x++) {
        	weights[x] = 2 * (rand_neuron.nextFloat(max) - max);
        }
        
        System.err.println("Initial Weights were generated successfully ...");
		return weights;
	}
}