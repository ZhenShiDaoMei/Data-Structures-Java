package jasonv2.StormSimulator;
import java.util.Comparator;
/**
 * This class represents a PrecipitationComparator that compares the precipitation values of 2 Storm objects
 * 
 * @author Jason Wu, 114474379, R04 recitation
 *
 */
public class PrecipitationComparator implements Comparator<Storm>{
    /**
     * This is a method that compares the precipitation values of 2 Storm object. The method returns -1 if the left is bigger, 0 if they are the same, and 1 if the right is larger
     */
	public int compare(Storm left, Storm right) {
		Storm s1 = left;
		Storm s2 = right;
		if(s1.getPrecipitation() == s2.getPrecipitation()) {
			return 0;
		}else if (s1.getPrecipitation() < s2.getPrecipitation()){
			return -1;
		}else {
			return 1;
		}
	}
}
