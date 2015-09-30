package parsemis.extension;

import java.util.Collection;
import java.util.LinkedList;

import de.parsemis.Miner;
import de.parsemis.graph.Graph;
import de.parsemis.miner.environment.Settings;
import de.parsemis.miner.general.Fragment;


public class SimpleMiner {
	
	public static <N,E> Collection<Graph<N,E>> 
			mine(Collection<Graph<N,E>> graphs, int minFrequency){
		/*
		 * This method uses Setting's parser here for lazy setup.
		 * The Setting's parser requires "parser" property which will be set automatically
		 * according to specified graphFile extension. Therefore, dummy graphFile is required
		 */
		@SuppressWarnings("unchecked")
		Settings<N,E> settings = Settings.parse(new String[]{"--minimumFrequency="+minFrequency,
				"--graphFile=x.dot"});
		
		final Collection<Fragment<N,E>> fragments = Miner.mine(graphs,
				settings);
		final LinkedList<Graph<N,E>> result = new LinkedList<Graph<N,E>>();
		for(Fragment<N,E> frag : fragments){
			result.add(frag.toGraph());
		}
		return result;
	}
}
