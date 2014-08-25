package course.DS.Prims;

/***
 * @author NIKHIL BHARADWAJ RAMESHA
 * NodeDistance Class
 */

public class NodeDistance {
	
	int vert;
	int distance;
	
	/***
	 * Constructor to initialize the distance
	 * @param v
	 * @param dist
	 */
	
	public NodeDistance(int v, int dist)
	{
		this.vert=v;
		this.distance=dist;
	}
	
	/***
	 * Returns the Distance
	 * @return
	 */
	
	public int getDistance()
	{
		return this.distance;
	}
	
	/***
	 * Returns the Vertex
	 * @return
	 */

	public int getVertex()
	{
		return this.vert;
	}
}
