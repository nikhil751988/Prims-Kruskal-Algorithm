package course.DS.Components;

/***
 * @author NIKHIL BHARADWAJ RAMESHA
 * Edge Class
 */

public class Edge {
	
	private Vertex source;
	private Vertex dest;
	private int weight;
	
	/***
	 * Constructor method to initialize edge instance  
	 * @param src
	 * @param dest
	 */
	
	public Edge(Vertex src, Vertex dest, int weight)
	{
		this.source=src;
		this.dest=dest;
		this.weight=weight;
	}
	
	/***
	 * Method returns the source vertex
	 * @return
	 */
	
	public Vertex getSource()
	{
		return this.source;
	}
	
	/***
	 * Method returns the destination vertex
	 * @return
	 */
	
	public Vertex getDestination()
	{
		return this.dest;
	}
	
	/***
	 * Method returns the weight of the edge
	 * @return
	 */
	
	public int getWeight()
	{
		return this.weight;
	}

}
