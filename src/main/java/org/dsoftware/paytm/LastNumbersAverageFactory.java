package org.dsoftware.paytm;

public class LastNumbersAverageFactory {
    public static LastNumbersAverage createLastNumbersAverage(final int n) {
        return new LastNumbersAverageImpl(n);
    }

}
