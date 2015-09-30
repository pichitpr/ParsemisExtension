package parsemis.extension;

import de.parsemis.graph.Edge;
import de.parsemis.graph.Graph;
import de.parsemis.graph.GraphFactory;
import de.parsemis.graph.HPListGraph;
import de.parsemis.graph.HPMutableGraph;

public class GraphCreationHelper<N,E> {
	
	private GraphFactory<N,E> factory = new HPListGraph.Factory<N,E>(null,null);
	
	private HPMutableGraph<N,E> currentGraph;
	
	public void createNewGraph(String gName){
		currentGraph = (HPMutableGraph<N,E>)factory.newGraph(gName).toHPGraph();
	}
	
	/**
	 * Add new node with label to current graph. Node index is returned.
	 * Node index used to refer to a node.
	 */
	public int addNode(N label){
		return currentGraph.addNodeIndex(label);
	}
	
	/**
	 * Create a labeled edge links between 2 nodes
	 */
	public void addEdge(int start, int end, E label, boolean isDirected){
		currentGraph.addEdgeIndex(start, end, label, isDirected ? 
				Edge.OUTGOING : Edge.UNDIRECTED);
	}

	public Graph<N,E> finishGraph(){
		return currentGraph.toGraph();
	}
}
