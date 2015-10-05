package parsemis.extension;

import java.util.HashSet;
import java.util.Iterator;

import de.parsemis.graph.Graph;
import de.parsemis.miner.general.DataBaseGraph;
import de.parsemis.miner.general.Fragment;

public class GraphPattern<N,E> {

	private Graph<N,E> graph;
	private HashSet<Integer> graphIDs;
	
	public GraphPattern(Fragment<N,E> fragment){
		graph = fragment.toGraph();
		graphIDs = new HashSet<Integer>();
		final Iterator<DataBaseGraph<N, E>> graphIt = fragment.graphIterator();
		while(graphIt.hasNext()){
			graphIDs.add(Integer.parseInt(graphIt.next().toGraph().getName()));
		}
	}

	public Graph<N, E> getGraph() {
		return graph;
	}

	public HashSet<Integer> getGraphIDs() {
		return graphIDs;
	}
	
}
