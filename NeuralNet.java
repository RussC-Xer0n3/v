package v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Begin the build and activation of our Radial Basis Neural Network
 * 
 * @Interface initial starting point when running the program
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 *
 */
public class NeuralNet {

	private static int t_qty, n_qty, v_qty = 0;
	private static double[][] inputs;
	private static double[] desiredOutput;
	private static double[] hiddenLayerWeights;
	public static double[] hiddenLayerOutputs;
	private static double[] outputLayerWeights;
	private static double[] outputLayerOutputs;

	private static HashMap<Integer, Integer> connections = null;
	private static HashMap<Integer, ArrayList<Object>> beehive;
	private static ArrayList<Object> neuron;
	private static double adjusted;
	private static double[] outputs;
	private static double learningrate = 1e-4;
	

	/**
	 * The main entry point for our program
	 * 
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		//Example initialisation - consider //TODO: byte data type
		
		NeuralNet.setN_qty(33);
		NeuralNet.setT_qty(10000);
		NeuralNet.setV_qty(4);
		
		double[][] in = {{1000}, {0111}, {0101}, {1001}, {0110}};
		double[] out = {0111};
		double[] outputs = new double[4];
		
		for (int outs = 0; outs < 4; outs++) {
			outputs[outs] = 0;
		}
		
		NeuralNet.setOutputs(outputs);
		
		//set the desired output
		System.err.println("Setting the desired output" + out);
		NeuralNet.setDesiredOutput(out);

		//set the inputs
		System.err.println("Setting the inputs: " + in);
		NeuralNet.setInputs(in);
		
		//Generate out output layer outputs as 0 to start with...
		System.err.println("Setting the outputLayer outputs to 0");
		NeuralNet.setOutputLayerOutputs(NeuralNet.getOutputs());
		
		//Set our outputLayer Weights
		NeuralNet.setOutputLayerWeights(OutputLayer.getOutputLayerWeights());
		
		//Generate the weights per Neuron and set them
		NeuralNet.setHiddenLayerWeights(GenerateWeights.weights(NeuralNet.getN_qty()));
		System.err.println("Generated hidden layer Weights...");
		
		//Generate our BeeHive
		System.err.println("Generating HashMap of Neurons...");
		HiveNest.mapping(NeuralNet.getNeuron(), n_qty, v_qty);

		//Activate the training Module
		Activation.activate();
		
	}

	public static int getV_qty() {
		return v_qty;
	}

	public static void setV_qty(int v_qty) {
		NeuralNet.v_qty = v_qty;
	}

	public static int getN_qty() {
		return n_qty;
	}

	public static void setN_qty(int n_qty) {
		NeuralNet.n_qty = n_qty;
	}

	public static int getT_qty() {
		return t_qty;
	}

	public static void setT_qty(int t_qty) {
		NeuralNet.t_qty = t_qty;
	}
	
	public static double[][] getInputs() {
		return inputs;
	}

	public static void setInputs(double[][] in) {
		NeuralNet.inputs = in;
	}
	
	public static double[] getDesiredOutput() {
		return desiredOutput;
	}
	
	public static void setDesiredOutput(double[] desiredOutput) {
		NeuralNet.desiredOutput = desiredOutput;
	}
	
	public static double[] getHiddenLayerWeights() {
		return hiddenLayerWeights;
	}
	
	public static void setHiddenLayerWeights(double[] hiddenLayerWeights) {
		NeuralNet.hiddenLayerWeights = hiddenLayerWeights;
	}
	
	public static HashMap<Integer, Integer> getConnections() {
		return connections;
	}


	public static void setConnections(HashMap<Integer, Integer> connections2) {
		NeuralNet.connections = connections2;
	}
	
	public static HashMap<Integer, ArrayList<Object>> getBeehive() {
		return beehive;
	}
	
	public static void setBeehive(HashMap<Integer, ArrayList<Object>> beehive) {
		NeuralNet.beehive = beehive;
	}

	public static ArrayList<Object> getNeuron() {
		return neuron;
	}
	
	public static void setNeuron(ArrayList<Object> neuron) {
		NeuralNet.neuron = neuron;
	}
	
	public static double getAdjusted() {
		return adjusted;
	}
	
	public static void setAdjusted(double weight) {
		NeuralNet.adjusted = weight;
	}

	public static double[] getOutputLayerWeights() {
		return outputLayerWeights;
	}

	public static void setOutputLayerWeights(double[] outputLayerWeights) {
		NeuralNet.outputLayerWeights = outputLayerWeights;
	}
	
	public static double[] getOutputLayerOutputs() {
		return outputLayerOutputs;
	}
	
	public static void setOutputLayerOutputs(double[] outputLayerOutputs) {
		NeuralNet.outputLayerOutputs = outputLayerOutputs;
	}

	public static double[] getOutputs() {
		return outputs;
	}

	public static void setOutputs(double[] outputs) {
		NeuralNet.outputs = outputs;
	}
	
	public static double[] getHiddenLayerOutputs() {
		return hiddenLayerOutputs;
	}
	
	public static void setHiddenLayerOutputs(double[] hiddenLayerOutputs) {
		NeuralNet.hiddenLayerOutputs = hiddenLayerOutputs;
	}
	
	public static double getLearningrate() {
		return learningrate;
	}
	
	public static void setLearningrate(double learningrate) {
		NeuralNet.learningrate = learningrate;
	}
}
