package jasonv2.DeliverySimulator;
import java.util.Scanner;
/**
 * This class represents a DeliveryDriver with 2 DeliverList objects: listA and listB, 2 Strings: listLetter and choiceLetter, and a Delivery object: temporary.
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class DeliveryDriver {
	private static DeliveryList listA;
	private static DeliveryList listB;
	private String listLetter;
	private String choiceLetter;
	private Delivery temp;
	/**
	 * This is the main method of the class
	 * The main method is a while loop that constantly asks the user for input until the String choiceLetter is equal to q or Q.
	 * 
	 * @param args
	 * 
	 * @throws EndOfListException
	 * When certain objects information can't be reached/obtained
	 * @throws IllegalArgumentException
	 * When there isn't any information available
	 */
	public static void main(String[] args) throws EndOfListException, IllegalArgumentException {
		DeliveryDriver driver = new DeliveryDriver();
		printSlogan();
		printMenu();
		while(!driver.getChoice().equals("q") && !driver.getChoice().equals("Q")) {
			driver.choice();
			if(driver.getChoice().equals("A") || driver.getChoice().equals("a")) {
				try {
					driver.addDelivery();
				}catch (IllegalArgumentException e) {
					System.out.print("\nCannot add a Delivery without sufficient information.");
				}
			}
			if(driver.getChoice().equals("R") || driver.getChoice().equals("r")) {
				try {
					driver.removeDelivery();
				}catch (EndOfListException e) {
					System.out.print("\nThere is nothing to remove at the cursor.");
				}catch (IllegalArgumentException e) {
					System.out.print("\nThere is nothing to remove at the cursor.");
				}
			}
			if(driver.getChoice().equals("X") || driver.getChoice().equals("x")) {
				try {
					driver.cutCursor();
				}catch (EndOfListException e) {
					System.out.print("\nThere is nothing to cut at the cursor.");
				}catch (IllegalArgumentException e) {
					System.out.print("\nThere is nothing to cut at the cursor");
				}
			}
			if(driver.getChoice().equals("V") || driver.getChoice().equals("v")) {
				try {
					driver.pasteAfterCursor();
				}catch (IllegalArgumentException e) {
					System.out.print("\nThere is nothing to paste. (must cut before pasting)");
				}
			}
			if(driver.getChoice().equals("H") || driver.getChoice().equals("h")) {
				driver.cursorToHead();
			}
			if(driver.getChoice().equals("T") || driver.getChoice().equals("t")) {
				driver.cursorToTail();
			}
			if(driver.getChoice().equals("F") || driver.getChoice().equals("f")) {
				try {
					driver.cursorForward();
				}catch (EndOfListException e) {
					System.out.print("\nCursor cannot move further forward");
				}
			}
			if(driver.getChoice().equals("B") || driver.getChoice().equals("b")) {
				try {
					driver.cursorBackward();
				}catch (EndOfListException e) {
					System.out.print("\nCursor cannot move further backward");
				}
			}
			if(driver.getChoice().equals("S") || driver.getChoice().equals("s")) {
				driver.switchLists();
			}
			if(driver.getChoice().equals("P") || driver.getChoice().equals("p")) {
				driver.printList();
			}
		}
		System.out.print("\nNext time, try UPS!");
	}
	/**
	 * This is the constructor of the DeliveryDriver object
	 * This constructor activates the 2 DeliveryList objects and sets the rest of the private variables to something
	 */
	public DeliveryDriver() {
		listA = new DeliveryList();
		listB = new DeliveryList();
		listLetter = "A";
		choiceLetter = "";
		temp = null;
	}
	/**
	 * This is a method that returns the DeliveryList object listA of DeliveryDriver
	 * 
	 * @return
	 * listA
	 */
	public DeliveryList getListA() {
		return listA;
	}
	/**
	 * this is a method that returns the DeliveryList object listB of DeliveryDriver
	 * 
	 * @return
	 * listB
	 */
	public DeliveryList getListB() {
		return listB;
	}
	/**
	 * This is a method that returns the String listLetter of DeliveryDriver
	 * 
	 * @return
	 * listLetter
	 */
	public String getLetter() {
		return listLetter;
	}
	/**
	 * this is a method that returns the String choiceLetter of DeliveryDriver
	 * 
	 * @return
	 * choiceLetter
	 */
	public String getChoice() {
		return choiceLetter;
	}
	/**
	 * This is the method that prints out the slogan
	 */
	public static void printSlogan() {
		System.out.print("Welcome to the Delinquent Dollar Delivery Scheduler.\n");
	}
	/**
	 * This is the method that prints out the menu
	 */
	public static void printMenu() {
		System.out.print("\nmenu: ");
		System.out.print("\n     A) Add a Delivery After Cursor");
		System.out.print("\n     R) Remove Delivery At Cursor");
		System.out.print("\n     X) Cut Cursor");
		System.out.print("\n     V) Paste After Cursor");
		System.out.print("\n     H) Cursor to Head");
		System.out.print("\n     T) Cursor to Tail");
		System.out.print("\n     F) Cursor Forward");
		System.out.print("\n     B) Cursor Backward");
		System.out.print("\n     S) Switch Delivery Lists");
		System.out.print("\n     P) Print current list");
		System.out.print("\n     Q) Quit");
	}
	/**
	 * This is the method that asks the user for an input
	 */
	public void choice() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("\n\nPlease select an option: ");
			choiceLetter = input.nextLine();
		}
	}
	/**
	 * This is the method that asks the user for inputs in order to create a Delivery object
	 * After creating a Delivery object, the method adds the new object after the cursor
	 */
	public void addDelivery() {
		String source, destination, instruction;
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("\nPlease enter a source: ");
			source = input.nextLine();
		}
		try (Scanner input2 = new Scanner(System.in)) {
			System.out.println("\nPlease enter an destination: ");
			destination = input2.nextLine();
		}
		try (Scanner input3 = new Scanner(System.in)) {
			System.out.println("\nPlease enter any special instructions: ");
			instruction = input3.nextLine();
		}
		Delivery newDeliv = new Delivery(source, destination, instruction);
		if(listLetter.equals("A")) {
			listA.insertAfterCursor(newDeliv);
		}
		if(listLetter.equals("B")) {
			listB.insertAfterCursor(newDeliv);
		}
		System.out.print("\nOrder inserted.");
	}
	/**
	 * This is the method that removes the DeliveryListNode object at the cursor
	 * 
	 * @throws EndOfListException
	 * When there is no DeliveryListNode objects in the DeliveryList object
	 * @throws IllegalArgumentException
	 * When the cursor doesn't point to a DeliveryListNode object
	 */
	public void removeDelivery() throws EndOfListException, IllegalArgumentException {
		if(listLetter.equals("A")) {
			System.out.print("\nDelivery to " + listA.getCursor().getDest() + " removed.");
			listA.removeCursor();
		}
		if(listLetter.equals("B")) {
			System.out.print("\nDelivery to " + listB.getCursor().getDest() + " removed.");
			listB.removeCursor();
		}
	}
	/**
	 * This is the method that cuts the DeliveryListNode object at the cursor, and saves the information
	 * 
	 * @throws EndOfListException
	 * When there is no DeliveryListNode objects in the DeliveryList object
	 * @throws IllegalArgumentException
	 * When the cursor doesn't point to a DeliveryListNode object
	 */
	public void cutCursor() throws EndOfListException, IllegalArgumentException{
		if(listLetter.equals("A")) {
			temp = listA.getCursor();
			listA.removeCursor();
		}
		if(listLetter.equals("B")) {
			temp = listB.getCursor();
			listB.removeCursor();
		}
		System.out.print("\nCursor is cut.");
	}
	/**
	 * This is the method that pastes the information (pasted after cursor) that was stored when the user used the cutCursor() method
	 * After pasting the information, the method prints out the DeliveryList object
	 * 
	 * @throws IllegalArgumentException
	 * When there is no stored information to paste
	 */
	public void pasteAfterCursor() throws IllegalArgumentException{
		if(listLetter.equals("A")) {
			listA.insertAfterCursor(temp);
			System.out.print("\nList " + listLetter + " Deliveries:");
			System.out.print("\n----------------------------------------------------------------");
			DeliveryListNode tempHead = listA.getHead();
			for (int i = 0; i < listA.numDeliveries(); i++) {
				if(listA.getHead().getData() == listA.getCursor()) {
					System.out.print("\n->");
				}
				else {
					System.out.print("\n~");
				}
				System.out.print(listA.getHead().getData().toString());
				if(listA.getHead().getNext() == null)
					break;
				listA.setHead(listA.getHead().getNext());
			}
			System.out.print("\n----------------------------------------------------------------");
			listA.setHead(tempHead);
		}
		if(listLetter.equals("B")) {
			listB.insertAfterCursor(temp);
			System.out.print("\nList " + listLetter + " Deliveries:");
			System.out.print("\n----------------------------------------------------------------");
			DeliveryListNode tempHead2 = listB.getHead();
			for (int i = 0; i < listB.numDeliveries(); i++) {
				if(listB.getHead().getData() == listB.getCursor()) {
					System.out.print("\n->");
				}
				else {
					System.out.print("\n~");
				}
				System.out.print(listB.getHead().getData().toString());
				if(listB.getHead().getNext() == null)
					break;
				listB.setHead(listB.getHead().getNext());
			}
			System.out.print("\n----------------------------------------------------------------");
			listB.setHead(tempHead2);
		}
	}
	/**
	 * This method sets the cursor to the head
	 */
	public void cursorToHead() {
		if(listLetter.equals("A")) {
			listA.resetCursorToHead();
		}
		if(listLetter.equals("B")) {
			listB.resetCursorToHead();
		}
		System.out.print("\nCursor is at Head.");
	}
	/**
	 * This method sets the cursor to the tail
	 */
	public void cursorToTail() {
		if(listLetter.equals("A")) {
			listA.resetCursorToTail();
		}
		if(listLetter.equals("B")) {
			listB.resetCursorToTail();
		}
		System.out.print("\nCursor is at Tail.");
	}
	/**
	 * This method moves the cursor to the next DeliveryListNode object
	 * 
	 * @throws EndOfListException
	 * When there is no DeliveryListNode object next to cursor
	 */
	public void cursorForward() throws EndOfListException {
		if(listLetter.equals("A")) {
			listA.cursorForward();
		}
		if(listLetter.equals("B")) {
			listB.cursorForward();
		}
		System.out.print("\nCursor moved forward.");
	}
	/**
	 * This method moves the cursor to the previous DeliveryListNode object
	 * 
	 * @throws EndOfListException
	 * When there is no DeliveryListNode object previous to cursor
	 */
	public void cursorBackward() throws EndOfListException {
		if(listLetter.equals("A")) {
			listA.cursorBackward();
		}
		if(listLetter.equals("B")) {
			listB.cursorBackward();
		}
		System.out.print("\nCursor moved backward.");
	}
	/**
	 * This method switches the DeliveryList object the user modifies
	 */
	public void switchLists() {
		if(listLetter.equals("A")) {
			listLetter = "B";
			System.out.print("\nDelivery List " + listLetter + " was selected");
			return;
		}
		if (listLetter.equals("B")) {
			listLetter = "A";
			System.out.print("\nDelivery List " + listLetter + " was selected");
			return;
		}
	}
	/**
	 * This method prints out the DeliveryList object
	 * 
	 */
	public void printList() {
		System.out.print("\nList " + listLetter + " Deliveries:");
		System.out.print("\n----------------------------------------------------------------");
		if(listLetter.equals("A")) {
			DeliveryListNode tempHead = listA.getHead();
			for (int i = 0; i < listA.numDeliveries(); i++) {
				if(listA.getHead().getData() == listA.getCursor()) {
					System.out.print("\n->");
				}
				else {
					System.out.print("\n~");
				}
				System.out.print(listA.getHead().getData().toString());
				if(listA.getHead().getNext() == null)
					break;
				listA.setHead(listA.getHead().getNext());
			}
			System.out.print("\n----------------------------------------------------------------");
			listA.setHead(tempHead);
		}
		if(listLetter.equals("B")) {
			DeliveryListNode tempHead = listB.getHead();
			for (int i = 0; i < listB.numDeliveries(); i++) {
				if(listB.getHead().getData() == listB.getCursor()) {
					System.out.print("\n->");
				}
				else {
					System.out.print("\n~");
				}
				System.out.print(listB.getHead().getData().toString());
				if(listB.getHead().getNext() == null)
					break;
				listB.setHead(listB.getHead().getNext());
			}
			System.out.print("\n----------------------------------------------------------------");
			listB.setHead(tempHead);
		}
	}
}
