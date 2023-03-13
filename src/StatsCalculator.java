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
     * Default constructor that creates a StatsCalculator object with an array of 20 zeros
     */
    public StatsCalculator(){
        values = new double[20];
        sortedValues = new double[20];
        Arrays.sort(sortedValues);
    }

    /**
     * Constructor that creates a StatsCalculator object with a user defined array
     *
     * @param userValues The array input by the user
     */
    public StatsCalculator(double[] userValues){
        values = userValues;
        sortedValues = userValues;
        Arrays.sort(sortedValues);
    }

    /**
     * Sorts the values given by the user in increasing order
     */
    public void sortData(){
        Arrays.sort(sortedValues);
    }

    public double calculateMax(){
        double max = values[0];
        for(double num : values){
            if(num > max){
                max = num;
            }
        }
        return max;
    }
}
