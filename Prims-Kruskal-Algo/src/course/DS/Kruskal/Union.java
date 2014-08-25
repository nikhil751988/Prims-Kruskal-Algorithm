package course.DS.Kruskal;

import course.DS.Components.Vertex;

/***
 * @author NIKHIL BHARADWAJ RAMESHA
 * Union Class
 */

public class Union {
	
	private int [] id;
	private int [] rank;
	private int count;
	
	/***
	 * Constructor used to initialize the Class members
	 * @param size
	 */
	
	public Union(int size)
	{
		if(size<0)
			throw new IllegalArgumentException();
		count=size;
		id = new int[size];
		rank = new int[size];
		
		for(int index=0;index<size;index++)
		{
			id[index]=index;
			rank[index]=0;
		}
	}
	
	/***
	 * Method returns the count
	 * @return
	 */
	
	public int returnCount()
	{
		return this.count;
	}
	
	/***
	 * Method used to check for cycles
	 * @param srcV
	 * @param destV
	 * @return
	 */
	
	public boolean isConnected(Vertex srcV, Vertex destV)
	{
		return find(srcV)==find(destV);
	}
	
	/***
	 * Method to perform Union operation on Vertices
	 * @param srcV
	 * @param destV
	 */
	
	public void performUnionSet(Vertex srcV, Vertex destV)
	{
		int v1=find(srcV);
		int v2=find(destV);
		
		if(v1==v2)
			return;
		
		if(rank[v1] < rank[v2])
			id[v1]=v2;
		
		else if(rank[v1] > rank[v2])
			id[v2]=v1;
		
		else{
			id[v2]=v1;
			rank[v1]++;
		}
		
		count--;
	}
	
	/***
	 * Method used find the Cluster Head
	 * @param v
	 * @return
	 */
	
	public int find(Vertex v)
	{
		int vert=v.getVertexVal();
		
		if(vert<0 || vert >=this.id.length)
			throw new IndexOutOfBoundsException();
		
		while(vert!=id[vert])
		{
			id[vert]=id[id[vert]];
			vert=id[vert];
		}
		
		return vert;
	}

}
