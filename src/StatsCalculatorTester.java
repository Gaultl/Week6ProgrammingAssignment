public class StatsCalculatorTester {
    public static void main(String[] args) {
        double[ ] data = {10.0, 20.0, 5.0, 15.0, 25.0, 30.0, 8.0};
        //create a StatsCalculator object
        StatsCalculator myCalculator = new StatsCalculator(data);

        System.out.println(myCalculator.calculateFirstQuartile());
        /*myCalculator.print();
        myCalculator.sortData();
        myCalculator.printSorted();
        myCalculator.printFiveNumberSummary();
        System.out.println("The mean is " + myCalculator.calculateMean());*/

    }
}