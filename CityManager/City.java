package jasonv2.CityManager;
import java.util.HashMap;
/**
 * This class represents the City object with neighbors, name, whether it has been discovered or visited and tempNeighbors
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class City implements Comparable<City>{

	private HashMap<String,Integer> neighbors;
	private String name;
	private Boolean discovered;
	private Boolean visited;
	@SuppressWarnings("unused")
	private HashMap<String,Integer> tempNeighbors;
	/**
	 * This is the constructor of the city object
	 */
	public City() {
		neighbors = new HashMap<String,Integer>();
		name = "";
		discovered = false;
		visited = false;
		tempNeighbors = new HashMap<String,Integer>();
	}
	/**
	 * this method compares 2 cities
	 */
	public int compareTo(City o) {
		return name.compareTo(o.getName());
	}
	/**
	 * This method returns the neighbors of the city object
	 * @return
	 * neighbors
	 */
	public HashMap<String,Integer> getNeighbors() {
		return neighbors;
	}
	/**
	 * This method returns the name of the city object
	 * @return
	 * name
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method returns the boolean discovered
	 * @return
	 * discovered
	 */
	public Boolean getDiscovered() {
		return discovered;
	}
	/**
	 * This method returns the boolean visited
	 * @return
	 * visited
	 */
	public Boolean getVisited() {
		return visited;
	}
	/**
	 * This method modifies the neighbors hashmap within the city object
	 * @param newNeighbors
	 * new neighbors
	 */
	public void setNeighbors(HashMap<String,Integer> newNeighbors) {
		this.neighbors = newNeighbors;
	}
	/**
	 * This method adds a neighbor to the neighbors hashmap
	 * @param name
	 * name of neighbor
	 * @param num
	 * max capacity of neighbor
	 */
	public void addNeighbors(String name, int num) {
		neighbors.put(name, num);
	}
	/**
	 * This method modifies the name of the city
	 * @param newName
	 * new name
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	/**
	 * This method modifies the boolean discovered of the city
	 * @param trueOrFalse
	 * new boolean value for discovered
	 */
	public void setDiscovered(Boolean trueOrFalse) {
		this.discovered = trueOrFalse;
	}
	/**
	 * This method modifies the boolean visited of the city
	 * @param trueOrFalse
	 * new boolean value for visited
	 */
	public void setVisited(Boolean trueOrFalse) {
		this.visited = trueOrFalse;
	}
}
