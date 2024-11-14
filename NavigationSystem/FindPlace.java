package jasonv2.NavigationSystem;
import java.util.Scanner;

public class FindPlace implements Command{

	private String destination;
	private String type;
	
	public FindPlace(Scanner scanner) {
		String temp = scanner.toString();
		this.destination = temp;
		this.type = "map";
	}
	public String getType() {
		return type;
	}
	public String getDestination() {
		return destination;
	}
	//needs work
	public boolean validCommand(CommandStack stack) {
		if(destination == null) {
			return false;
		}
		return true;
	}
	//needs work
	public String toString() {
		return "Showing results for " + destination;
	}
	//needs work
	public String toShortString() {

		return "F:" + destination;
	}
	

}
