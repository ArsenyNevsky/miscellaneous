package ru.nevars.mcls.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;


public class ConcurrencyUtilsTest {

    private ConcurrencyUtils concurrencyUtils = ConcurrencyUtils.getConcurrencyUtils();

    @Test
    public void getConcurrencyUtils() throws Exception {
        assertNotNull("Test that aninstance of ConcurrencyUtils is not null", concurrencyUtils);
    }

    @Test
    public void testGetOneMinute() throws Exception {
        assertTrue(60L == concurrencyUtils.getONE_MINUTE());
    }

    @Test
    public void testGetDefaultValue() throws Exception {
        assertTrue(0L == concurrencyUtils.getDEFAULT_VALUE());
    }

    @Test
    public void resetTimeParameters() throws Exception {
        concurrencyUtils.setStartTime(100L);
        concurrencyUtils.setEndTime(178L);

        assertNotEquals(concurrencyUtils.getDEFAULT_VALUE(), concurrencyUtils.getStartTime());
        assertNotEquals(concurrencyUtils.getDEFAULT_VALUE(), concurrencyUtils.getEndTime());

        concurrencyUtils.resetTimeParameters();

        assertEquals(concurrencyUtils.getDEFAULT_VALUE(), concurrencyUtils.getStartTime());
        assertEquals(concurrencyUtils.getDEFAULT_VALUE(), concurrencyUtils.getEndTime());
    }

    @Test
    public void testTimeEstimation() {
        // 60 seconds
        concurrencyUtils.setStartTime(10_000L);
        concurrencyUtils.setEndTime(70_000L);
        assertEquals(concurrencyUtils.getONE_MINUTE(), concurrencyUtils.getWorkTimeSeconds());

        // 90 seconds
        concurrencyUtils.setStartTime(6000L);
        concurrencyUtils.setEndTime(96000L);
        assertEquals(90L, concurrencyUtils.getWorkTimeSeconds());

        // 99 seconds
        concurrencyUtils.setStartTime(6000L);
        concurrencyUtils.setEndTime(105_000L);
        assertEquals(99L, concurrencyUtils.getWorkTimeSeconds());
    }

}