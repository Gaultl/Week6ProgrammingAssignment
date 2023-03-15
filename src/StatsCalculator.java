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

    private double[] outliers;

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
        sortedValues = Arrays.copyOf(userValues, userValues.length);
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
        double[] firstHalf = new double[sortedValues.length / 2];
            for(int i = 0; i < firstHalf.length; i++){
                firstHalf[i] = sortedValues[i];
            }
            return calculateQuartile(firstHalf);
    }

    /**
     * Calculates the third quartile of the sorted array
     *
     * @return The third quartile of the data set
     */
    public double calculateThirdQuartile(){
        double[] secondHalf = new double[sortedValues.length / 2];

        int length = sortedValues.length / 2;

        if(sortedValues.length % 2 == 1){
            length++;
        }

        int secondHalfIndex = 0;

        for(int i = length; i < sortedValues.length; i++){
            secondHalf[secondHalfIndex] = sortedValues[i];
            secondHalfIndex++;
        }
        return calculateQuartile(secondHalf);
    }

    /**
     * Calculates the sum of all the values in the data set
     *
     * @return The sum of all values in the data set
     */
    public double calculateSum(){
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }

    /**
     * Calculates the mean of the data set
     *
     * @return The median of the data set
     */
    public double calculateMean(){
        return calculateSum()/values.length;
    }

    /**
     * Finds any outliers in the data set
     */
    public void findOutliers(){
        double interQuartileRange = calculateThirdQuartile() - calculateFirstQuartile();
        double upperLimit = calculateThirdQuartile() + (1.5 * interQuartileRange);
        double lowerLimit = calculateFirstQuartile() - (1.5 * interQuartileRange);

        int numOutliers = 0;

        for(double value : values){
            if(value > upperLimit || value < lowerLimit){
                numOutliers++;
            }
        }

        outliers = new double[numOutliers];
        int outlierIndex = 0;

        for(int i = 0; i < values.length; i++){
            if(values[i] > upperLimit || values[i] < lowerLimit){
                outliers[outlierIndex] = values[i];
                outlierIndex++;
            }
        }
    }

    /**
     * Prints the data set as entered
     */
    public void print(){
        System.out.println("\nYour data is: ");
        for(double value : values){
            System.out.print(value + " ");
        }
    }

    /**
     * Prints the sorted data set
     */
    public void printSorted(){
        System.out.println("\nYour sorted data is: ");
        for(double value : sortedValues){
            System.out.print(value + " ");
        }
    }

    public void printFiveNumberSummary(){
        System.out.println("\nThe five number summary is:");
        System.out.println("\tMinimum: " + calculateMin());
        System.out.println("\tFirst Quartile: " + calculateFirstQuartile());
        System.out.println("\tMedian: " + calculateMedian());
        System.out.println("\tThird Quartile: " + calculateThirdQuartile());
        System.out.println("\tMaximum: " + calculateMax());
        System.out.println("The outliers are: ");
        findOutliers();
        for(double outlier : outliers){
            System.out.print(outlier + " ");
        }
        System.out.println();
    }
}
