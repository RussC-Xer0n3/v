package v;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Our Neuron with our Radii, Empty Class ready for training module
 * It houses it's HashMap volume x,z,y coordinates and weights later on
 *  
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 */

public class Neuron {

	/**
     * Thinking if we input the connections to think() as well as the
     * synaptic weights from the sigmoids, we will have inputs as outputs
     * and vise versa, since we need the synapses to receive the output of
     * each neuron to make use of as an input because we are working on a 
     * multi-neuron system which are all interconnected according to proximity
     * 
     * Though there will be dormant neurons if too large a volume (it's fine)
     * We still need all the neurons to talk according to their connectivity. 
	 * @throws IOException 
     */
	
	/**
	 * Empty class to temporarily store in our Neuron
	 * whilst the Neuron is created and allocated in the
	 * HashMap volume
	 * 
	 * @return 0 
	 */
	public static double a() {
		return 0;
	}
	/**
	 * Neuron Index.
	 *
	 * 0 - Training.
	 * 1 - Touch Area one 9th of the volume.
	 * 2 - Green Area one Quarter of the volume,
	 * 3 - Red Area one Third of the volume.
	 * 4 - Touch volume surface Area.
	 * 5 - Green volume surface Area.
	 * 6 - Red volume surface Area.
	 * 7 - Weights.
	 * 8 - x.
	 * 9 - z.
	 * 10 - y.
	 * 
	 * @return neuron ArrayList Object
	 * @throws IOException
	 */
    public static ArrayList<Object> neuron () throws IOException {
        ArrayList<Object> neuron = new ArrayList<>();
        
        neuron.add(a()); //Training module or sigmoid etc etc, initially empty method, new class method added in HiveNest mapping.
        
        neuron.add(Touch.t()); //Mating zone, the quintessential zone of mating, energy transfer, bioelectrical transfer, atomic emf/emp bonds
        
        neuron.add(Green.g()); //emf
        
        neuron.add(Red.r()); //red zone, widest radii 
        
        neuron.add(SurfaceSphere.surface(Touch.getR())); // touch volume surface area
        
        neuron.add(SurfaceSphere.surface(Green.getR())); // green surface area
        
        neuron.add(SurfaceSphere.surface(Red.getR())); // red surface area
        
        neuron.add(0); // I/O weights
        
        neuron.add(0); // x
        
        neuron.add(0); // z
         
        neuron.add(0); // y

        return neuron;
    }
}