package jasonv2.NavigationSystem;

public interface Command {

	public boolean validCommand(CommandStack stack);
	
	public String toString();
	
	public String toShortString();
	
}
