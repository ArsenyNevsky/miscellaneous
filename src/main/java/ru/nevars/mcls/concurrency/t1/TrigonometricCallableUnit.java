package ru.nevars.mcls.concurrency.t1;

import java.util.concurrent.Callable;

public class TrigonometricCallableUnit implements Callable<Double> {

    private final int START_INDEX;
    private final int END_INDEX;


    public TrigonometricCallableUnit(int START_INDEX, int END_INDEX) {
        this.START_INDEX = START_INDEX;
        this.END_INDEX = END_INDEX;
    }

    @Override
    public Double call() throws Exception {
        return TrigonometricFunction.calculateSum(START_INDEX, END_INDEX);
    }
}
