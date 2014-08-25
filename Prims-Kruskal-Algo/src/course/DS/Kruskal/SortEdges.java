package course.DS.Kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import course.DS.Components.Edge;

/***
 * @author NIKHIL BHARADWAJ RAMESHA
 * SortEdges Class
 */


public class SortEdges {
	
	/***
	 * Custom Method to sort the edges in the List
	 * @param graphEdges
	 * @return
	 */
	
	public static List<Edge> sortEdges(List<Edge> graphEdges)
	{
		List<Edge> sorted_List = new ArrayList<Edge>(graphEdges);
		
		Collections.sort(sorted_List, new Comparator<Edge>(){
			
			public int compare(Edge e1, Edge e2)
			{
				return Integer.compare(e1.getWeight(), e2.getWeight());
			}
		});
		
		return sorted_List;
	}

}
