package ru.nevars.mcls.concurrency;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public final class ConcurrencyUtils {

    private long startTime = 0L;
    private long endTime = 0L;
    private static ConcurrencyUtils concurrencyUtils;


    /**
     * 0 millseconds
     */
    private final long DEFAULT_VALUE = 0L;

    /**
     * A representation of thousand millseconds == 1 sec
     */
    private final long ONE_SECOND = 1000L;

    /**
     * A representation of one minute == 60 sec
     */
    private final long ONE_MINUTE = 60;


    private ConcurrencyUtils() {}

    public static ConcurrencyUtils getConcurrencyUtils() {
        if (Objects.isNull(concurrencyUtils)) {
            synchronized (ConcurrencyUtils.class) {
                concurrencyUtils = new ConcurrencyUtils();
                return concurrencyUtils;
            }
        }
        return concurrencyUtils;
    }

    public boolean checkTimeEstimations(long timeAssesmentOne, long timeAssesmentTwo) {
        return timeAssesmentOne > timeAssesmentTwo;
    }

    public void startTimeEvaluation() {
        startTime = System.currentTimeMillis();
    }

    public void endTimeEvaluation() {
        endTime = System.currentTimeMillis();
    }

    public long getWorkTimeSeconds() {
        return (endTime - startTime) / ONE_SECOND;
    }

    public long getWorkTimeMillseconds() {
        return endTime - startTime;
    }

    public void printWorkTimeMillseconds() {
        System.out.println("startTime = " + startTime);
        System.out.println("endTime = " + endTime);
        System.out.printf("%.2f mls", (double) ((endTime - startTime) / (1 * 1)));
    }

    public void printWorkTimeSeconds() {
        if (startTime != DEFAULT_VALUE && endTime != DEFAULT_VALUE) {
            System.out.printf("%.2f sec", (double) ((endTime - startTime) / ONE_MINUTE));
            return;
        }
        if (startTime == DEFAULT_VALUE && endTime == DEFAULT_VALUE) {
            System.out.println("Run evaluation");
        }
        if (startTime == DEFAULT_VALUE) {
            System.out.println("Should start time evaluation");
        }
        if (endTime == DEFAULT_VALUE) {
            System.out.println("Stop time evaluation");
        }
    }

    public void startTimeEstimation() {
        startTime = System.currentTimeMillis();
    }

    public void endTimeEstimation() {
        endTime = System.currentTimeMillis();
    }

    public void resetTimeParameters() {
        startTime = DEFAULT_VALUE;
        endTime = DEFAULT_VALUE;
    }

}
