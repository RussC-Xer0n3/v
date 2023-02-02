package v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

	static HashMap<Integer, Integer> connections;
	static HashMap<Integer, ArrayList<Object>> hive;
	
	public static void main (String []args) throws IOException {
		double[][] in = {{1000}, {0111}, {0101}, {1001}, {0110}};
		double[] out = {0111};

		NeuralNet.setN_qty(32);
		NeuralNet.setV_qty(4);
		NeuralNet.setT_qty(10000);
		NeuralNet.setIn(in);
		NeuralNet.setOut(out);
		
		//Call the Neural Network
		NeuralNet.net();
		
		//Set the hive here and the connections ready for processing into training
		hive = NeuralNet.getBeehive();
		connections = NeuralNet.getConnections();
		
		//Initialise the Training
		for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet()) {
			for (Entry<Integer, Integer> connections : connections.entrySet()) {
				if (connections.equals(bee.getKey()) || connections.equals(bee.getValue())) {
				
					Training.training(bee.getKey());
				}
			}
		}
	}
}
