package jasonv2.NintendoNetworkSimulator;
/**
 * This class represents a NetworkNode that contains a String name, 2 booleans isNintendo & isBroken, NetworkNode parent, NetworkNode array children and int max children and count.
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class NetworkNode {

	private String name;
	private boolean isNintendo;
	private boolean isBroken;
	private NetworkNode parent;
	private NetworkNode[] children;
	final int maxChildren = 9;
	private int count = 0;
	/**
	 * This is the constructor of the NetworkNode object
	 * This constructor activates all the private variables within the class
	 */
	public NetworkNode() {
		name = "";
		isNintendo = false;
		isBroken = false;
		parent = null;
		children = new NetworkNode[maxChildren];
	}
	/**
	 * This is another constructor of the NetworkNode object
	 * This constructor takes in parameters and makes a NetworkNode with the given information
	 * 
	 * @param name
	 * name of the Node
	 * @param isNintendo
	 * whether true or false
	 * @param isBroken
	 * whether true or false
	 */
	public NetworkNode(String name, boolean isNintendo, boolean isBroken) {
		this.name = name;
		this.isNintendo = isNintendo;
		this.isBroken = isBroken;
		parent = null;
		children = new NetworkNode[maxChildren];
	}
	/**
	 * This method modifies the name of the Node
	 * @param name
	 * new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method modifies the parent of the Node
	 * @param parent
	 * new parent
	 */
	public void setParent(NetworkNode parent) {
		this.parent = parent;
	}
	/**
	 * This method modifies the isNintendo of the Node
	 * @param nin
	 * change the boolean from true to false or vice versa
	 */
	public void setNintendo(boolean nin) {
		isNintendo = nin;
	}
	/**
	 * This method modifies the isBroken of the Node
	 * @param broke
	 * change the boolean from true to false or vice versa
	 */
	public void setBroken(boolean broke) {
		isBroken = broke;
	}
	/**
	 * This method modifies the children of the Node
	 * @param children
	 * new Array of NetworkNodes
	 */
	public void setChildren(NetworkNode[] children) {
		this.children = children;
	}
	/**
	 * This method modifies the count for the Node
	 * @param newcount
	 * new count
	 */
	public void setCount(int newcount) {
		count = newcount;
	}
    /**
     * This method returns the count of the Node
     * @return
     * count
     */
	public int getCount() {
		return count;
	}
	/**
	 * This method returns the name of the Node
	 * @return
	 * name
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method returns the isNintendo of the Node
	 * @return
	 * isNintendo
	 */
	public boolean getNintendo() {
		return isNintendo;
	}
	/**
	 * This method returns the isBroken of the Node
	 * @return
	 * isBroken
	 */
	public boolean getBroken() {
		return isBroken;
	}
	/**
	 * This method returns the parent of the Node
	 * @return
	 * parent
	 */
	public NetworkNode getParent() {
		return parent;
	}
	/**
	 * This method returns the children of the Node
	 * @return
	 * children (array of NetworkNodes)
	 */
	public NetworkNode[] getChildren() {
		return children;
	}
	/**
	 * This method returns a singular NetworkNode at the given index
	 * @param index
	 * index within the array
	 * @return
	 * NetworkNode that is a child of the current NetworkNode
	 */
	public NetworkNode getSingleChild(int index) {
		return children[index-1];
	}
	
	
	
	
	
	
	
	
	
	
	

	//come back later and finish
	public void removeChild (NetworkNode child) {
		
	}
}
