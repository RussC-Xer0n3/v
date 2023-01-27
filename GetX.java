package v;

/**
 * Perform a modulus of the derivative of the volume 
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 *
 */
public class GetX {

	/**
	 * Perform a modulus of the derivative of the volume
	 * to get X value
	 * 
	 * @param key
	 * @return
	 */
	public static int getx(int key) {
		return key % NeuralNet.getV_qty();
	}
	
}
