package jasonv2.StormSimulator;
import java.io.Serializable;
/**
 * This class represents a storm object that contains a name, precipitation value, windspeed, and date of occurrence.
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */

public class Storm implements Serializable{

	private String name;
	private double precipitation;
	private double windspeed;
	private String Date;
	
	/**
	 * This is the constructor of the Storm object, where it takes parameters and makes a Storm object
	 * @param name
	 * name of the storm
	 * @param precipitation
	 * amount of precipitation
	 * @param windspeed
	 * the wind speed of storm
	 * @param date
	 * the date of occurrence for storm
	 */
	public Storm(String name, double precipitation, double windspeed, String date) {
		this.name = name;
		this.precipitation = precipitation;
		this.windspeed = windspeed;
		this.Date = date;
	}
	
	/**
	 * This is a method that returns the name of the Storm object
	 * 
	 * @return
	 * name
	 */
	public String getName() {
		return name;}
	/**
	 * This is a method that returns the precipitation of the Storm object
	 * 
	 * @return
	 * precipitation
	 */
	public double getPrecipitation() {
		return precipitation;}
	/**
	 * This is the method that returns the windspeed of the Storm object
	 * 
	 * @return
	 * windspeed
	 */
	public double getWindspeed() {
		return windspeed;}
	/**
	 * This is the method that returns the Date of the Storm object
	 * 
	 * @return
	 * Date
	 */
	public String getDate() {
		return Date;}
	/**
	 * This is the method that modifies the name of the Storm object
	 * 
	 * @param name
	 * new name of Storm object
	 */
	public void setName(String name) {
		this.name = name;}
	/**
	 * This is the method that modifies the precipitation of the Storm object
	 * 
	 * @param amount
	 * new precipitation of Storm object
	 */
	public void setPrecipitation(double amount) {
		precipitation = amount;}
	/**
	 * This is the method that modifies the windspeed of the Storm object
	 * 
	 * @param speed
	 * new windspeed of Storm object
	 */
	public void setWindspeed(double speed) {
		windspeed = speed;}
	/**
	 * This is the method that modifies the date of the Storm object. Before the date is accepted, it is tested to see if it matches the correct date format
	 * 
	 * @param date
	 * new date of Storm object
	 */
	public void setDate(String date) {
		if (date.matches("\\d{4}-\\d{2}-\\d{2}") || date.matches("\\d{4}-\\d{1}-\\d{2}") || date.matches("\\d{4}-\\d{1}-\\d{1}") || date.matches("\\d{4}-\\d{2}-\\d{1}")) {
			Date = date;
		}else {
			System.out.print("\nInvalid date format");
		}
	}
	/**
	 * This is the method that returns the Storm in a String format that is printable
	 * 
	 * @return
	 * Printable String of storm
	 */
	public String toString() {
		return "Storm " + name + ": Date = " + Date + ", windspeed = " + windspeed + " km/h winds, rainfall = " + precipitation + " cm of rain";
	}
	
}
