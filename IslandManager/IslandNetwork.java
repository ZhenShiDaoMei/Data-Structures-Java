package jasonv2.IslandManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import big.data.DataSource;
/**
 * This class represents the IslandNetwork object that contains a hashmap of cities
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class IslandNetwork {

	private HashMap<String, City> graph;
	/**
	 * This is the constructor of the IslandNetwork object
	 */
	public IslandNetwork() {
		graph = new HashMap<String, City>();
	}
	/**
	 * This method returns the graph hashmap
	 * 
	 * @return
	 * graph
	 */
	public HashMap<String, City> getGraph() {
		return graph;
	}
	/**
	 * This method modifies the graph hashmap
	 * 
	 * @param graph
	 * new graph hashmap
	 */
	public void setGraph(HashMap<String, City> graph) {
		this.graph = graph;
	}

	/**
	 * This method loads a IslandNetwork from a url
	 * 
	 * @param url
	 * url (String)
	 * @return
	 * new IslandNetwork
	 */
	public static IslandNetwork LoadFromFile(String url) throws Exception {
		DataSource ds = DataSource.connectXML("hw7.xml");
        ds.load();
        String cityNamesStr=ds.fetchString("cities");
        String[] cityNames=cityNamesStr.substring(1,cityNamesStr.length()-1).replace("\"","").split(",");
        String roadNamesStr=ds.fetchString("roads");
        String[] roadNames=roadNamesStr.substring(1,roadNamesStr.length()-1).split("\",\"");
        IslandNetwork temp = new IslandNetwork();
        
        for(int i = 0; i<cityNames.length; i++) {
        	City tempCity = new City();
        	tempCity.setName(cityNames[i]);
        	temp.getGraph().put(cityNames[i], tempCity);
        }
        
        for(int i = 0; i<roadNames.length; i++) {
        	System.out.print(roadNames[i]);
        	for(HashMap.Entry<String,City>entry : temp.getGraph().entrySet()) {
        		String key = entry.getKey();
        		City value = entry.getValue();
        		if(roadNames[i].substring(0,roadNames[i].indexOf(",")).equals(temp.getGraph().get(key).getName())) {
        			String name = roadNames[i].substring(roadNames[i].indexOf(",") + 1,roadNames[i].lastIndexOf(","));
        			int num = Integer.parseInt(roadNames[i].substring(roadNames[i].lastIndexOf(",") + 1));
        			temp.getGraph().get(key).addNeighbors(name, num);
        		}
        	}
        }
        return temp;
	}
	
	
	
	
	//can be string return type
	/**
	 * This method returns the max flow from one place to another
	 * @param from
	 * starting place
	 * @param to
	 * end place
	 */
	public void maxFlow(String from, String to) {
		
	}
	/**
	 * This method recursively calls the dfs method
	 * @param from
	 * starting city
	 * @return
	 * list of cities
	 */
	public List <String> dfs(String from){
		List<String> original = new ArrayList<String>();
		return dfs(from, original);
	}
	/**
	 * This method recursively calss the dfs method
	 * @param from
	 * starting city
	 * @param original
	 * list of cities
	 * @return
	 * list of cities
	 */
	public List <String> dfs(String from, List<String> original){
		graph.get(from).setVisited(true);
			for(HashMap.Entry<String, Integer> entry : graph.get(from).getNeighbors().entrySet()){
				String key = entry.getKey();
				Integer value = entry.getValue();
				if(graph.get(key).getDiscovered() == false) {
					 graph.get(key).setDiscovered(true);
					 original.add(key);
					 dfs(key, original);
				}
			}
			return original;
	}
	//in main method you have to ask user input
	/**
	 * This method adds to the graph hashmap
	 * 
	 * @param name
	 * name of city
	 * @param place
	 * city information
	 */
	public void addToGraph(String name, City place) {
		graph.put(name, place);
	}	
	/**
	 * this method prints out the return list from dfs method
	 * @param list
	 * list from dfs method
	 */
	public void print(List<String> list) {
		System.out.print("\n");
		for(String string : list) {
			System.out.print(string + ",");
		}
	}
}
