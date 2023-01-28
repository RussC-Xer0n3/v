package v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import java.util.Random;

/**
 * Makes use of HashMap to randomly generate Neurons inside a volume
 * 
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 *
 */
public class HiveNest {

	private static HashMap<Integer, ArrayList<Object>> beehive = new HashMap<>();
	static ArrayList<ArrayList<ArrayList<Object>>> cells = new ArrayList<>();

	/**
	 * Populate an ArrayList with n indices cubed.
	 * 
	 * @param n
	 * @return Three dimensional ArrayList c
	 */
	public static ArrayList<ArrayList<ArrayList<Object>>> hive(int n) {

		int i, j;
		int x_axis = n;
		int y_axis = n;
		int z_axis = n;

		ArrayList<ArrayList<ArrayList<Object>>> c = new ArrayList<>(x_axis);

		for (i = 0; i <= x_axis; i++) {
			c.add(new ArrayList<ArrayList<Object>>(z_axis));

			for (j = 0; j < z_axis; j++) {
				c.get(i).add(new ArrayList<Object>(y_axis));
			}
		}

		return c;
	}

	/**
	 * Randomly populate the mapped volume with Neurons
	 * @param neuron
	 * @param qty - Quantity of neurons
	 * @param v - Received autonomously from mapping()
	 * @throws IOException 
	 */
	public static void populate(ArrayList<Object> neuron, int qty, double v) throws IOException {
		System.err.println("Populating volume with Neurons...");
		Random rand = new Random();
		
		for (int i = 0; i <= qty; i++) {int m = rand.nextInt((int) v); beehive.put(m, Neuron.neuron());}
		
		System.err.print("Original mapping hashcode after first generation: " + beehive.hashCode() + "\n");
		NeuralNet.setBeehive(beehive);
	}

	/**
	 * Maps the cubic index length to the ArrayList c and calls the populate()
	 * autonomously to populate the list and the mapping with the Neurons
	 * 
	 * @param neuron - An Objectified ArrayList comprising the AI and areas / proximities
	 * @param qty - The quantity of Neurons to deploy randomly in your mapped volume
	 * @param n - The index to be used to calculate the cubic size of the volume
	 * @return 
	 * @throws IOException 
	 */
	public static HashMap<Integer, ArrayList<Object>> mapping(ArrayList<Object> neuron, int qty, int n) throws IOException {
		System.err.println("Mapping out a hash map of " + n + " cubed...");
		int v = (int) Math.pow(n, 3);

		System.err.println("Creating Volume cubic size: " + v + "...");

		//Call to create out bee hive ready to map out neurons (bees) into random cells
		HiveNest.hive(v);
		
		//Once we have our cells we can begin to populate, them with our bees....
		HiveNest.populate(neuron, qty, v);
		
		//Ensure we have set our beehive
		NeuralNet.setBeehive(beehive);
		
		//Set the value of our first index in the neuron to the training(), that's the brain of the bee...
		System.err.println("Adding our coordinates ...");
		for (Entry<Integer, ArrayList<Object>> populated : beehive.entrySet()) {
			
			int x = GetX.getx(populated.getKey().intValue());
			int z = GetZ.getz(populated.getKey().intValue());
			int y = GetY.gety(populated.getKey().intValue());
			
			populated.getValue().set(8, x);
			populated.getValue().set(9, z);
			populated.getValue().set(10, y);}
		
		return beehive;
	}

	/**
	 * Clear the data in memory store after use.
	 * @throws IOException 
	 */
	public static void clearall() throws IOException {
		beehive.clear();
		cells.clear();
	}
}
