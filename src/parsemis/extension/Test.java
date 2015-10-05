package parsemis.extension;



public class Test {

	/*
	public static void main(String[] args){
		//final String[] param = new String[]{"--graphFile=graph.dot","--minimumFrequency=4","--outputFile=out2.txt"};
		final String[] param = new String[]{"--graphFile=digraph.dot","--minimumFrequency=2","--outputFile=out_di.txt"};
		try {
			Miner.run(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("====== END =====");
	}
	*/
	
	/*
	public static void main(String[] args){
		@SuppressWarnings("unchecked")
		Settings<String,String> settings = Settings.parse(new String[]{"--graphFile=digraph.dot","--minimumFrequency=1"});
		InputStream in = null;
		try {
			in = new FileInputStream(settings.inputFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Collection<Graph<String, String>> ret = settings.parser.parse(in, settings.factory);
			ret = SimpleMiner.mine(ret, 2);
			System.out.println("====== END =====");
			System.out.println(ret.size());
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
	}
	*/
}
