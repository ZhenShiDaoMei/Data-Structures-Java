package jasonv2.BookshelfSimulator;

public class EmptyShelfException extends Exception{

		public EmptyShelfException() {
		}
		public EmptyShelfException(String message) {
			System.out.println(message);
		}
}
