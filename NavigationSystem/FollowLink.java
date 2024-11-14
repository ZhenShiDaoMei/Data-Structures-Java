package jasonv2.NavigationSystem;
import java.util.Scanner;

public class FollowLink implements Command{

	private String link;
	private String type;
	
	public FollowLink(Scanner scanner) {
		this.link = scanner.toString();
		this.type = "safari";
	}

	public String getType() {
		return type;
	}
	public String getLink() {
		return link;
	}
	
	public boolean validCommand(CommandStack stack) {

		return false;
	}

	public String toString() {
		return link;
	}
	public String toShortString() {
		
		return "L:" + link;
	}
	
	
}
