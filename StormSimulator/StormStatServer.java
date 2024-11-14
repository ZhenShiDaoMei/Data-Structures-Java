package jasonv2.StormSimulator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;	
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/**
 * This class represents a StormStatServer object that contains a hashmap of string and Storm objects and a choice String.
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class StormStatServer implements Serializable{

	private HashMap<String, Storm> database;
	private String choice;
	/**
	 * This is the constructor for the StormStatServer object that creates a empty hashmap and sets the choice String to nothing
	 */
	public StormStatServer() {
		database = new HashMap<String, Storm>();
		choice = "";
	}
	/**
	 * This is another constructor for the StormSstatServer object that takes a hashmap with values and sets it's own hashmap to the new hashmaps values
	 * Still sets the choice String to nothing
	 * 
	 * @param value
	 * hashmap with String and Storm object values
	 */
	public StormStatServer(HashMap<String,Storm> value) {
		database = value;
		choice = "";
	}
	/**
	 * This method returns the choice of the StormStatServer
	 * 
	 * @return
	 * choice
	 */
	public String getChoice() {
		return choice;}
	/**
	 * This method modifies the choice of the StormStatServer
	 * 
	 * @param choice
	 * new choice
	 */
	public void setChoice(String choice) {
		this.choice = choice;}
	/**
	 * This method returns the database of the StormStatServer
	 * 
	 * @return
	 * database
	 */
	public HashMap<String,Storm> getDatabase(){
		return database;
	}
	/**
	 * This is the main method of the class
	 * The main method consists of a while loop that constantly asks for user input until the user chooses option q (stops the while loop)
	 * During the while loop, the user is able to do all types of commands such as adding, editing, removing, printing, and etc.
	 * 
	 * @param args
	 * 
	 * @throws Exception
	 * Throws many types of exceptions
	 * Throws a regular Exception when an option fails and tells the user
	 * Throws NumberFormatException when the program fails to turn a String into a Double
	 * Throws a FileNotFoundException and IOException when there is problems with finding and loading files
	 */
	public static void main (String[] args) throws Exception {
		StormStatServer server = new StormStatServer();
		server.printSlogan();
		try {
			server.initializeSaved();
			System.out.print("\nsaveserver.obj was found and loaded.");
		}catch (Exception e) {
			System.out.print("\n\nNo previous data found.");
		}
		server.printMenu();
		while(!server.getChoice().equals("Q") && !server.getChoice().equals("q")) {
			server.selectChoice();
			if (server.getChoice().equals("A") || server.getChoice().equals("a")) {
				try {
					server.addStorm();
				}catch (Exception e) {
					System.out.print("Values are Invalid for adding a Storm");
				}
			}
			if (server.getChoice().equals("L") || server.getChoice().equals("l")) {
				server.lookStorm();
			}
			if (server.getChoice().equals("D") || server.getChoice().equals("d")) {
				server.removeStorm();
			}
			if (server.getChoice().equals("E") || server.getChoice().equals("e")) {
				try {
					server.editStorm();
				}catch (Exception e){
					System.out.print("\nKey not found.");
				}
			}
			if (server.getChoice().equals("R") || server.getChoice().equals("r")) {
				server.printByRain();
			}
			if (server.getChoice().equals("W") || server.getChoice().equals("w")) {
				server.printByWind();
			}
			if (server.getChoice().equals("X") || server.getChoice().equals("x")) {
				try {
					server.saveAndQuit();
					System.out.print("File saved to hurricane.ser; feel free to use the weather channel in the meantime.");
				}catch (Exception e) {
					System.out.print("File could not be saved/there was an error.");
				}
				return;
			}
			if (server.getChoice().equals("Q") || server.getChoice().equals("q")) {
				server.saveAndQuit();
				System.out.print("\nGoodbye, it's hard to hold an (electric) candle in the cold November (and April!) rain!.");
				//remove saved files
			}
		}
	}
	/**
	 * This method prints out the slogan for the user
	 */
	public void printSlogan() {
		System.out.print("Welcome to the StormStatServer, we may not be able to make it rain, but we sure can tell you when it happened!");
	}
	/**
	 * This method prints out the menu for the user 
	 */
	public void printMenu() {
		System.out.print("\n\nmenu: ");
		System.out.print("\n     A) Add a Storm");	
		System.out.print("\n     L) Look Up a Storm");
		System.out.print("\n     D) Delete a Storm");
		System.out.print("\n     E) Edit Storm Data");
		System.out.print("\n     R) Print Storms Sorted by Rainfall");
		System.out.print("\n     W) Print Storms Sorted by Windspeed");
		System.out.print("\n     X) Save and Quit");
		System.out.println("\n     Q) Quit and Delete Data");
	}
	/**
	 * This method asks the user to choose one of the options on the printed menu
	 */
	public void selectChoice() {
		Scanner input = new Scanner(System.in);
		System.out.print("\nPlease select an option: ");
		choice = input.nextLine();
	}
	/**
	 * This method adds a Storm object to the database hashmap
	 */
	public void addStorm() {
		String name, date;
		Double rain, wind;
		Scanner newname = new Scanner(System.in);
		System.out.print("\nPlease enter name: ");
		name = newname.nextLine();
		
		Scanner newdate = new Scanner(System.in);
		System.out.print("\nPlease enter date (formatted YYYY-MM-DD): ");
		date = newdate.nextLine();
		
		Scanner newrain = new Scanner(System.in);
		System.out.print("\nPlease enter precipitation (cm): ");
		rain = newrain.nextDouble();
		
		Scanner newwind = new Scanner(System.in);
		System.out.print("\nPlease enter Windspeed (km/h): ");
		wind = newwind.nextDouble();
		
		Storm temp = new Storm(name, rain, wind, date);
		database.put(temp.getName(), temp);
		System.out.print("\n" +name + " added.");
	}
	/**
	 * This method looks up a Storm object for the user and prints out the information
	 * 
	 * @throws Exception
	 * When the Storm object does not exist and has no information to be printed
	 */
	public void lookStorm() throws Exception{
		String name;
		Scanner lookingname = new Scanner(System.in);
		System.out.print("\nPlease enter name: ");
		name = lookingname.nextLine();
		try {
			System.out.print("\n" + database.get(name).toString());
		}catch (Exception e) {
			System.out.print("Key not found.");
		}
	}
	/**
	 * This method looks up a Storm object and removes it from the database hashmap
	 * 
	 * @throws Exception
	 * When the Storm object does not exist
	 */
	public void removeStorm() throws Exception{
		String name;
		Scanner removingname = new Scanner(System.in);
		System.out.print("\nPlease enter name: ");
		name = removingname.nextLine();
		try {
			String stormname = database.get(name).getName();
			database.remove(name);
			System.out.print("\nStorm" + name + " has been deleted.");
		}catch (Exception e) {
			System.out.print("\nStorm" + name + " does not exist.");
		}
	}
	/**
	 * This method edits a Storm object within the database hashmap
	 * 
	 * @throws Exception
	 * The Storm object cannot be found within the database
	 * @throws NumberFormatException
	 * When the user inputs non-numbers when asked for numbers
	 */
	public void editStorm() throws Exception, NumberFormatException{
		String name, date, anyrain, anywind;
		Double rain, wind;
		Storm temp;
		Scanner lookingname = new Scanner(System.in);
		System.out.print("\nPlease enter name: ");
		name = lookingname.nextLine();
			if(database.get(name) == null) {;
			throw new Exception();
			}
			temp = database.get(name);
			database.remove(name);
			System.out.print("\nIn Edit Mode, press enter without any input to leave data unchanged.");
			
			Scanner newdate = new Scanner (System.in);
			System.out.print("\nPlease enter date: ");
			date = newdate.nextLine();
			if(date != null) {
				try {
					temp.setDate(date);
				}catch (Exception e) {
					System.out.print("Invalid date format.");
				}
			}
			
			Scanner newrain = new Scanner (System.in);
			System.out.print("\nPlease enter precipitation (cm): ");
			anyrain = newrain.nextLine();
			if(!anyrain.equals("") && !anyrain.equals(null)) {
				try {
					rain = Double.parseDouble(anyrain);
					temp.setPrecipitation(rain);
				}catch (NumberFormatException e) {
					System.out.print("the input is not a number");
				}
			}
			
			Scanner newWind = new Scanner (System.in);
			System.out.print("\nPlease enter windspeed (km/h): ");
			anywind = newWind.nextLine();
			if(!anywind.equals("") && !anywind.equals(null)) {
				try {
					wind = Double.parseDouble(anywind);
					temp.setWindspeed(wind);
				}catch (NumberFormatException e) {
					System.out.print("the input is not a number");
				}
			}
			
			database.put(name, temp);
			System.out.print(name + " added.");
	}
	/**
	 * This method sorts the database hashmap by precipitation and prints it out sorted
	 */
	public void printByRain() {
		List<Storm> list = new ArrayList<Storm>(database.values());
		Collections.sort(list,new PrecipitationComparator());
		System.out.printf("%-25s","\nName");
		System.out.printf("%-15s", "Windspeed");
		System.out.printf("%-13s", "Rainfall");
		System.out.printf("%-8s", "Date");
		System.out.print("\n----------------------------------------------------------------");
		list.forEach(s->{
			System.out.printf("%-20s", "\n"+ s.getName());
			System.out.printf("%11s", s.getWindspeed());
			System.out.printf("%14s", s.getPrecipitation());
			System.out.print("        ");
			System.out.printf("%-11s", s.getDate()	);
		});
	}
	/**
	 * This method sorts the database hashmap by windspeed and prints it out sorted
	 */
	public void printByWind() {
		List<Storm> list = new ArrayList<Storm>(database.values());
		Collections.sort(list,new WindSpeedComparator());
		System.out.printf("%-25s","\nName");
		System.out.printf("%-15s", "Windspeed");
		System.out.printf("%-13s", "Rainfall");
		System.out.printf("%-8s", "Date");
		System.out.print("\n----------------------------------------------------------------");
		list.forEach(s->{
			System.out.printf("%-20s", "\n"+ s.getName());
			System.out.printf("%11s", s.getWindspeed());
			System.out.printf("%14s", s.getPrecipitation());
			System.out.print("        ");
			System.out.printf("%-11s", s.getDate()	);
		});
	}
	/**
	 * This method saves the information within the StormStatServer (current session) for later use
	 * 
	 * @throws FileNotFoundException
	 * File cannot be found
	 * @throws IOException
	 * file problems
	 */
	public void saveAndQuit() throws FileNotFoundException, IOException {
		StormStatServer saveserver;
		if(choice.equals("Q") || choice.equals("q")) {
			saveserver = new StormStatServer();
		}else {
			saveserver = new StormStatServer(database);
		}
		FileOutputStream file = new FileOutputStream("saveserver.obj");
		ObjectOutputStream outStream = new ObjectOutputStream(file);
		outStream.writeObject(saveserver);
		outStream.close();
	}
	/**
	 * This method updates the StormStatServer object with the saved information from a previous session
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void initializeSaved() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream("saveserver.obj");
		ObjectInputStream inStream = new ObjectInputStream(file);
		StormStatServer saveserver;
		saveserver = (StormStatServer) inStream.readObject();
		this.database = saveserver.getDatabase();
		inStream.close();
	}
	
}
