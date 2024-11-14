package jasonv2.NavigationSystem;
import java.util.Scanner;

public class GoogleSomething implements Command{

	private String query;
	private String type;
	
	public GoogleSomething (Scanner scanner) {
		this.query = scanner.toString();
		this.type = "safari";
	}
	
	public String getQuery() {
		return query;
	}

	public String getType() {
		return type;
	}
	public boolean validCommand(CommandStack stack) {

		return false;
	}

	public String toString() {
		return "Google: " + query;
	}
	public String toShortString() {

		return "G:" + query;
	}
}
