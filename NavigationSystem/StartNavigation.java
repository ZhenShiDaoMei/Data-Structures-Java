package jasonv2.NavigationSystem;

public class StartNavigation implements Command{

	private String source;
	private String destination;
	private String type;
	
	public StartNavigation(CommandStack commandstack) throws EmptyStackException {
		this.source = commandstack.peek().toShortString();
		this.destination = commandstack.peek().toShortString();
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
		return false;
	}

	public String toString() {
		if(source == null && destination == null) {
			return "\nNo route or destination!";
		}
		if(source == null && destination != null) {
			return "Navigating to " + destination;
		}
		return "Navigating from " + source + " to " + destination;
	}
	
	public String toShortString() {
		if(source == null && destination != null) {
			return "N:" + destination;
		}
		return "N:" + source + "-" + destination;
	}
}
