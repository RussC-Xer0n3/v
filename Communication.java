package v;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Communication {

	static HashMap<Integer, ArrayList<Object>> hive = NeuralNet.getBeehive();
	

	/**
	 * Get and return the connected Neurons for processing
	 */
	public static void connected() {
		int key = 0;
		int[] keys = new int[NeuralNet.getN_qty()];
		int qty = 0;
		
		for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet() ) {
			if (Connected.connected(bee.getKey())) {
				System.out.println(bee.getKey());
				key = bee.getKey().intValue();
				keys[0] = key;
			}
			qty++;
		}
		
		surmise(keys, qty);
	}
	
	/**
	 * get the result of each connected Neuron
	 */
	public static void surmise(int[] keys, int qty) {
		
		double result = 0;
		
		for (int j = 0; j <= keys.length-1; j++) {
			for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet() ) {
				if (Connected.connected(bee.getKey())) {
					result += bee.getValue().indexOf(7); //Sum
				}
			}
		}
		
		derivative(result, qty, keys);
	}
	
	/**
	 * for the quantity of connected to each other get the mean
	 */
	public static void derivative(double derivative, int qty, int[] keys) {
		double derived = 0;
		
		derived = derivative / qty;
		
		update(derived, keys);
		
	}
	
	/**
	 * add the mean to the weights of each connected
	 */
	public static void update(double derivative, int[] keys) {
		
		double updatedWeight = 0;
		
		for (int l = 0; l <= keys.length-1; l++) {
			for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet() ) {
				if (Connected.connected(bee.getKey())) {
					double weight = bee.getValue().indexOf(7);
					updatedWeight = derivative + weight;
				}
			}
			
			for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet() ) {
				if (Connected.connected(bee.getKey())) {
					bee.getValue().set(7, updatedWeight);
				}
			}
		}
	}
	
	/**
	 *  surmise the connected weights and output a threshold from the entire volume (hive)
	 * @return
	 */
	public static int threshold() {
		
		double sum = 0;
		int threshold = 0;
		int qty = 0;
		
		for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet() ) {
			if (Connected.connected(bee.getKey())) {
				sum += bee.getValue().indexOf(7);
				qty++;
			}
		}
		
		sum /= qty;
		
		threshold = Threshold.threshold(sum);
		
		return threshold;
	}
}
