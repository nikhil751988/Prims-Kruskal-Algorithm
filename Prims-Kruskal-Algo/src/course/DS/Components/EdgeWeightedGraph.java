package course.DS.Components;

import java.util.ArrayList;
import java.util.List;

/*** 
 * @author NIKHIL BHARADWAJ RAMESHA
 * EdgeWeightedGraph class
 */

public class EdgeWeightedGraph {
	
	private List<Edge> graphEdges;
	private List<Vertex> graphVertices;
	private List<List<Edge>> adjacencyList;
	
	/***
	 * Constructor to initialize the class members
	 */
	
	public EdgeWeightedGraph()
	{
		graphEdges=new ArrayList<Edge>();
		graphVertices=new ArrayList<Vertex>();
		adjacencyList=new ArrayList<List<Edge>>();
	}
	
	/***
	 * Method used to build the vertices list
	 * @param v
	 */
	
	public void addVertices(int v)
	{
		Vertex vtx=new Vertex(v);
		this.graphVertices.add(vtx);
	}
	
	/***
	 * Method to build the Edge List
	 * @param v1
	 * @param v2
	 * @param weight
	 */
	
	public void createGraph(int v1, int v2, int weight)
	{
		Edge edge=new Edge(this.graphVertices.get(v1), this.graphVertices.get(v2), weight);
		this.graphEdges.add(edge);
	}
	
	/***
	 * Method returns the Edge List
	 * @return
	 */
	
	public List<Edge> getEdgeList()
	{
		return this.graphEdges;
	}
	
	/***
	 * Method returns the Vertex List
	 * @return
	 */
	
	public List<Vertex> getVertexList()
	{
		return this.graphVertices;
	}
	
	/***
	 * Method returns the Vertex list size
	 * @return
	 */
	
	public int returnVSize()
	{
		return this.graphVertices.size();
	}
	
	/***
	 * Method returns the Edge List size
	 * @return
	 */
	
	public int returnESize()
	{
		return this.graphEdges.size();
	}
	
	/***
	 * Method builds the adjacency list of the graph
	 */
	
	public void buildAdjacencyList()
	{
		for(Vertex v : graphVertices)
		{
			List<Edge> tempAdjVert = new ArrayList<Edge>();
			for(Edge e : graphEdges)
			{
				if(e.getSource().getVertexVal()==v.getVertexVal() || e.getDestination().getVertexVal()==v.getVertexVal())
				{
					tempAdjVert.add(e);
				}
			}
			adjacencyList.add(tempAdjVert);
		}
	}
	
	/***
	 * Method returns the adjacency list for a given Vertex
	 * @param v
	 * @return
	 */
	
	public List<Edge> getAdjacentNodes(int v)
	{
		return adjacencyList.get(v);
	}

}
