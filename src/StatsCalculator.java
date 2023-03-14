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

    /**
     * Calculates the maximum value present in the array
     *
     * @return The maximum value
     */
    public double calculateMax(){
        double max = values[0];
        for(double num : values){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    /**
     * Calculates the minimum value present in the array
     *
     * @return The minimum value
     */
    public double calculateMin(){
        double min = values[0];
        for(double num : values){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    /**
     * Calculates the median of the sorted array
     *
     * @return The median value
     */
    public double calculateMedian(){
        double median = -1;
        if(sortedValues.length % 2 == 0){
            median = (sortedValues[sortedValues.length / 2] + sortedValues[sortedValues.length / 2 - 1]) / 2.0;
        } else {
            median = sortedValues[sortedValues.length/2];
        }
        return median;
    }

    /**
     * Private method used to calculate the quartiles
     *
     * @param half An array consisting of the first or second half of the sorted array
     * @return returns the median of 'half', which is the desired quartile
     */
    private double calculateQuartile(double[] half){
        double quartile = -1;
        if(half.length % 2 == 0){
            quartile = (half[half.length / 2] + half[half.length / 2 - 1]) / 2.0;
        } else {
            quartile = half[half.length/2];
        }
        return quartile;
    }

    /**
     * Calculates the first quartile of the sorted array
     *
     * @return The first quartile of the data set
     */
    public double calculateFirstQuartile(){
        double[] firstHalf = new double[sortedValues.length / 2 - 1];
            for(int i = 0; i < firstHalf.length; i++){
                firstHalf[i] = sortedValues[i];
            }
            return calculateQuartile(firstHalf);
    }


    public double calculateThirdQuartile(){
        double[] secondHalf = new double[sortedValues.length / 2 - 1];
        for(int i = 0; i < secondHalf.length; i++){
            secondHalf[i] = sortedValues[i];
        }
        return calculateQuartile(secondHalf);
    }
}
