package v;

/**
 * Calculate the surface area of a sphere
 * 
 * 
 * @author xer0n3 - developing821@outlook.com - R.Clarke
 * @reference https://www.bing.com/search?q=how+to+get+the+surface+area+of+a+sphere&cvid=5f179f0278be437e9ff2175dde0131a2&aqs=edge..69i57.7051j0j7&FORM=ANNTA1&PC=U531 - 27/01/2023
 */

public class SurfaceSphere {

	/**
	 * Calculates the surface area of a sphere
	 * based on a given radius.
	 * 
	 * @param r
	 * @return
	 */
	public static double surface (double r) {
		return 4 * Math.PI * Math.pow(r, 2);
	}
}
