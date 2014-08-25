package course.DS.Prims;

import java.util.LinkedList;
import java.util.List;
import course.DS.Components.Edge;
import course.DS.Components.EdgeWeightedGraph;

/***
 * @author NIKHIL BHARADWAJ RAMESHA
 * PrimsAlgo Class
 */


public class PrimsAlgo {
	
	private boolean [] markedVert;
	private Edge [] shortDistVert;
	private int [] distToVert;
	private MinQueue mQ;
	
	/***
	 * COnstructor to initialize the Class Members
	 * @param ewG
	 */
	
	public PrimsAlgo(EdgeWeightedGraph ewG)
	{
		int size=ewG.returnVSize();
		shortDistVert=new Edge[size];
		distToVert=new int[size];
		markedVert=new boolean[size];
		mQ=new MinQueue();
		mQ.initializeQueue(ewG);
				
		for(int i=0;i<size;i++)
		{
			distToVert[i]=Integer.MAX_VALUE;
		}
		
		//Calls Prim's algorithm run Method
		
		for(int v=0;v<ewG.returnVSize();v++)
		{
			if(!markedVert[v])
			{
				runPrims(ewG, v);
			}
			
		}
	}
	
	/***
	 * Method which runs Prim's Algorithm
	 * @param ewG
	 * @param v
	 */
	
	public void runPrims(EdgeWeightedGraph ewG, int v)
	{
		distToVert[v]=0;
		mQ.minEdges.add(new NodeDistance(v, distToVert[v]));
		while(!mQ.minEdges.isEmpty())
		{
			NodeDistance nd=mQ.minEdges.remove();
			scanEdges(ewG, nd.getVertex());
		}
	}
	
	/***
	 * Method to scan and obtain adjacent edges
	 * @param ewG
	 * @param v
	 */
	
	public void scanEdges(EdgeWeightedGraph ewG, int v)
	{
		markedVert[v]=true;
		
		for(Edge e : ewG.getAdjacentNodes(v))
		{
			int w=-1;
			
			if(e.getSource().getVertexVal()==v)
				w=e.getDestination().getVertexVal();
			else
				w=e.getSource().getVertexVal();
			
			if(markedVert[w])
				continue;
			
			if(e.getWeight() < distToVert[w])
			{
				distToVert[w]=e.getWeight();
				shortDistVert[w] = e;
				if(mQ.containsElement(w))
					mQ.decreaseDistance(distToVert[w], w);
				else
					mQ.minEdges.add(new NodeDistance(w, distToVert[w]));
			}
		}
	}
	
	/***
	 * Method to build Spanning Tree
	 * @return
	 */
	
	public List<Edge> addToPrimsSpanningTree()
	{
		List<Edge> primsSpanningTree = new LinkedList<Edge>();
		for(int v=0;v<shortDistVert.length;v++)
		{
			Edge e = shortDistVert[v];
			if(e!=null)
				primsSpanningTree.add(e);
		}
		
		return primsSpanningTree;
	}
	
	/***
	 * Method to obtain the minimum weight of the Spanning Tree
	 * @return
	 */
	
	public int getMinimumWeight()
	{
		int minimumWeight = 0;
		
		for(Edge e : addToPrimsSpanningTree())
		{
			minimumWeight+=e.getWeight();
		}
		
		return minimumWeight;
	}

}
