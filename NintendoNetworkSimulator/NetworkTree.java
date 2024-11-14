package jasonv2.NintendoNetworkSimulator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * This class represents a NetworkTree with 2 NetworkNodes: root and cursor.
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class NetworkTree {

	private NetworkNode root;
	private NetworkNode cursor;
	/**
	 * This is the constructor of the NetworkTree object
	 */
	public NetworkTree() {
		this.root = new NetworkNode();
		this.cursor = new NetworkNode();
	}
	/**
	 * This method returns the root of the NetworkTree
	 * @return
	 * root
	 */
	public NetworkNode getRoot() {
		return root;
	}
	/**
	 * This method returns the cursor of the NetworkTree
	 * @return
	 * cursor
	 */
	public NetworkNode getCursor() {
		return cursor;
	}
	/**
	 * This method sets the cursor to the root
	 */
	public void cursorToRoot() {
		cursor = root;
	}
	/**
	 * This method removes the Node at the cursor and moves the rest of the Nodes to the left so there is not a hole in the array
	 * The method then returns the object it removed
	 * @return
	 * the NetworkNode that was removed
	 */
	public NetworkNode cutCursor() {
		NetworkNode temp = cursor;
		String nametoget = cursor.getName();
		cursor = cursor.getParent();
		NetworkNode[] childtemp = cursor.getChildren();
		for(int i=0; i < 9; i++) {
			if (childtemp[i].getName() == nametoget) {
				for(int j =i; j <9; j++) {
					if (childtemp[j+1] == null) {
						childtemp[j] = null;
					}
					childtemp[j] = childtemp[j+1]; 
				}
			break;
			}
		}
		cursor.setChildren(childtemp);
		cursor.setCount(cursor.getCount()-1);
		return temp;
	}
	/**
	 * This method adds a NetworkNode at the given index of a child array
	 * @param index
	 * index/spot within the array where the node is added
	 * @param node
	 * the NetworkNode
	 * @throws Exception
	 * When the index in which the node is being added will create a hole in the array (they skip an index)
	 */
	public void addChild (int index, NetworkNode node) throws Exception {
		NetworkNode[] childrentemp = cursor.getChildren();
		if(childrentemp[index-2] == null) {
			throw new Exception();
		}
		if(childrentemp[index-1] != null) {
			for (int i = 8; i > index -1; i--) {
				childrentemp[i] = childrentemp[i=1];
			}
		}
		childrentemp[index-1] = node;
		childrentemp[index-1].setParent(cursor);
		cursor.setChildren(childrentemp);
	}
	/**
	 * This method sets the cursor to the one of its child nodes at the given index
	 * @param index
	 * the spot within the child array
	 */
	public void cursorToChild(int index) {
		cursor = cursor.getSingleChild(index);
	}
	/**
	 * This method sets the cursor to its parent node
	 */
	public void cursorToParent() {
		cursor = cursor.getParent();
	}
	/**
	 * This method reads a given text file and creates a NetworkTree from it
	 * @param filename
	 * The text files name
	 * @return
	 * the completed NetworkTree
	 * @throws Exception
	 * When the text file can not be found
	 */
	public static NetworkTree readFromFile(String filename) throws Exception { 
		NetworkTree newtree = new NetworkTree();
		try {
			File myObj = new File(filename);
			try (Scanner input = new Scanner(myObj)) {
				newtree.root.setName(input.nextLine());
				while (input.hasNextLine()) {
					int tempindex = 1;
					newtree.cursor = newtree.root;
					NetworkNode parenttemp = newtree.cursor;
					String data = input.nextLine();
					if (data != newtree.root.getName()) {
						for(int i = 0; i < data.length(); i++) {
							if(Character.isDigit(data.charAt(i))){
								int num = Character.getNumericValue(data.charAt(i));
								parenttemp = newtree.cursor;
								newtree.cursor = newtree.cursor.getSingleChild(num+1);
								tempindex = num;
							}else if (String.valueOf(data.charAt(i)) == "-"){
								NetworkNode tempNode = new NetworkNode(data.substring(i),true,false);
								newtree.cursor = parenttemp;
								newtree.addChild(tempindex, tempNode);
							}else{
								NetworkNode tempNode = new NetworkNode(data.substring(i),false,false);
								newtree.cursor = parenttemp;
								newtree.addChild(tempindex, tempNode);
							}
						}

					}
					
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print("\n" + filename + " not found.");
		}
		
		return newtree;
	}
	/**
	 * This method recursively goes through the NetworkTree and prints out all of its Nodes onto a text file
	 * @param tree
	 * the NetworkTree
	 * @param filename
	 * the text file
	 * @throws FileNotFoundException
	 * the file does not exist
	 */
	public static void writeToFile (NetworkTree tree, String filename) throws FileNotFoundException {
		File newfile = new File(filename);
		PrintWriter pw = new PrintWriter(newfile);
		tree.cursorToRoot();
		for (int i =0; i<9; i++) {
			String frontnumbers = Integer.toString(i);
			while(tree.root.getSingleChild(i) != null) {
				for (int j = 0; j<9; j++) {
					tree.cursor = tree.cursor.getSingleChild(j);
				}
			}
		}
		
	}
	
	
	/**
	 * This method recursively goes through the NetworkTree and prints its Nodes
	 * @param arg
	 * The NetworkNode it starts with (normally the root)
	 * @param placementInArray
	 * The placement of the array within the tree ex: 1, 12, 123, where 123 is a child of 12 and 12 is a child of 1
	 * @param sortingnumber
	 * keeps track of the index of the array in which the node is
	 */
	public void recursivePrint(NetworkNode arg, int placementInArray, String sortingnumber) {
		for (int i = 0; i < 9; i++) {
			int x = 0;
			while (x<sortingnumber.length())
				System.out.print("    ");
			if(cursor.getNintendo() == true) {
				System.out.println("-" + cursor.getName());
			}else {
				System.out.println("+" + cursor.getName());
			}
			if(cursor.getSingleChild(placementInArray) != null) {
				cursor = root.getSingleChild(i);
				if (sortingnumber.length() >1) {
					sortingnumber = sortingnumber.substring(0,sortingnumber.length());
				}
				recursivePrint(cursor,placementInArray,sortingnumber + i);
			}else {
				break;
			}
		}
	}
	/**
	 * This is the method that initializes the recursivePrint method with the parameters root, placementInArray, and sorting number
	 */
	public void traverse() {
		int placementInArray = 1;
		String sortingnumber = "";
		cursorToRoot();
		recursivePrint(root, placementInArray, sortingnumber);
	}
}
