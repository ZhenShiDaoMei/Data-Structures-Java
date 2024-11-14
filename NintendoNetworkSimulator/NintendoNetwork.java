package jasonv2.NintendoNetworkSimulator;
import java.util.Scanner;
/**
 * This class represents a NintendoNetwork that contains a NetworkTree tree and String choiceLetter.
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */

public class NintendoNetwork {

	private static NetworkTree tree;
	private String choiceLetter;
	private static NetworkNode temp;
	/**
	 * This is the main method of the class. The main method constantly asks for input from the user until the user inputs q or Q
	 * @param args
	 * 
	 * @throws Exception
	 * throws when there is a hole in the array or when there is nothing/lack of information
	 */
	public static void main (String[] args) throws Exception {
		NintendoNetwork network = new NintendoNetwork();
		printSlogan();
		printMenu();
		while(!network.getChoice().equals("q") && !network.getChoice().equals("Q")) {
			network.Choice();
			if(network.getChoice().equals("L") || network.getChoice().equals("l")) {
				NintendoNetwork.loadFromFile();
			}
            if(network.getChoice().equals("P") || network.getChoice().equals("p")) {
				NintendoNetwork.print();
			}
            if(network.getChoice().equals("C") || network.getChoice().equals("c")) {
            	NintendoNetwork.moveToChildNode();
            }
            if(network.getChoice().equals("R") || network.getChoice().equals("r")) {
            	NintendoNetwork.moveToRoot();
            }
            if(network.getChoice().equals("U") || network.getChoice().equals("u")) {
            	NintendoNetwork.moveToParent();
            }
            if(network.getChoice().equals("A") || network.getChoice().equals("a")) {
            	try {
            		NintendoNetwork.addChild();
            	}catch (Exception e) {
            		System.out.print("\nAdding the node at that index will make a hole.");
            	}
            	
            }
            if(network.getChoice().equals("X") || network.getChoice().equals("x")) {
            	try {
            		NintendoNetwork.cutCursor();
            	}catch (Exception e) {
            		System.out.print("\nNothing to cut.");
            	}
            	
            }
            if(network.getChoice().equals("V") || network.getChoice().equals("v")) {
            	try {
            		NintendoNetwork.pasteCursor();
            	}catch (Exception e){
            		System.out.print("\nEither there is nothing to paste or pasting the node will make a hole.");
            	}
            	
            }
            if(network.getChoice().equals("S") || network.getChoice().equals("s")) {
            	String filename;
        		try (Scanner input1 = new Scanner(System.in)) {
					System.out.print("\nPlease enter a file name: ");
					filename = input1.nextLine();
				}
        		NetworkTree.writeToFile(tree, filename);
            }
            if(network.getChoice().equals("M") || network.getChoice().equals("m")) {
            	
            }
            if(network.getChoice().equals("B") || network.getChoice().equals("b")) {
            	NintendoNetwork.markCursor();
            }
		}
	}
	/**
	 * The constructor of the NintendoNetwork object 
	 */
	public NintendoNetwork () {
		tree = new NetworkTree();
		choiceLetter = "";
		temp = new NetworkNode();
	}
	/**
	 * This method prints the slogan
	 */
	public static void printSlogan() {
		System.out.println("Welcome to the Nintendo Network Manager.");
	}
	/**
	 * This method prints the menu for the user
	 */
	public static void printMenu() {
		System.out.print("\nmenu: ");
		System.out.print("\n     L) Load from file");	
		System.out.print("\n     P) Print tree");
		System.out.print("\n     C) Move cursor to a child node");
		System.out.print("\n     R) Move cursor to root");
		System.out.print("\n     U) Move cursor up to parent");
		System.out.print("\n     A) Add child");
		System.out.print("\n     X) Remove/Cut cursor and its subtree");
		System.out.print("\n     V) Paste cursor and its subtree");
		System.out.print("\n     S) Save to file");
		System.out.print("\n     M) Cursor to root of minimal subtree containing all faults");
		System.out.print("\n     B) Mark cursor as broken/fixed");
		System.out.print("\n     Q) Quit");
	}
	/**
	 * This method looks at a text file and creates a NetworkTree from it
	 * @throws Exception
	 * When the text file does not exist
	 */
	public void loadFile() throws Exception {
		String fileName;
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("\nPlease enter filename: ");
			fileName = input.nextLine();
		}
		NetworkTree.readFromFile(fileName);
	}
	/**
	 * This method returns the choiceLetter
	 * @return
	 * choice letter
	 */
	public String getChoice() {
		return choiceLetter;
	}
	/**
	 * This is the method that asks the user for their choice
	 */
	public void Choice() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("\n\nPlease select an option: ");
			choiceLetter = input.nextLine();
		}
	}
	/**
	 * This is another method that does the exact same thing as loadFile(), I don't know why it's here
	 * @throws Exception
	 * When the text file does not exist
	 */
	public static void loadFromFile() throws Exception {
		String filename;
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("\nPlease enter filename");
			filename = input.nextLine();
		}
		tree = NetworkTree.readFromFile(filename);
	}
	/**
	 * This is the method that prints the NetworkTree
	 */
	public static void print() {
		tree.traverse();
	}
	/**
	 * This is the method that moves the cursor to the child node
	 */
	public static void moveToChildNode() {
		int index;
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("\nPlease enter an index: ");
			index = input.nextInt();
		}
		tree.cursorToChild(index);
		System.out.print("Cursor moved to " + tree.getCursor().getName());
	}
	/**
	 * This is the method that moves the cursor to the root
	 */
	public static void moveToRoot() {
		tree.cursorToRoot();
		System.out.print("Cursor moved to " + tree.getRoot());
	}
	/**
	 * this is the method that moves the cursor to the parent
	 */
	public static void moveToParent() {
		tree.cursorToParent();
		System.out.print("Cursor moved to " + tree.getCursor().getName());
	}
	/**
	 * this is the method that adds a child into the child array of a node
	 * @throws Exception
	 * when adding the new child node will make a hole in the array.
	 */
	public static void addChild() throws Exception {
		if (tree.getRoot() == null) {
			String name;
			try (Scanner input = new Scanner(System.in)) {
				System.out.print("\nPlease enter device name: ");
				name = input.nextLine();
			}
			tree.getRoot().setName(name);
		}else {
			boolean nintendo;
			int index;
			String name, temper;
			try (Scanner input = new Scanner(System.in)) {
				System.out.print("\nPlease enter device name: ");
				name = input.nextLine();
			}
			try (Scanner input1 = new Scanner(System.in)) {
				System.out.print("\nPlease enter an index: ");
				index = input1.nextInt();
			}
			try (Scanner input2 = new Scanner(System.in)) {
				System.out.print("\nIs this Nintendo?: ");
				temper = input2.nextLine();
			}
			if(temper.equals("y") || temper.equals("Y")){
				nintendo = true;
			}else {
				nintendo = false;
			}
			
			NetworkNode temp = new NetworkNode(name, nintendo, false);
			tree.addChild(index, temp);
		}
	}
	/**
	 * This is the method that modifies the isBroken of the cursor node
	 */
	public static void markCursor() {
		if(tree.getCursor().getBroken() == true) {
			tree.getCursor().setBroken(false);
		}else {
			tree.getCursor().setBroken(true);
		}
	}
	/**
	 * This is the method that cuts the node at the cursor and stores it
	 */
	public static void cutCursor() {
		temp = tree.cutCursor();
	}
	/**
	 * this is the method that pastes the stored node that was cut
	 * @throws Exception
	 * when adding the node will create a hole within the array
	 */
	public static void pasteCursor() throws Exception {
		int index;
		try (Scanner input1 = new Scanner(System.in)) {
			System.out.print("\nPlease enter an index: ");
			index = input1.nextInt();
		}
		tree.addChild(index, temp);
		System.out.print(temp + " pasted as child of " + tree.getCursor().getName());
	}

}
