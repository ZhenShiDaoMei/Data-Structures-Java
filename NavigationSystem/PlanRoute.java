package jasonv2.NavigationSystem;
import java.util.Scanner;

public class PlanRoute implements Command{

	private String source;
	private String destination;
	private String type;
	
	public PlanRoute(Scanner scanner) {
		this.source = scanner.toString();
		Scanner input2 = new Scanner(System.in);
		System.out.print("\nPlease enter a destination: ");
		String dest = input2.nextLine();
		this.destination = dest;
		this.type = "map";
	}

	public String getType() {
		return type;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public boolean validCommand(CommandStack stack) {
		if (source == null || destination == null) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "Navitgating from " + source + " to " + destination;
	}
	
	public String toShortString() {

		return "P:" + source + "-" + destination;
	}
}
