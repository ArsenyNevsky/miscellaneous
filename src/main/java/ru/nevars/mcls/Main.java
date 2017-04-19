package ru.nevars.mcls;

import ru.nevars.mcls.concurrency.ConcurrencyUtils;
import ru.nevars.mcls.concurrency.t1.TrigonometricCalcService;
import ru.nevars.mcls.concurrency.t1.TrigonometricFunction;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 15_000_000;
        final int THREADS = 2;
        TrigonometricFunction.initVlaues(SIZE);
        ConcurrencyUtils concurrencyUtils = ConcurrencyUtils.getConcurrencyUtils();

        concurrencyUtils.startTimeEstimation();
        TrigonometricCalcService calcService = new TrigonometricCalcService(THREADS, SIZE);

        try {
            calcService.runTasks();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(calcService.getResult());
        concurrencyUtils.endTimeEstimation();
        concurrencyUtils.printWorkTimeMillseconds();
    }
}
