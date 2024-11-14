package jasonv2.DeliverySimulator;
/**
 * This class represents a Delivery which has a source, destination and instruction.
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class Delivery {
	private String source;
	private String dest;
	private String instruction;
	/**
	 * This method returns the source of the Delivery object
	 * 
	 * @return
	 * source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * This method returns the destination of the Delivery object
	 * 
	 * @return
	 * destination
	 */
	public String getDest() {
		return dest;
	}
	/**
	 * This method returns the instruction of the Delivery object
	 * 
	 * @return
	 * instruction
	 */
	public String instruction() {
		return instruction;
	}
	/**
	 * This method modifies the source of the Delivery object
	 * 
	 * @param source
	 * new source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * This method modifies the destination of the Delivery object
	 * 
	 * @param dest
	 * new destination
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	/**
	 * This method modifies the instruction of the Delivery object
	 * 
	 * @param instruction
	 * new instruction
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	/**
	 * This is the constructor of the Delivery object
	 * 
	 * @param source
	 * source of delivery
	 * @param dest
	 * destination of delivery
	 * @param instruction
	 * instructions for delivery
	 */
	public Delivery(String source, String dest, String instruction) {
		this.source = source;
		this.dest = dest;
		this.instruction = instruction;
	}
	/**
	 * This method returns a printable version of the Delivery object
	 * 
	 * @return
	 * String of the Delivery object
	 */
	public String toString() {
		return "\nTo: " + dest + " | " + "From: " + source + "\nInstruction: " + instruction + ".";
	}
}
