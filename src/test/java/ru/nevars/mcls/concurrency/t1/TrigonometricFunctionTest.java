package ru.nevars.mcls.concurrency.t1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TrigonometricFunctionTest {

    @Test
    public void initVlaues() throws Exception {
        TrigonometricFunction.initVlaues(3);
        assertThat(TrigonometricFunction.getValues() != null);
    }

    @Test
    public void flusValues() throws Exception {
        TrigonometricFunction.flusValues();
        assertThat(TrigonometricFunction.getValues() == null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectArguments() throws Exception {
        final int startIndex = 4;
        final int endIndex = 3;
        when(TrigonometricFunction.calculateSum(startIndex, endIndex)).thenThrow(new IllegalArgumentException());
        TrigonometricFunction.calculateSum(startIndex, endIndex);
    }

    @Test(expected = NullPointerException.class)
    public void testCalculateOnEmptyArray() throws Exception {
        final int startIndex = 3;
        final int endIndex = 4;
        TrigonometricFunction.flusValues();
        when(TrigonometricFunction.calculateSum(startIndex, endIndex)).thenThrow(new NullPointerException());
        TrigonometricFunction.calculateSum(startIndex, endIndex);
    }
}