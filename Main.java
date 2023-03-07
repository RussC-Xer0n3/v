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
		int main_out = NeuralNet.getThresholder();
		System.err.println(main_out);
		
		//Set the hive here and the connections ready for processing into training
		hive = NeuralNet.getBeehive();
		connections = NeuralNet.getConnections();
		
		//Initialise the Training
		System.err.println("Initialising training module...");
		for (Entry<Integer, ArrayList<Object>> bee : hive.entrySet()) {
			for (Entry<Integer, Integer> connections : connections.entrySet()) {
				
					bee.getValue().set(0, Training.training(bee.getKey().intValue()));
			}
		}
		
		System.out.println(NeuralNet.getSum());
		//Volume2.setInput((byte)main_out);
	}
}
