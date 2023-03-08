import java.util.Arrays;

/**
 * @author Lauren Gault
 *
 * A class to find the five number summary, average, sum, and outliers of an array
 */
public class StatsCalculator {

    //instance variables
    private double[] values;
    private double[] sortedValues;

    /**
     * Default constructor that creates an array of 20 zeros
     */
    public StatsCalculator(){
        values = new double[20];
        sortedValues = new double[20];
        Arrays.sort(sortedValues);
    }

    public StatsCalculator(double[] userValues){
        values = userValues;
        sortedValues = userValues;
        Arrays.sort(sortedValues);
    }






}
