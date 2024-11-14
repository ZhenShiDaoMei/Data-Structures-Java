package jasonv2.DeliverySimulator;

/**
 * This class represents a DeliveryListNode which has data, next and previous.
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class DeliveryListNode {
	private Delivery data;
	private DeliveryListNode next;
	private DeliveryListNode prev;
	/**
	 * This is the constructor of the DeliveryListNode object
	 * 
	 * @param initData
	 * Delivery object that contains information
	 * 
	 * @throws IllegalArgumentException
	 * When the initData is null
	 */
	public DeliveryListNode(Delivery initData) throws IllegalArgumentException{
		if (initData == null) {
			throw new IllegalArgumentException();
		}
		this.data = initData;
		this.next = null;
		this.prev = null;
	}
	/**
	 * This method returns the data of the DeliveryListNode object
	 * 
	 * @return
	 * data
	 */
	public Delivery getData() {
		return data;
	}
	/**
	 * This method returns the next of the DeliveryListNode object
	 * 
	 * @return
	 * next
	 */
	public DeliveryListNode getNext() {
		return next;
	}
	/**
	 * This method returns the previous of the DeliveryListNode object
	 * 
	 * @return
	 * previous
	 */
	public DeliveryListNode getPrev() {
		return prev;
	}
	/**
	 * This method modifies the data of the DeliveryListNode object
	 * 
	 * @param data
	 * new data
	 */
	public void setData(Delivery data) {
		this.data = data;
	}
	/**
	 * This method modifies the next of the DeliveryListNode object
	 * 
	 * @param next
	 * new next
	 */
	public void setNext(DeliveryListNode next) {
		this.next = next;
	}
	/**
	 * This method modifies the previous of the DeliveryListNode object
	 * 
	 * @param prev
	 * new previous
	 */
	public void setPrev(DeliveryListNode prev) {
		this.prev = prev;
	}
}
