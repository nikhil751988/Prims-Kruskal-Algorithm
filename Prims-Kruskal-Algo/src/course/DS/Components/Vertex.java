package course.DS.Components;

/***
 * @author NIKHIL BHARADWAJ RAMESHA
 * Vertex Class
 */

public class Vertex {
	
	private int value;
	
	/***
	 * Constructor to initialize Vertex instance
	 * @param val
	 */
	
	public Vertex(int val)
	{
		this.value=val;
	}
	
	/***
	 * Method returns the value of the vertex
	 * @return
	 */
	
	public int getVertexVal()
	{
		return this.value;
	}

}
