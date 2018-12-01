package org.dsoftware.paytm;

public interface LastNumbersAverage {

    /**
     * Get number of elements in data structure
     *
     * @return number of elements in data-structure
     */
    int getTotalNumbers();

    /**
     * Add a single number to the data-strucrure
     *
     * @param num the number to add
     */
    void addNumber(double num);

    /**
     * Add multiple numbers to the data-structure
     *
     * @param nums the numbers to add
     */
    void addNumbers(double... nums);

    /**
     * Get the average of the last N elements
     *
     * @return the average of the last N elements
     */
    double getAverage();
}
