package parsemis.extension;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import de.parsemis.Miner;
import de.parsemis.graph.Graph;
import de.parsemis.miner.environment.Settings;
import de.parsemis.miner.general.Fragment;


public class SimpleMiner {
	
	public static <N,E> List<GraphPattern<N,E>> 
			mine(Collection<Graph<N,E>> graphs, int minFrequency){
		return mine(graphs, minFrequency, 1);
	}
	
	public static <N,E> List<GraphPattern<N,E>> 
			mine(Collection<Graph<N,E>> graphs, int minFrequency, int thread){
		/*
		 * This method uses Setting's parser here for lazy setup.
		 * The Setting's parser requires "parser" property which will be set automatically
		 * according to specified graphFile extension. Therefore, dummy graphFile is required
		 */
		List<String> options = new LinkedList<String>();
		options.add("--algorithm=gspan"); //We use gSpan only
		options.add("--graphFile=x.dot"); //Dummy filename (force the library to use DotParser)
		options.add("--swapFile=swap.txt");
		options.add("--minimumFrequency="+minFrequency);
		if(thread > 1){
			options.add("--distribution=threads");
			options.add("--threads="+thread);
		}else{
			options.add("--distribution=local");
			options.add("--threads=1");
		}
		@SuppressWarnings("unchecked")
		Settings<N,E> settings = Settings.parse(options.toArray(new String[options.size()]));
		final Collection<Fragment<N,E>> fragments = Miner.mine(graphs,
				settings);
		List<GraphPattern<N,E>> result = new LinkedList<GraphPattern<N,E>>();
		for(Fragment<N,E> frag : fragments){
			result.add(new GraphPattern<N,E>(frag));
		}
		return result;
	}
}
