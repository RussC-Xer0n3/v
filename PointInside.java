package v;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * @author xer0n3 - developing821@outlook.com - R. Clarke
 * @reference https://developer.mozilla.org/en-US/docs/Games/Techniques/3D_collision_detection#:~:text=Using%20bounding%20spheres%20to%20detect%20collisions%20is%20a,the%20bounding%20sphere%20would%20still%20be%20the%20same. - Accessed 19/01/20232023
 */

/**
 * Special thanks to - 
 * 
 * @reference https://www.gamedeveloper.com/programming/pool-hall-lessons-fast-accurate-collision-detection-between-circles-or-spheres
 * 
 * @reference https://gamedev.stackexchange.com/questions/16976/sphere-collision-response
 * 
 * Accessed:: 17/01/2023
 */

public class PointInside {

	static HashMap<Integer, ArrayList<Object>> hive = NeuralNet.getBeehive();

	public static int[] is(int key) {
		
		int[] connected = new int[(int) Math.pow(NeuralNet.getV_qty(), 3)];
		
		int bkey = key;
		
		//get our keys (key b) coordinate values
		int bees_x = GetX.getx(bkey);
		int bees_z = GetZ.getz(bkey);
		int bees_y = GetY.gety(bkey);
				
		for (Entry<Integer, ArrayList<Object>> bee: hive.entrySet()) {
			//Sphere location
			int x = (int) bee.getValue().get(8);
			int z = (int) bee.getValue().get(9);
			int y = (int) bee.getValue().get(10);
		
			double distance = Math.sqrt((bees_x - x) * (bees_x - x) + (bees_z - z) * (bees_z - z) + (bees_y - y) * (bees_y - y));
			
			for (int i : connected) {
			
				if (distance < Red.getR()) {
					connected[i] = bee.getKey();
				}
				
				if (distance == Green.getR()){
					connected[i] = bee.getKey();
				} 
				
				if (distance < Touch.getR()) {
					connected[i] = bee.getKey();
				} else {
					break;
				}
			}
		}
		
		return connected;
	}
}
