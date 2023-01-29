package v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Designed to activate the connectivity Of the Neurons and Training module
 * per Nucleus.
 * 
 * @author xer0n3 - developing821@outlook.com
 *
 */

public class Activation {
	
	// Make s static reference to our HashMap
	static HashMap<Integer, ArrayList<Object>> hive = NeuralNet.getBeehive();
	
	// Get our cubic volume for the storage size of each index
	static int[][] connect = new int[(int) Math.pow(NeuralNet.getV_qty(), 3)][(int) Math.pow(NeuralNet.getV_qty(), 3)];

	/**
	 * Makes call to Collision detection in PointInside.is() method
	 * to assess per key Integer which connections can be made per 
	 * the Spherical proximities detailed in Red, Green and Touch classes.
	 * 
	 * @throws IOException
	 */
	public static void activate() throws IOException {
		
		// Create a secondary HashMap for content storage to iterate over later
		HashMap<Integer, Integer> connections = new HashMap<>();

		System.out.println("Starting our activation module for proximities and the training program...");
		
		/* 
		 * Populate the index of connect with 
		 * the initial keys and assign 
		 * the values to connections based
		 * on proximity based connectivity
		 * making use of PointInside.is()
		 */
		for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet()) {
			for (int p : connect[bee.getKey().intValue()]) {
				
				int[] a = PointInside.is(bee.getKey());
					
				connections.put(bee.getKey(), a[p]);
			}
		}
			
		System.err.println(connections.values());
		System.err.println(connections.keySet());
		System.out.println(connections);
		NeuralNet.setConnections(connections);
	}
}
