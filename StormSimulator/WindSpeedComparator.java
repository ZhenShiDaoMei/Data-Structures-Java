package jasonv2.StormSimulator;
import java.util.Comparator;
/**
 * This class represents a WindSpeedComparator that compares the windspeed values of the Storm object
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class WindSpeedComparator implements Comparator<Storm>{
    /**
     * This is a method that compares the windspeed values of 2 Storm object. The method returns -1 if the left is bigger, 0 if they are the same, and 1 if the right is larger
     */
	public int compare(Storm left, Storm right) {
		Storm s1 = left;
		Storm s2 = right;
		if(s1.getWindspeed() == s2.getWindspeed()) {
			return 0;
		}else if (s1.getWindspeed() < s2.getWindspeed()){
			return -1;
		}else {
			return 1;
		}
	}
}
