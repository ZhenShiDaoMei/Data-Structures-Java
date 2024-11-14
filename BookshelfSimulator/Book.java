package jasonv2.BookshelfSimulator;
/**
 * This class represents a book which has a title, author, condition and borrower
 * 
 * @author Jason Wu, 114474379, R04 recitation
 */
public class Book {
	private String title;
	private String author;
	private String borrower;
	private int condition;
	/**
	 * This method returns the title of the Book object	
	 * 
	 * @return
	 * The title of the book
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * This method returns the author of the Book object
	 * 
	 * @return
	 * The author of the book
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * This method returns the borrower of the Book object
	 * 
	 * @return
	 * The borrower of the book
	 */
	public String getBorrower() {
		return borrower;
	}
	/**
	 * This method returns the condition of the Book object
	 * 
	 * @return
	 * The condition of the book
	 */
	public int getCondition() {
		return condition;
	}
	/**
	 * This method modifies the title of the Book object
	 * 
	 * @param title
	 * new title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * This method modifies the author of the Book object
	 * 
	 * @param author
	 * new author of the book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * This method modifies the borrower of the Book object
	 * 
	 * @param borrower
	 * new borrower of the book
	 */
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	/**
	 * This method modifies the condition of the Book object
	 * 
	 * @param condition
	 * new condition of book
	 */
	public void setCondition(int condition) {
		this.condition = condition;
	}
	/**
	 * This is a constructor used to create a new Book object
	 * 
	 * @param title
	 * The title of the book
	 * @param author
	 * The author of the book
	 * @param condition
	 * the condition of the book
	 */
	public Book(String title, String author, int condition) {
	this.title = title;
	this.author = author;
	this.condition = condition;
	this.borrower = "";
	}
	/**
	 * This method compares a Book to an object, if the object is that of a Book class
	 * 
	 * @param o
	 * The object
	 * 
	 * @return
	 * If all qualities are the same, returns true
	 * If not, returns false
	 */
	public boolean equals(Object o) {
		if(o instanceof Book) 
			return title.equals(((Book)o).title) && author.equals(((Book)o).author) && condition == (((Book)o).condition);
		return false;
	}
	/**
	 * This method creates a clone of a Book object
	 * 
	 * @return
	 * Clone of the Book object
	 */
	public Book clone() {
		Book cloneB = new Book(title, author, condition);
		return cloneB;
	}
	/**
	 * This method turns the Book object and its qualities/information into a printable String
	 * 
	 * @return
	 * A string of the Book object	
	 */
	public String toString() {
		return "Title: " + title + "   Author: " + author + "   Condition: " + condition + "   Borrower: " + borrower;
	}
}
