package v;

/**
 * Using Cubic logic, assign a proximity based on a radius
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 * @reference School, Oracle Java API and Lewis & Loftus
 *
 */
public class Touch {

	/**
     * return the spherical volume of touch zone for each Neuron
     * @return
     */
	private static double r = (Math.pow(NeuralNet.getV_qty(), 3)) / 9;

	/**
	 * Returns the radius
	 * @return
	 */
	public static double getR() {
		return r;
	}
	
	/**
	 * Sets the radius
	 * @param r
	 */
	public static void setR(double r) {
		Touch.r = r;
	}
	
	/**
	 * Creates the volume according to the proximity
	 * called from within.
	 * @return
	 */
    public static Object t() {return Radial_volume.a((float) Touch.getR());}
}
