package v;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Designed to make use of our volume and the proximities 
 * for each neuron and establish connections based on collision theory
 * 
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 * @reference H4KR Blunt - https://gamedev.stackexchange.com/questions/16976/sphere-collision-response
 * @TODO IMPROVE
 */

public class Collisions {

	public static int x = NeuralNet.getV_qty();
	public static int y = NeuralNet.getV_qty();
	public static int z = NeuralNet.getV_qty();
	public static HashMap<Integer, ArrayList<Object>> hive = NeuralNet.getBeehive();
	
	/**
	 * Receives a single key value to be assessed and all the other
	 * keyvalues for collision detection, if there are collisions
	 * there are connections and the data is stored according only to
	 * how many Neurons there are in the volume.
	 * 
	 * @param key
	 * @param keys
	 * @return
	 */
	public static int[][] collision (int key, int keys) {
		
		System.err.println("Collision detecting...");
		
		int[][] connections = new int[1980][1980];
		
		//get our key coordinate values
		int queenbee_x = GetX.getx(key);
		int queenbee_z = GetZ.getz(key);
		int queenbee_y = GetY.gety(key);
		
		System.err.println("xzy coordinates for all keys :: " + queenbee_x + ", " + queenbee_z + ", " +  queenbee_y);
		
		//get our keys (key b) coordinate values
		int bee_x = GetX.getx(keys);
		int bee_z = GetZ.getz(keys);
		int bee_y = GetY.gety(keys);

		System.err.println("xzy coordinates key  :: " + bee_x + ", " + bee_z + ", " +  bee_y);
		//set our variables for the entry set from the hash map
		double a = 0;
		double b = 0;
		double c = 0;
		
		double qa = 0;
		double qb = 0;
		double qc = 0;
		
		//cycle through and allocate the values for key
		for (Entry<Integer, ArrayList<Object>> beehive : hive.entrySet()) {
			if (key == beehive.getKey()) {
				a = (double) beehive.getValue().get(3);
				b = (double) beehive.getValue().get(2);
				c = (double) beehive.getValue().get(1);
			}
		}
		
		//cycle through and allocate the values for keys (key b)
		for (Entry<Integer, ArrayList<Object>> beehive : hive.entrySet()) {
			if (keys == beehive.getKey()) {
				qa = (double) beehive.getValue().get(3);
				qb = (double) beehive.getValue().get(2);
				qc = (double) beehive.getValue().get(1);
			}
		}
		
		//make a subtraction of the coordinates
		int x = queenbee_x - bee_x;
		int y = queenbee_y - bee_y;
		int z = queenbee_z - bee_z;
		
		System.err.println("Coordinate subtraction xzy :: " + x + ", " + z + ", " + y);
		
		//surmise the radii of each
		double val1 = qa + b;
		double val2 = qb + c;
		double val3 = qc + a;
		
		System.err.println("Radii surmise key to keys :: " + val1 + ", " + val2 + ", " + val3);
		
		//if the multiples of radii are greater than the sum of coordinates allocate and return the value
		for (int i = 0; i <= NeuralNet.getN_qty()-1; i++) {
			if (val1 * val2 * val3 >= (x * x + y * y + z * z)) {
				connections[i][i] += connections[key][keys];
			}
		}
		
		for (int aa = 0; aa < connections.length; aa++  ) {
			System.out.println("Connection found:: " + connections[aa][aa]);
		}

		return connections;
	}
	
}
