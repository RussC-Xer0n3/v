package v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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
	private static double[] hiddenLayerOutputs;
	private static double[] outputLayerWeights;
	private static double[] outputLayerOutputs;
	private static ArrayList<Double> hiddenWeights = new ArrayList<>();;
	private static ArrayList<Double> hiddenOut = new ArrayList<>();
	private static double[][] in = {};
	private static double[] out = {};
	private static HashMap<Integer, Integer> connections;
	private static HashMap<Integer, ArrayList<Object>> beehive;
	private static ArrayList<Object> neuron;
	private static double adjusted;
	private static double[] outputs;
	private static double learningrate = 1e-4;
	private static double ouputNeuronError;
	private static double hiddenNeuronError;
	


	/**
	 * The main entry point for our program
	 * 
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	public static void net() throws IOException {
		//Example initialisation - consider //TODO: byte data type		
		outputs = new double[in.length-1];
		
		for (int outs = 0; outs < 4; outs++) {
			outputs[outs] = 0;
		}
		
		//Start our output layer with zeroes
		NeuralNet.setOutputs(outputs);
		
		//set the desired output
		System.err.println("Setting the desired output..." + "\n");
		NeuralNet.setDesiredOutput(out);

		//set the inputs
		System.err.println("Setting the inputs..." + "\n");
		NeuralNet.setInputs(in);
		
		//Generate out output layer outputs as 0 to start with...
		System.err.println("Setting the outputLayer outputs to 0" + "\n");
		NeuralNet.setOutputLayerOutputs(NeuralNet.getOutputs());
		
		//Set our outputLayer Weights
		OutputLayer.outputLayerInitialWeights();
		
		System.err.println("Printing initial output" + "\n");
		for (int h = 0; h < outputs.length; h++) {
			System.err.print(Threshold.threshold(outputLayerWeights[h]));
		}

		System.err.println("\n");
		
		//Add our output layer weights to an ArrayList
		for (int o = 0;  o < outputLayerWeights.length; o++) {
			
			hiddenOut.add(outputLayerWeights[o]);
			
		}
		
		System.err.println("Output Layer ArrayList::" + hiddenOut + "\n");
		
		//Set our outputLayer initial values
		OutputLayer.output();
		
		//Generate the weights per Neuron and set them
		NeuralNet.setHiddenLayerWeights(GenerateWeights.weights(NeuralNet.getN_qty()));
		System.err.println("Generated hidden layer Weights..." + "\n");
		
		//Generate our BeeHive
		System.err.println("Generating HashMap of Neurons..." + "\n");
		HiveNest.mapping(NeuralNet.getNeuron(), n_qty, v_qty);
		
		//Set our hidden Layer Weights to a value other than 0.0 as initialisers
		HiddenLayerWeights.hidden();
		
		//Activate the connection Module after generating our connections
		Activation.activate();
		
		//Assign our weights from our connections to an ArrayList
		for (Entry<Integer, ArrayList<Object>> bee : beehive.entrySet() ) {
				
			if (connections.containsKey(bee.getKey().intValue())) {
				
				hiddenWeights.add((double) bee.getValue().get(7));
				
			} else if (connections.containsValue(bee.getKey().intValue())) {
				
				hiddenWeights.add((double) bee.getValue().get(7));
				
			}
		}
		
		System.err.println("Hidden Connected Weights::" + hiddenWeights + "\n");
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
	
	public static ArrayList<Double> getHiddenWeights() {
		return hiddenWeights;
	}
	
	public static void setHiddenWeights(ArrayList<Double> hiddenWeights) {
		NeuralNet.hiddenWeights = hiddenWeights;
	}
	
	public static ArrayList<Double> getHiddenOut() {
		return hiddenOut;
	}
	
	public static void setHiddenOut(ArrayList<Double> hiddenOut) {
		NeuralNet.hiddenOut = hiddenOut;
	}
	
	public static double[][] getIn() {
		return in;
	}
	
	public static void setIn(double[][] in) {
		NeuralNet.in = in;
	}
	
	public static double[] getOut() {
		return out;
	}
	
	public static void setOut(double[] out) {
		NeuralNet.out = out;
	}
	
	public static double getOuputNeuronError() {
		return ouputNeuronError;
	}
	
	public static void setOuputNeuronError(double ouputNeuronError) {
		NeuralNet.ouputNeuronError = ouputNeuronError;
	}
	
	public static double getHiddenNeuronError() {
		return hiddenNeuronError;
	}
	
	public static void setHiddenNeuronError(double hiddenNeuronError) {
		NeuralNet.hiddenNeuronError = hiddenNeuronError;
	}
}
