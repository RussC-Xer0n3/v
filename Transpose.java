package v;

/**
 * Perform a transposition of a Matrix and return
 * the transposition.
 * 
 * @reference https://www.scaler.com/topics/Transpose-of-a-matrix-in-java/ - Tarun Luthra - 2022
 */

public class Transpose {

	/**
	 * Perform a transposition of a Matrix and return
	 * the transposition.
	 * @param M
	 * @return
	 */
	public static double[][] transpose(double[][] M) {
		System.err.println("Performing Transposition...");
		
		// find number of rows and columns in matrix M
	    int n = M.length, m = M[0].length;
	    
	    // create empty transpose matrix of size m*n
	    double M_transpose[][] = new double[m][n];

	    // traverse matrix M
	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < m; j++) {
	        //assign M_transpose[j][i] as M[i][j]
	        M_transpose[j][i] = M[i][j];
	      }
	    }
	    
		return M_transpose;
	}
}
