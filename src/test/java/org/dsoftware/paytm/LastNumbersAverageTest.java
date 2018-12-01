package org.dsoftware.paytm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LastNumbersAverageTest {
    @Test
    public void testLastNumbersAverage_totalBelowN_rightResult() {
        //Arrange
        LastNumbersAverage lastNumbersAverage = LastNumbersAverageFactory.createLastNumbersAverage(5);
        lastNumbersAverage.addNumbers(3, 4);
        //Act
        final double avg = lastNumbersAverage.getAverage();
        final int totalNumbers = lastNumbersAverage.getTotalNumbers();
        //Assert
        assertEquals(3.5, avg, 0);
        assertEquals(2, totalNumbers);
    }

    @Test
    public void testLastNumbersAverage_emptyList_rightResult() {
        //Arrange
        LastNumbersAverage lastNumbersAverage = LastNumbersAverageFactory.createLastNumbersAverage(5);
        //Act
        final double avg = lastNumbersAverage.getAverage();
        final int totalNumbers = lastNumbersAverage.getTotalNumbers();
        //Assert
        assertEquals(0, avg, 0);
        assertEquals(0, totalNumbers);
    }

    @Test
    public void testLastNumbersAverage_totalNumbersExactlyN_rightResult() {
        //Arrange
        LastNumbersAverage lastNumbersAverage = LastNumbersAverageFactory.createLastNumbersAverage(5);
        lastNumbersAverage.addNumbers(3, 4, 5, 6, 7);
        //Act
        final double avg = lastNumbersAverage.getAverage();
        final int totalNumbers = lastNumbersAverage.getTotalNumbers();
        //Assert
        assertEquals(5.0, avg, 0);
        assertEquals(5, totalNumbers);
    }

    @Test
    public void testLastNumbersAverage_totalNumbersAboveN_rightResult() {
        //Arrange
        LastNumbersAverage lastNumbersAverage = LastNumbersAverageFactory.createLastNumbersAverage(5);
        for (int i = 0; i <= 300; ++i) {
            lastNumbersAverage.addNumber(i);
        }
        //Act
        final double avg = lastNumbersAverage.getAverage();
        final int totalNumbers = lastNumbersAverage.getTotalNumbers();
        //Assert
        assertEquals((300 + 299 + 298 + 297 + 296) / 5, avg, 0);
        assertEquals(5, totalNumbers);
    }

    @Test
    public void testLastNumbersAverage_largeN_rightResult() {
        //Arrange
        LastNumbersAverage lastNumbersAverage = LastNumbersAverageFactory.createLastNumbersAverage(1_000_000);
        for (int i = 0; i <= 10_000_000; ++i) {
            lastNumbersAverage.addNumber(i);
        }
        //Act
        final double avg = lastNumbersAverage.getAverage();
        final int totalNumbers = lastNumbersAverage.getTotalNumbers();
        //Assert
        assertEquals((10_000_000.0 + 9_000_001.0) / 2, avg, 0);
        assertEquals(1_000_000, totalNumbers);
    }

}
