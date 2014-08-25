package course.DS.Kruskal;

import java.util.ArrayList;
import java.util.List;
import course.DS.Components.Edge;
import course.DS.Components.EdgeWeightedGraph;
import course.DS.Components.Vertex;

/***
 * @author NIKHIL BHARADWAJ RAMESHA
 * KruskalAlgo Class
 */


public class KruskalAlgo {
	
	private List<Edge> minEdgesList;
	private int number_Of_Vertices;
	private List<Edge> spanningTree;
	private int spanningTreeWeight;
	
	/***
	 * Constructor used to initialize the Class members
	 * @param ewGraph
	 */
	
	public KruskalAlgo(EdgeWeightedGraph ewGraph)
	{
		minEdgesList=new ArrayList<Edge>(SortEdges.sortEdges(ewGraph.getEdgeList()));
		number_Of_Vertices=ewGraph.returnVSize();
		spanningTree=new ArrayList<Edge>();
		spanningTreeWeight=0;
	}
	
	/***
	 * Method which runs the Kruskal's Algorithm
	 */
	
	public void runKruskal()
	{
		Union unI = new Union(this.number_Of_Vertices);
		while(minEdgesList.size()!=0)
		{
			Edge edge=minEdgesList.remove(0);
			Vertex srcV=edge.getSource();
			Vertex destV=edge.getDestination();
			
			if(!unI.isConnected(srcV, destV))
			{
				unI.performUnionSet(srcV, destV);
				spanningTree.add(edge);
				spanningTreeWeight+=edge.getWeight();
			}
					
		}
	}
	
	/***
	 * Method returns the minimum Spanning Tree weight
	 * @return
	 */
	
	public int getSpanningTreeWeight()
	{
		return this.spanningTreeWeight;
	}
	
	/***
	 * Method returns the spanning tree
	 * @return
	 */
	
	public List<Edge> getSpanningTree()
	{
		return this.spanningTree;
	}

}
