package ru.nevars.mcls.algorithms.sort.bubblesort;

import org.junit.Before;
import org.junit.Test;
import ru.nevars.mcls.algorithms.sort.AbstractSort;

public class BubbleSortTest {

    private AbstractSort<Integer> bubbleSort;
    private Integer[] integerArray1 = new Integer[]{3, 2};

    @Before
    public void setUp() throws Exception {
        bubbleSort = new BubbleSort<Integer>(integerArray1);
    }

    @Test
    public void sort() throws Exception {

    }

}