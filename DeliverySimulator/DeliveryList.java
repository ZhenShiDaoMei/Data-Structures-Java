package jasonv2.DeliverySimulator;

/**
 * This class represents a DeliveryList that has a head, tail, cursor and numDeliveries
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class DeliveryList {
	private DeliveryListNode head;
	private DeliveryListNode tail;
	private DeliveryListNode cursor;
	private int numDeliveries;
	/**
	 * This is the constructor of the DeliveryList object
	 * Sets all private variables to either null or 0
	 */
	public DeliveryList() {
		this.head = null;
		this.tail = null;
		this.cursor = null;
		numDeliveries = 0;
	}
	/**
	 * This is a method that returns the head of the DeliveryList object
	 * 
	 * @return
	 * head
	 */
	public DeliveryListNode getHead() {
		return head;
	}
	/**
	 * This is a method that modifies the head of the DeliveryList object
	 * 
	 * @param head
	 * new head
	 */
	public void setHead(DeliveryListNode head) {
		this.head = head;
	}
	/**
	 * This is a method that returns the tail of the DeliveryList object
	 * 
	 * @return
	 * tail
	 */
	public DeliveryListNode getTail() {
		return tail;
	}
	/**
	 * This is a method that returns the numDeliveries of the DeliveryList object
	 * 
	 * @return
	 * numDeliveries
	 */
	public int numDeliveries() {
		return numDeliveries;
	}
	/**
	 * This is the method that returns the information of the cursor in DeliveryList object
	 * 
	 * @return
	 * data of cursor (cursor is a DeliveryListNode object)
	 * 
	 * @throws IllegalArgumentException
	 * When cursor is null and has no data to return
	 */
	public Delivery getCursor() throws IllegalArgumentException{
		if (cursor == null) {
			throw new IllegalArgumentException();
		}
		return(cursor.getData());
	}
	/**
	 * This method sets the cursor to the head, if head is null; cursor is set to null
	 */
	public void resetCursorToHead() {
		if (head == null) {
			this.cursor = null;
			}
		else {
			cursor = head;
			}
	}
	/**
	 * This method sets the cursor to the tail, if tail is null; cursor is set to null
	 */
	public void resetCursorToTail() {
		if (tail == null) {
			this.cursor = null;
		}
		else {
			cursor = tail;
		}
	}
	/**
	 * This method sets the cursor to the DeliveryListNode next to it
	 * 
	 * @throws EndOfListException
	 * When either the cursor is at the tail (nothing next to it), or when both cursor and tail are null (nothing in general)
	 */
	public void cursorForward() throws EndOfListException{
		if(cursor == tail) {
			throw new EndOfListException();
		}
		if(cursor == null && tail == null) {
			throw new EndOfListException();
		}
		cursor = cursor.getNext();
		
	}
	/**
	 * This method sets the cursor to the DeliveryListNode previous to it
	 * 
	 * @throws EndOfListException
	 * When either the cursor is at the head (nothing previous to it), or when both cursor and head are null (nothing in general)
	 */
	public void cursorBackward() throws EndOfListException{
		if(cursor == head) {
			throw new EndOfListException();
		}
		if(cursor == null && head == null) {
			throw new EndOfListException();
		}
		cursor = cursor.getPrev();
	}
	/**
	 * This method takes a Delivery object and makes it into DeliveryListNode object
	 * The method then inserts the new DeliveryListNode after the cursor.
	 * 
	 * @param newDelivery
	 * Delivery object
	 * 
	 * @throws IllegalArgumentException
	 * When the Delivery object has no information or not enough information
	 */
	public void insertAfterCursor(Delivery newDelivery) throws IllegalArgumentException{
		if (newDelivery == null) {
			throw new IllegalArgumentException();
		}
		DeliveryListNode temp = new DeliveryListNode(newDelivery);
		if (cursor == null) {
			head = temp;
			tail = temp;
			cursor = temp;
		}
		else {
			if(cursor.getNext() == null) {
				temp.setPrev(cursor);
				cursor.setNext(temp);
				temp.setNext(null);
				this.tail = temp;
			}
			else {
				cursor.getNext().setPrev(temp);
				temp.setNext(cursor.getNext());
				cursor.setNext(temp);
				temp.setPrev(cursor);
			}
		}
		numDeliveries += 1;
	}
	/**
	 * This method does the exact same as the previous one, but instead of adding the new DeliveryListNode object after the cursor, it adds it after the tail
	 * After this method adds the new DeliveryListNode, the method sets it as the new tail
	 * 
	 * @param newDelivery
	 * Delivery object
	 * 
	 * @throws IllegalArgumentException
	 * When the Delivery object has no information or not enough information
	 */
	public void appendToTail(Delivery newDelivery) throws IllegalArgumentException{
		if (newDelivery == null) {
			throw new IllegalArgumentException();
		}
		DeliveryListNode temp2 = new DeliveryListNode(newDelivery);
		if (tail == null) {
			this.head = temp2;
			this.cursor = temp2;
			this.tail = temp2;
		}
		else {
			if(tail.getNext() == null) {
				tail.setNext(temp2);
				temp2.setPrev(tail);
				temp2.setNext(null);
			}
			else {
				tail.getNext().setPrev(temp2);
				temp2.setNext(tail.getNext());
				tail.setNext(temp2);
				temp2.setPrev(tail);
			}
		}
		numDeliveries += 1;
	}
	/**
	 * This method removes the DeliveryListNode object at the cursor, and returns the information of the removed object
	 * 
	 * @return
	 * removed DeliveryListNode object
	 * 
	 * @throws EndOfListException
	 * When the cursor isn't pointing at a DeliveryListNode object
	 */
	public Delivery removeCursor() throws EndOfListException{
		if(cursor == null) {
			throw new EndOfListException();
		}
		DeliveryListNode removed = cursor;
		if(cursor.getPrev() == null && cursor.getNext() == null) {
			head = null;
			tail = null;
			cursor = null;
		}
		else {
			if(cursor.getNext() == null) {
				cursor.getPrev().setNext(null);
				tail = cursor.getPrev();
				cursor = cursor.getPrev();
			}
			else {
				if(cursor.getPrev() == null) {
					cursor.getNext().setPrev(null);
					head = cursor.getNext();
					cursor = cursor.getNext();
				}
				else {
					cursor.getPrev().setNext(cursor.getNext());
					cursor.getNext().setPrev(cursor.getPrev());
					cursor = cursor.getNext();
				}
			}	
		}
		numDeliveries -= 1;
		return removed.getData();
	}
}
