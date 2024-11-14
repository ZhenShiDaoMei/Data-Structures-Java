package jasonv2.IslandManager;

import java.util.HashMap;
import java.util.Scanner;
/**
 * This class represents the IslandDesigner object that contains a choice, network and url
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class IslandDesigner {
	
	private String choice;
	private IslandNetwork network;
	private String url;
	/**
	 * main method
	 * @param args
	 * 
	 * @throws Exception
	 * throws exceptions when things don't work
	 */
	public static void main (String[] args) throws Exception {
		IslandDesigner designer = new IslandDesigner();
		printSlogan();
		try {
			designer.askUrl();
			designer.printAll();
		}catch (Exception e) {
			System.out.print("\nurl could not be found.");
		}
		designer.printAll();
		//have a print statement that prints both the cities and the roads 
		printMenu();
		while(!designer.getChoice().equals("Q") && !designer.getChoice().equals("q")) {
			designer.selectChoice();
			if (designer.getChoice().equals("D") || designer.getChoice().equals("d")) {
				try {
					designer.askDsf();
				}catch (Exception e) {
					System.out.print("Invalid starting point.");
				}
			}
			if (designer.getChoice().equals("F") || designer.getChoice().equals("f")) {
				//procrastination really do be hitting different. Didn't have enough time to do this part xd			
			}
			if (designer.getChoice().equals("S") || designer.getChoice().equals("s")) {
				//didnt do the extra credit :(
			}
		}
	}
	
	/**
	 * This is the constructor for the IslandDesigner object
	 */
	public IslandDesigner() {
		choice = "";
		network = new IslandNetwork();
	}
	/**
	 * This method returns the network of the IslandDesigner object
	 * @return
	 * network
	 */
	public IslandNetwork getNetwork() {
		return network;
	}
	/**
	 * This method returns the choice of the IslandDesigner object
	 * @return
	 * choice
	 */
	public String getChoice() {
		return choice;
	}
	/**
	 * This method asks the user for an url input and loads it in as a IslandNetwork
	 * @throws Exception
	 * when the url is not valid
	 */
	public void askUrl() throws Exception{
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("\nPlease enter an url: ");
			url = input.nextLine();
		}
		network = IslandNetwork.LoadFromFile(url);
		System.out.print("\nMap loaded.");
	}
	/**
	 * This method prints the slogan
	 */
	public static void printSlogan() {
		System.out.print("Welcome to the Island Designer, because, when you're trying to stay above water, Seas get degrees!\n");
	}
	/**
	 * This method prints the menu
	 */
	public static void printMenu() {
		System.out.print("\nmenu: ");
		System.out.print("\n     D) Destinations Reachable (Depth First Search)");
		System.out.print("\n     F) Maximum Flow");
		System.out.print("\n     S) Shortest Path (extra credit)");
		System.out.print("\n     Q) Quit");
	}
	/**
	 * This method allows the user to continually input choices
	 */
	public void selectChoice() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("\nPlease select an option: ");
			choice = input.nextLine();
		}
	}
	/**
	 * This method prints the cities and the roads of the IslandNetwork
	 */
	public void printAll() {
		System.out.print("\nCities:");
		System.out.print("\n--------------------");
		for(HashMap.Entry<String,City>entry : network.getGraph().entrySet()) {
			String key = entry.getKey();
			System.out.printf("%-20s", network.getGraph().get(key).getName());
		}
		System.out.print("\nRoad                           Capacity");
		System.out.print("\n---------------------------------------");
		for(HashMap.Entry<String,City>entry : network.getGraph().entrySet()) {
			String key = entry.getKey();
			for(HashMap.Entry<String,Integer>road : network.getGraph().get(key).getNeighbors().entrySet()) {
				String name = road.getKey();
				int num = road.getValue();
				System.out.printf("%37s", "\n" + network.getGraph().get(key) + " to " + name);
				System.out.printf("%-2d", num);
			}
		}
	}
	/**
	 * This method prints out the destinations reachable
	 */
	public void askDsf() {
		String from;
		Scanner input = new Scanner(System.in);
		System.out.print("\nPlease enter a starting city: ");
		from = input.nextLine();
		
		network.print(network.dfs(from));
	}
}
