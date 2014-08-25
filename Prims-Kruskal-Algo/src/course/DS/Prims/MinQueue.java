package course.DS.Prims;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import course.DS.Components.EdgeWeightedGraph;


/*** 
 * @author NIKHIL BHARADWAJ RAMESHA
 * MinQueue Class
 */

public class MinQueue{
	
	/***
	 * Overridden comparator of the Priority Queue
	 */
	
	public Comparator<NodeDistance> edgeComparator = new Comparator<NodeDistance>()
	{
		@Override
		public int compare(NodeDistance a, NodeDistance b)
		{
			return (int)(a.getDistance() - b.getDistance());
		}
	};
	
	
	public Queue<NodeDistance> minEdges;
	
	/***
	 * Initialize the Priority Queue
	 * @param ewG
	 */
	
	public void initializeQueue(EdgeWeightedGraph ewG)
	{
		minEdges=new PriorityQueue<NodeDistance>(ewG.returnVSize(), edgeComparator);
	}
	
	/***
	 * Method to check for element present in the Queue
	 * @param w
	 * @return
	 */
	
	public boolean containsElement(int w)
	{
		boolean present=false;
		for(NodeDistance nd : minEdges)
		{
			if(nd.getVertex()==w)
			{
				present=true;
				break;
			}
		}
		return present;
	}
	
	/***
	 * Method to decrease the Distance Value
	 * @param value
	 * @param w
	 */
	
	public void decreaseDistance(int value, int w)
	{
		for(NodeDistance nd : minEdges)
		{
			if(nd.getVertex()==w)
			{
				minEdges.remove(nd);
				break;
			}
		}
		minEdges.add(new NodeDistance(w, value));
	}
}
