package v;

/**
 * Perform a modulus of the derivative of the volume 
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 *
 */
public class GetY {

	/**
	 * Perform a modulus of the derivative of the volume
	 * to get Y value
	 * 
	 * @param key
	 * @return
	 */
	public static int gety(int key) {
		return key % (NeuralNet.getV_qty() * NeuralNet.getV_qty() * NeuralNet.getV_qty());
	}
	
}
