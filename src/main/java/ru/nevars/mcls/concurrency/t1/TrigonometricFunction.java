package ru.nevars.mcls.concurrency.t1;

import java.util.stream.IntStream;

import static java.lang.Math.sin;

public final class TrigonometricFunction {

    private static double[] values;

    public static void initVlaues(final int N) {
        values = new double[N];
        IntStream.range(0, N).forEach(i -> values[i] = sin(i));
    }

    public static void flusValues() {
        values = null;
    }

    public static double calculateSum() {
        return calculateSum(0, values.length);
    }

    public static double calculateSum(final int startIndex, final int endIndex) {
        if (startIndex > endIndex) {
            throw new IllegalArgumentException("startindex > endIndex");
        }
        if (values == null) {
            throw new NullPointerException("Array is not initialized");
        }

        double sum = 0L;
        for (int i = startIndex; i < endIndex; i++) {
            sum += values[i];
        }

        return sum;
    }
}
