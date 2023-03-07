package v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//import com.opencsv.CSVWriter;
//import com.opencsv.CSVWriterBuilder;

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

	//static ArrayList data = new ArrayList<>();
	
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

		System.out.println("\nStarting our activation module for proximities and the training program...\n");
		
		/* 
		 * Populate the index of connect with 
		 * the initial keys and assign 
		 * the values to connections based
		 * on proximity based connectivity
		 * making use of PointInside.is()
		 */
		
//		File file = new File("C:\\Users\\xer0n3\\eclipse-workspace\\V2\\src\\v\\hive.csv");
//		
//		//Instantiating the CSVWriter class
//		FileWriter outputfile = new FileWriter(file);
//		
//		// create CSVWriter object filewriter object as parameter
//        CSVWriter writer = new CSVWriter(outputfile);
		
//		for (int z = 0; z < 50; z++) {
			//For 1000 times we want data collected to look at the mapping and the connections
			HiveNest.mapping(NeuralNet.getNeuron(), NeuralNet.getN_qty(), NeuralNet.getV_qty());
			
			for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet()) {
				
				//String b = null;
								
				for (int p : connect[bee.getKey().intValue()]) {
					
					int[] a = PointInside.is(bee.getKey());
					//b = String.valueOf(a[p]);
					connections.put(bee.getKey(), a[p]);
					
				}
				
//				data.add(new String[] {String.valueOf(bee.getKey()), b, });
			}
//			writer.writeAll(data);
//			data.clear();
//		}
		
		System.err.println(connections.values() + "\n");
		System.err.println(connections.keySet() + "\n");
		System.out.println(connections + "\n");
		NeuralNet.setConnections(connections);
	}
}
