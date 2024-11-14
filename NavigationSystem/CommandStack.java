package jasonv2.NavigationSystem;
import java.util.LinkedList;
public class CommandStack {
	private LinkedList<Command> stack;
	private int count;
	
	//FINISH THIS CLASS BEFORE MAKING THE CONSTRUCTOR FOR OTHER CLASSES. Finish the methods.s
	public CommandStack() {
		this.stack = new LinkedList<Command>();
		this.count = 0;
	}	

	public LinkedList <Command> getStack(){
		return stack;
	}
	public void push(Command command) throws InvalidCommandException{
		if(stack.peek().validCommand(null)) {
			throw new InvalidCommandException();
		}
		stack.push(command);
	}
	public Command pop() throws EmptyStackException {
		if(stack.peekLast() == null) {
			throw new EmptyStackException();
		}
		return stack.pop();
	}
	public Command peek() throws EmptyStackException {
		if(stack.peekLast() == null) {
			throw new EmptyStackException();
		}
		return stack.peekLast();
	}
	public boolean isEmpty() {
		if(stack.peekLast() == null) {
			return true;
		}
		return false;
	}
	public String getScreenCommand() {
		return stack.peek().toString();
	}
	public String toString() {
		return stack.peek().toShortString();
	}
}
