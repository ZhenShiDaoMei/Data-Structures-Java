package jasonv2.BookshelfSimulator;
import java.util.Scanner;
/**
 * This class represents a RipoffRental which has three Bookshelf objects: shelfA, shelfB and shelfC
 * The class also has a Letter and shelfLetter
 * 
 * @author Jason Wu, 114474379, R04 recitation
 */
public class RipoffRental {
	private static Bookshelf shelfA;
	private static Bookshelf shelfB;
	private static Bookshelf shelfC;
	private String Letter;
	private String shelfLetter;
	/**
	 * This is the main method where all the other methods take place
	 * @param args
	 * Arguments
	 * 
	 * @throws IllegalArgumentException
	 * When the inputs of a method cause a hole in the Bookshelf object
	 * @throws FullShelfException
	 * When the current Bookshelf object is full
	 * @throws ArrayIndexOutOfBoundsException
	 * When the index inputs of a method are out of bounds (<=0 or 20>)
	 * @throws EmptyShelfException
	 * When the current Bookshelf object is empty
	 */
	public static void main(String[] args) throws IllegalArgumentException, FullShelfException, ArrayIndexOutOfBoundsException, EmptyShelfException {
		RipoffRental rip = new RipoffRental();
		printSlogan();
		printMenu();
		while(!rip.getLetter().equals("Q") && !rip.getLetter().equals("q")) {
			rip.choice();
			if (rip.getLetter().equals("A") || rip.getLetter().equals("a")) {
				try {
					rip.addBook();
				}catch (FullShelfException e) {
					System.out.println("The Bookshelf is full");
					
				}catch (IllegalArgumentException e) {
					System.out.println("Try not to make a hole in the bookshelf");
				}
			}
			if (rip.getLetter().equals("S") || rip.getLetter().equals("s")) {
				try {
					rip.swapBooks();
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Atleast one of the books you're trying to swap is out of bounds");
				}
			}
			if (rip.getLetter().equals("L") || rip.getLetter().equals("l")) {
				try {
					rip.loanBook();
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("The book you're trying to loan out does not exist in the bookshelf");
				}
			}
			if (rip.getLetter().equals("R") || rip.getLetter().equals("r")) {
				try {
					rip.removeBook();
				}catch(EmptyShelfException e) {
					System.out.println("The shelf is currently empty");
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("The book you are trying to remove does not exist");
				}
			}
			if (rip.getLetter().equals("D") || rip.getLetter().equals("d")) {
				try {
					rip.duplicateBook();
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Either the book you are trying to duplicate does not exist or the position you want the duplicated book is outside of the bookshelf");
				}catch(FullShelfException e) {
					System.out.println("The bookshelf is full");
				}catch(IllegalArgumentException e) {
					System.out.println("Try not to make a hole in the bookshelf");
				}
			}
			if (rip.getLetter().equals("C") || rip.getLetter().equals("c")) {
				rip.changeShelf();
			}
			if (rip.getLetter().equals("O") || rip.getLetter().equals("o")) {
				rip.overwrite();
			}
			if (rip.getLetter().equals("E") || rip.getLetter().equals("e")) {
				rip.equality();
			}
			if (rip.getLetter().equals("P") || rip.getLetter().equals("p")) {
				rip.printBookshelf();
			}
		}
		System.out.println("Goodbye!");
		
		

	}
	/**
	 * This is the constructor used to create a new RipoffRental object
	 */
	public RipoffRental() {
		shelfA = new Bookshelf();
		shelfB = new Bookshelf();
		shelfC = new Bookshelf();
		this.Letter = "";
		this.shelfLetter = "A";
	}
	/**
	 * This method returns the Bookshelf object shelfA
	 * 
	 * @return
	 * shelfA
	 */
	public Bookshelf getShelfA() {
		return shelfA;
	}
	/**
	 * This method returns the Bookshelf object shelfB
	 * 
	 * @return
	 * shelfB
	 */
	public Bookshelf getShelfB() {
		return shelfB;
	}
	/**
	 * This method returns the Bookshelf object shelfC
	 * 
	 * @return
	 * shelfC
	 */
	public Bookshelf getShelfC() {
		return shelfC;
	}
	/**
	 * This method returns the String Letter
	 * 
	 * @return
	 * Letter
	 */
	public String getLetter() {
		return Letter;
	}
	/**
	 * This method returns the String shelfLetter
	 * 
	 * @return
	 * shelfLetter
	 */
	public String getShelfLetter() {
		return shelfLetter;
	}
	/**
	 * This method prints out the slogan
	 */
	public static void printSlogan() {
		System.out.print("Welcome to Jack's aMAzin' Textbook Rentals, highest price guaranteed!");
	}
	/**
	 * This method prints out the menu/options the user has
	 */
	public static void printMenu() {
		System.out.print("\nmenu: ");
		System.out.print("\nA) Add Book");
		System.out.print("\nS) Swap Books");
		System.out.print("\nL) Loan Book");
		System.out.print("\nR) Remove Book");
		System.out.print("\nD) Duplicate Book");
		System.out.print("\nC) Change Shelf");
		System.out.print("\nO) Overwrite shelf with clone of current shelf");
		System.out.print("\nE) Check if two shelves are equal");
		System.out.print("\nP) Print current bookshelf");
		System.out.print("\nQ) Quit");
	}
	/**
	 * This method asks the user for an input, and sets the String Letter to the given input
	 */
	public void choice() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n	Please select an option: ");
		Letter = input.nextLine();
	}
	/**
	 * This method asks the user for the Book's title, author, condition and where to place the book on the Bookshelf
	 * This method then adds the Book object to the current Bookshelf object and prints out a statement
	 * 
	 * @throws IllegalArgumentException
	 * When the index given would create a hole in the Bookshelf object
	 * @throws FullShelfException
	 * When the Bookshelf is full
	 */
	public void addBook() throws IllegalArgumentException, FullShelfException {
		String title, author;
		int condition, index;
		Scanner input = new Scanner(System.in);
		System.out.println("\n	Please enter a title: ");
		title = input.nextLine();
		
		Scanner input2 = new Scanner(System.in);
		System.out.println("\n	Please enter an author: ");
		author = input2.nextLine();
		
		Scanner input3 = new Scanner(System.in);
		System.out.println("\n	Please enter a condition (1-5): ");
		condition = input3.nextInt();
		
		Scanner input4 = new Scanner(System.in);
		System.out.println("\n	Please enter position on shelf: ");
		index = input4.nextInt();
		
		Book temp = new Book(title, author, condition);
		if(shelfLetter.equals("A")) {
			shelfA.addBook(index, temp);
		}
		if(shelfLetter.equals("B")) {
			shelfB.addBook(index, temp);
		}
		if(shelfLetter.equals("C")) {
			shelfC.addBook(index, temp);
		}
		System.out.println("Book Added!");
		
	}
	/**
	 * This method asks the user for two index inputs
	 * This method then swaps the two Book objects within the current Bookshelf object
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 * When either of the index inputs are out of bounds of the bookshelf (<=0 or 20>)
	 */
	public void swapBooks() throws ArrayIndexOutOfBoundsException {
		int index1, index2;
		Scanner input = new Scanner(System.in);
		System.out.println("\n	Please enter the first book's spot: ");
		index1 = input.nextInt();
		
		Scanner input2 = new Scanner(System.in);
		System.out.println("\n	Please enter the seconds book's spot: ");
		index2 = input2.nextInt();
		
		if(shelfLetter.equals("A")) {
			shelfA.swapBooks(index1, index2);
			System.out.println(shelfA.getBook(index2).getTitle() + " has swapped with " + shelfA.getBook(index1).getTitle());
		}
		if(shelfLetter.equals("B")) {
			shelfB.swapBooks(index1, index2);
			System.out.println(shelfB.getBook(index2).getTitle() + " has swapped with " + shelfB.getBook(index1).getTitle());
		}
		if(shelfLetter.equals("C")) {
			shelfC.swapBooks(index1, index2);
			System.out.println(shelfC.getBook(index2).getTitle() + " has swapped with " + shelfC.getBook(index1).getTitle());
		}
	}
	/**
	 * This method asks the user for the index of the book, and a update on the condition and borrower
	 * This method then updates the qualities of the Book object
	 */
	public void loanBook() {
		int index1, condition;
		String borrower;
		Scanner input = new Scanner(System.in);
		System.out.println("\n	Please enter the spot of the book you would like to loan out: ");
		index1 = input.nextInt();
		
		Scanner input2 = new Scanner(System.in);
		System.out.println("\n	Please enter the name of the person loaning the book: ");
		borrower = input2.nextLine();
		
		Scanner input3 = new Scanner(System.in);
		System.out.println("\n	Please enter the condition of the book you're loaning out: ");
		condition = input3.nextInt();
		
		if(shelfLetter.equals("A")) {
			(shelfA.getBook(index1)).setBorrower(borrower);
			(shelfA.getBook(index1)).setCondition(condition);
			System.out.println(shelfA.getBook(index1).getTitle() + " has been loaned to " + borrower);
		}
		if(shelfLetter.equals("B")) {
			(shelfB.getBook(index1)).setBorrower(borrower);
			(shelfB.getBook(index1)).setCondition(condition);
			System.out.println(shelfB.getBook(index1).getTitle() + " has been loaned to " + borrower);
		}
		if(shelfLetter.equals("C")) {
			(shelfC.getBook(index1)).setBorrower(borrower);
			(shelfC.getBook(index1)).setCondition(condition);
			System.out.println(shelfC.getBook(index1).getTitle() + " has been loaned to " + borrower);
		}
	}
	/**
	 * This method asks the user for the index of the book they want to remove
	 * This method then removes the book
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 * When either of the index inputs are out of bounds (<=0 or 20>)
	 * @throws EmptyShelfException
	 * When the Bookshelf object is empty
	 */
	public void removeBook() throws ArrayIndexOutOfBoundsException, EmptyShelfException {
		int index1;
		Scanner input = new Scanner(System.in);
		System.out.println("\n	Please enter the spot of the book you would like to remove: ");
		index1 = input.nextInt();
		
		if(shelfLetter.equals("A")) {
			shelfA.removeBook(index1);
		}
		if(shelfLetter.equals("B")) {
			shelfB.removeBook(index1);
		}
		if(shelfLetter.equals("C")) {
			shelfC.removeBook(index1);
		}
	
	}
	/**
	 * This method duplicates an existing book and adds it to the Bookshelf object
	 * The method asks the user for the index of the book they would like to duplicate, and the index where they want to put the duplicate
	 * 
	 * @throws IllegalArgumentException
	 * When the index of where the duplicate is going creates a hole in the Bookshelf object
	 * @throws FullShelfException
	 * When the Bookshelf object is full
	 * @throws ArrayIndexOutOfBoundsException
	 * When the index of the book they are trying to duplicate is out of bounds (<=0 or 20>)
	 */
	public void duplicateBook() throws IllegalArgumentException, FullShelfException, ArrayIndexOutOfBoundsException {
		int indexC, indexI;
		Book temp;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the book you would like to copy (spot #): ");
		indexC = input.nextInt();
		
		Scanner input2 = new Scanner(System.in);
		System.out.println("Please enter the spot you would like to put the copy of the book: ");
		indexI = input.nextInt();
		
		if(shelfLetter.equals("A")) {
			temp = shelfA.getBook(indexC).clone();
			shelfA.addBook(indexI, temp);
			System.out.println("A new copy of " + shelfA.getBook(indexC).getTitle() + " is in index " + indexI);
		}
		if(shelfLetter.equals("B")) {
			temp = shelfB.getBook(indexC).clone();
			shelfB.addBook(indexI, temp);
			System.out.println("A new copy of " + shelfB.getBook(indexC).getTitle() + " is in index " + indexI);
		}
		if(shelfLetter.equals("C")) {
			temp = shelfC.getBook(indexC).clone();
			shelfC.addBook(indexI, temp);
			System.out.println("A new copy of " + shelfC.getBook(indexC).getTitle() + " is in index " + indexI);
		}
	}
	/**
	 * This method asks which Bookshelf the user would like to change to
	 * This method changes the Bookshelf object in which the user makes changes to (shelfA, shelfB, shelfC)
	 */
	public void changeShelf() {
		String tempLetter;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter which bookshelf you would like to access (a,b,c): ");
		tempLetter = input.nextLine();
		
		if(tempLetter.equals("A") || tempLetter.equals("a")) {
			this.shelfLetter = "A";
			System.out.println("Shelf A selected");
		}
		if(tempLetter.equals("B") || tempLetter.equals("b")) {
			this.shelfLetter = "B";
			System.out.println("Shelf B selected");
		}
		if(tempLetter.equals("C") || tempLetter.equals("c")) {
			this.shelfLetter = "C";
			System.out.println("Shelf C selected");
		}
	}
	/*
	 * This method asks the user which Bookshelf object they would like to overwrite
	 * This method overwrites a Bookshelf object with the current Bookshelf object
	 */
	public void overwrite() {
		Bookshelf temp;
		String tempLetter;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter which bookshelf you would like to overwrite with current bookshelf: ");
		tempLetter = input.nextLine();
		
		if(tempLetter.equals("A") || tempLetter.equals("a")) {
			if(shelfLetter.equals("B")) {
				temp = shelfB.clone();
				shelfA = temp;
				System.out.println("Shelf " + tempLetter + " overwritten with a copy of Shelf " + shelfLetter);
			}
			if(shelfLetter.equals("C")) {
				temp = shelfC.clone();
				shelfA = temp;
				System.out.println("Shelf " + tempLetter + " overwritten with a copy of Shelf " + shelfLetter);
			}
		}
		if(tempLetter.equals("B") || tempLetter.equals("b")) {
			if(shelfLetter.equals("A")) {
				temp = shelfA.clone();
				shelfB = temp;
				System.out.println("Shelf " + tempLetter + " overwritten with a copy of Shelf " + shelfLetter);
			}
			if(shelfLetter.equals("C")) {
				temp = shelfC.clone();
				shelfB = temp;
				System.out.println("Shelf " + tempLetter + " overwritten with a copy of Shelf " + shelfLetter);
			}
		}
		if(tempLetter.equals("C") || tempLetter.equals("c")) {
			if(shelfLetter.equals("A")) {
				temp = shelfA.clone();
				shelfC = temp;
				System.out.println("Shelf " + tempLetter + " overwritten with a copy of Shelf " + shelfLetter);
			}
			if(shelfLetter.equals("B")) {
				temp = shelfB.clone();
				shelfC = temp;
				System.out.println("Shelf " + tempLetter + " overwritten with a copy of Shelf " + shelfLetter);
			}
		}

	}
	/**
	 * This method asks the user which two Bookshelf objects they would like to check for equality
	 * This method checks if the two Bookshelf objects are equal and prints out the result (not equal or equal)
	 */
	public void equality() {
		String tempLetter,secondtemp;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter first bookshelf you would like to compare (a,b,c): ");
		tempLetter = input.nextLine();
		
		if(tempLetter.equals("A") || tempLetter.equals("a")) {
			System.out.println("Please enter second bookshelf you would like to compare (a,b,c): ");
			secondtemp = input.nextLine();
			if(secondtemp.equals("B") || secondtemp.equals("b")) {
				if(shelfA.equals(shelfB)) {
					System.out.println("These shelves are equal");
				}
				else {
					System.out.println("These shelves are not equal");
				}
			}
			if(secondtemp.equals("C") || secondtemp.equals("c")) {
				if(shelfA.equals(shelfC)) {
					System.out.println("These shelves are equal");
				}
				else {
					System.out.println("These shelves are not equal");
				}
			}
		}
		if(tempLetter.equals("B") || tempLetter.equals("b")) {
			System.out.println("Please enter second bookshelf you would like to compare (a,b,c): ");
			secondtemp = input.nextLine();
			if(secondtemp.equals("A") || secondtemp.equals("a")) {
				if(shelfB.equals(shelfA)) {
					System.out.println("These shelves are equal");
				}
				else {
					System.out.println("These shelves are not equal");
				}
			}
			if(secondtemp.equals("C") || secondtemp.equals("c")) {
				if(shelfB.equals(shelfC)) {
					System.out.println("These shelves are equal");
				}
				else {
					System.out.println("These shelves are not equal");
				}
			}
		}
		if(tempLetter.equals("C") || tempLetter.equals("c")) {
			System.out.println("Please enter second bookshelf you would like to compare (a,b,c): ");
			secondtemp = input.nextLine();
			if(secondtemp.equals("A") || secondtemp.equals("a")) {
				if(shelfC.equals(shelfA)) {
					System.out.println("These shelves are equal");
				}
				else {
					System.out.println("These shelves are not equal");
				}
			}
			if(secondtemp.equals("B") || secondtemp.equals("b")) {
				if(shelfC.equals(shelfB)) {
					System.out.println("These shelves are equal");
				}
				else {
					System.out.println("These shelves are not equal");
				}
			}
		}
	}
	/**
	 * This method prints out all the information of the current Bookshelf object in a tabular form
	 */
	public void printBookshelf() {
		if(shelfLetter.equals("A")) {
			System.out.println("Bookshelf A: ");
		}
		if(shelfLetter.equals("B")) {
			System.out.println("Bookshelf B: ");
		}
		if(shelfLetter.equals("C")) {
			System.out.println("Bookshelf C: ");
		}
		String spot = "Spot";
		String title = "Title";
		String author = "Author";
		String cond = "Cond.";
		String bor = "Borrower";
		System.out.printf("%-6s",spot);
		System.out.printf("%-38s", title);
		System.out.printf("%-24s", author);
		System.out.printf("%-6s", cond);
		System.out.printf("%-9s", bor);
		System.out.print("\n--------------------------------------------------------------------------------------------");
		if(shelfLetter.equals("A")) {
			for (int i = 0; i<shelfA.getCount(); i++) {
				System.out.println("");
				System.out.printf("%-6d", i+1);
				System.out.printf("%-38s", shelfA.getBook(i+1).getTitle());
				System.out.printf("%-24s", shelfA.getBook(i+1).getAuthor());
				System.out.printf("%-6d", shelfA.getBook(i+1).getCondition());
				System.out.printf("%-9s", shelfA.getBook(i+1).getBorrower());
			}
		}
		if(shelfLetter.equals("B")) {
			for (int i = 0; i<shelfB.getCount(); i++) {
				System.out.println("");
				System.out.printf("%-6d", i+1);
				System.out.printf("%-38s", shelfB.getBook(i+1).getTitle());
				System.out.printf("%-24s", shelfB.getBook(i+1).getAuthor());
				System.out.printf("%-6d", shelfB.getBook(i+1).getCondition());
				System.out.printf("%-9s", shelfB.getBook(i+1).getBorrower());
			}
		}
		if(shelfLetter.equals("C")) {
			for (int i = 0; i<shelfC.getCount(); i++) {
				System.out.println("");
				System.out.printf("%-6d", i+1);
				System.out.printf("%-38s", shelfC.getBook(i+1).getTitle());
				System.out.printf("%-24s", shelfC.getBook(i+1).getAuthor());
				System.out.printf("%-6da", shelfC.getBook(i+1).getCondition());
				System.out.printf("%-9s", shelfC.getBook(i+1).getBorrower());
			}
		}
	}
}
