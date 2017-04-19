package ru.nevars.mcls.concurrency.t1;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TrigonometricCalcService {

    private final int THREADS_NUMBER;
    private final int ARRAY_RESOURCES_SIZE;
    private ArrayList<Future<Double>> results;
    private ExecutorService executorService;

    public TrigonometricCalcService(int threadsNumber, int arraySize) {
        if (threadsNumber <= 0) {
            throw new IllegalArgumentException("A number of threadsNumber cannot be less than 0");
        }
        if (arraySize <= 0) {
            throw new IllegalArgumentException("Size of array must be greater that 0");
        }

        ARRAY_RESOURCES_SIZE = arraySize;
        THREADS_NUMBER = threadsNumber;
        results = new ArrayList<>(THREADS_NUMBER);
    }

    public void runTasks() throws ExecutionException, InterruptedException {
        executorService = Executors.newFixedThreadPool(THREADS_NUMBER);
        switch (THREADS_NUMBER) {
            case 1:
                results.add(executorService.submit(new TrigonometricCallableUnit(0, ARRAY_RESOURCES_SIZE)));
                break;
            case 2:
                results.add(executorService.submit(new TrigonometricCallableUnit(0, ARRAY_RESOURCES_SIZE / 2)));
                results.add(executorService.submit(new TrigonometricCallableUnit(ARRAY_RESOURCES_SIZE / 2, ARRAY_RESOURCES_SIZE)));
                break;
            default: break;
        }
    }

    public double getResult() {
        double result = 0L;
        try {
            for (Future<Double> futureTask : results) {
                result += futureTask.get();
                return result;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        return result;
    }
}
