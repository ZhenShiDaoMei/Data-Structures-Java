package jasonv2.BookshelfSimulator;

/**
 * This class represents a Bookshelf which has an array with a length of 20 that contains Book objects, and a count
 * 
 * @author Jason Wu, 114474379, R04 recitation
 */
public class Bookshelf {
	private Book[] books;
	private int count;
	final int Capacity = 20;
	/**
	 * This is a constructor used to create a new Bookshelf object
	 */
	public Bookshelf() {
		this.books = new Book[Capacity];
		this.count = 0;
	}
	/**
	 * This method returns the count of the Bookshelf object
	 * 
	 * @return
	 * The count of the Bookshelf object
	 */
	public int getCount() {
		return count;
	}
	/*Serves the same purpose of getCount(), but I accidentally wrote all my code with the 
	 * getCount() method instead of numBooks(), even though the numBooks() method is the required one.
	 */
	public int numBooks() {	
		return count;
	}
	/**
	 * This method returns the Book object within the Bookshelf object at a certain index
	 * 
	 * @param index
	 * The Book object's index/position
	 * 
	 * @return
	 * The Book object at the index
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 * When the index is out of Range (0 and below or above 20)
	 */
	public Book getBook(int index) throws ArrayIndexOutOfBoundsException {
		if((index-1) <0 || (index-1)>19) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return books[index-1];
	}
	/**
	 * This method removes a Book object within the Bookshelf object at a certain index
	 * 
	 * @param index
	 * The Book object's index/position
	 * 
	 * @return
	 * The information of the Book object that was removed
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 * When the index is out of Range (0 and below or above 20)
	 * @throws EmptyShelfException
	 * When the Bookshelf object is already empty and has nothing to be removed (count is 0)
	 */
	public Book removeBook(int index) throws ArrayIndexOutOfBoundsException, EmptyShelfException {
		if (count == 0) {
			throw new EmptyShelfException();
		}
		if((index-1) <0 || (index-1)>19) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Book temp = books[index-1];
		for(int i =0; i<count; i++) {
			books[i] = books[i+1];
		}
		books[count] = null;
		this.count -= 1;
		return temp;
	}	
	/**
	 * This method adds a Book object within the Bookshelf object at a certain index
	 * 
	 * @param index
	 * Index/position where the Book object should be added
	 * @param book
	 * The Book object to be added
	 * 
	 * @throws IllegalArgumentException
	 * When the user tries to skip an index and leaves a hole in the bookshelf
	 * @throws FullShelfException
	 * When the bookshelf is full and can no longer add more Book objects
	 */
	public void addBook(int index, Book book) throws IllegalArgumentException, FullShelfException {
		if (count == 20) {
			throw new FullShelfException();
		}
		if (index-1 > count) {
			throw new IllegalArgumentException();
		}
		for (int i = count; i >= index; i--) {
			books[i] = books[i-1];
		}
		books[index -1] = book;
		this.count += 1;
	}
	/**
	 * This method swaps two Book objects that are already within the Bookshelf object
	 * 
	 * @param index1
	 * The index/position of the first Book object
	 * @param index2
	 * The index/position of the second Book object
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 * When either of the index inputs are out of bounds of the bookshelf (0 and below or above 20)
	 */
	public void swapBooks(int index1, int index2) throws ArrayIndexOutOfBoundsException{
		if (((index1-1) < 0 || (index1-1) > 19) || ((index2-1) < 0 || (index2-1) >19)) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Book temp = books[index1-1];
		books[index1-1] = books[index2-1];
		books[index2-1] = temp;
	}
	/**
	 * This method makes a clone of the Bookshelf object
	 * 
	 * @return
	 * Clone of the Bookshelf object
	 */
	public Bookshelf clone() {
		Bookshelf cloneshelf = new Bookshelf();
		for (int i = 0; i< count; i++) {
			try {
				cloneshelf.addBook(i+1, books[i].clone());
			} catch (IllegalArgumentException | FullShelfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cloneshelf;
	}
	/**
	 * This method compares the Bookshelf object to another object, if the object is that of a Bookshelf class
	 * 
	 * @param o
	 * The object
	 * 
	 * @return
	 * If all qualities are the same, returns true
	 * If not, returns false
	 */
	public boolean equals(Object o) {
		if(o instanceof Bookshelf) {
			if(count != (((Bookshelf)o).count))
				return false;
			for (int i = 0; i<count+1; i++) {
				if(!books[i].equals(((Bookshelf)o).getBook(i+1)))
					return false;		
			}
			return true;
		}
		return false;
	}
	/**
	 * This method turns the Bookshelf object and its qualities into a printable String
	 * 
	 * @return
	 * A String of the Bookshelf object
	 */
	public String toString() {
		String print = "";
		for (int i= 0; i < count; i++) {
			print += "\n" + books[i].toString();
		}
		return print;
	}
	public static void main(String[] args) {
	}
}
