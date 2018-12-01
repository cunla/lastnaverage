package org.dsoftware.paytm;

public class LastNumbersAverageImpl implements LastNumbersAverage {
    private double lastNumbers[]; // The last N numbers
    private int nextPosition = 0; // This holds the position of the next number to be added, circular
    private int totalNumbers = 0; // number of elements
    private double average = 0; // current average

    /**
     * Create an instance of last n numbers average calculator
     * This implementation is not blocking -
     * consider adding synchronized to addNumber method if adding numbers from multiple threads
     *
     * @param n The number of last numbers to calculate average for
     */
    public LastNumbersAverageImpl(final int n) {
        lastNumbers = new double[n];
    }

    public int getTotalNumbers() {
        return totalNumbers;
    }

    public void addNumber(final double num) {
        double sum = totalNumbers * average;
        // if reached N numbers, deduct oldest number in array
        // else, increase totalNumbers of elements in array
        if (totalNumbers == lastNumbers.length) {
            sum -= lastNumbers[nextPosition];
        } else {
            ++totalNumbers;
        }
        lastNumbers[nextPosition] = num;
        nextPosition = (nextPosition + 1) % lastNumbers.length;
        sum += num;
        average = sum / totalNumbers;
    }

    public void addNumbers(double... nums) {
        for (final double num : nums) {
            addNumber(num);
        }
    }

    public double getAverage() {
        return average;
    }
}
