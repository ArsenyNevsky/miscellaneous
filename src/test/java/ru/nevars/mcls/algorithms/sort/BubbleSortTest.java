package ru.nevars.mcls.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BubbleSortTest extends ArraysTest {

    private AbstractSort<Integer> bubbleSort;

    @Before
    public void setUp() throws Exception {
        bubbleSort = new BubbleSort<Integer>();
    }

    @Test(expected = NullPointerException.class)
    public void sortNullArray() throws Exception {
        bubbleSort.setArray(integerArray_1);
        bubbleSort.sort();
    }

    @Test
    public void sortEmptyArray() throws Exception {
        bubbleSort.setArray(integerArray_2);
        bubbleSort.sort();
        assertTrue(bubbleSort.isArraySorted());
    }

    @Test
    public void sortNotEmptyArrays() throws Exception {
        bubbleSort.setArray(integerArray_3);
        bubbleSort.sort();
        assertTrue(bubbleSort.isArraySorted());

        bubbleSort.setArray(integerArray_4);
        bubbleSort.sort();
        assertTrue(bubbleSort.isArraySorted());

        bubbleSort.setArray(integerArray_5);
        bubbleSort.sort();
        assertTrue(bubbleSort.isArraySorted());

        bubbleSort.setArray(integerArray_6);
        bubbleSort.sort();
        assertTrue(bubbleSort.isArraySorted());
    }

}