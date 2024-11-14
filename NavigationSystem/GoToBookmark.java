package jasonv2.NavigationSystem;
import java.util.Scanner;

public class GoToBookmark implements Command{
	
	private String bookmark;
	private String type;
	
	public GoToBookmark(Scanner scanner) {
		this.bookmark = scanner.toString();
		this.type = "safari";
	}
	
	public String getType() {
		return type;
	}
	public String getBookmark() {
		return bookmark;
	}

	public boolean validCommand(CommandStack stack) {

		return false;
	}

	public String toString() {
		return "Showing results for " + bookmark;
	}
	public String toShortString() {
		return "F:" + bookmark;
	}
	
	
}
