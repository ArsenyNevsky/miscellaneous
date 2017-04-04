package ru.nevars.mcls.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractSortTest extends ArraysTest {

    protected AbstractSort<Integer> integerSort;
    protected AbstractSort<String> stringSort;
    protected AbstractSort<Double> doubleSort;

    @Before
    public void setUp() throws Exception {
        integerSort = new AbstractSort<Integer>() {
            @Override
            public void sortArray() {

            }
        };
    }

    @Test
    public void swap() throws Exception {
        Integer[] array = {2, 1};
        integerSort.setArray(array);
        integerSort.swap(0, 1);
        assertTrue(integerSort.getArray()[0] == 1);
        assertTrue(integerSort.getArray()[1] == 2);
    }

    @Test
    public void isAlessB() throws Exception {
        integerSort.setArray(integerArray_5);
        assertTrue(integerSort.isAlessB(2, 1));
        assertTrue(integerSort.isAlessB(1, 0));
        assertFalse(integerSort.isAlessB(0, 1));
    }

    @Test(expected = NullPointerException.class)
    public void testNullArray() throws Exception {
        integerSort = new AbstractSort<Integer>(null) {
            @Override
            public void sortArray() {

            }
        };
    }

    @Test
    public void testIsSortedArray() throws Exception {
        integerSort.setArray(integerArray_2);
        assertTrue(integerSort.isArraySorted());

        integerSort.setArray(integerArray_3);
        assertTrue(integerSort.isArraySorted());

        integerSort.setArray(integerArray_4);
        assertTrue(integerSort.isArraySorted());

        integerSort.setArray(integerArray_5);
        assertFalse(integerSort.isArraySorted());

        integerSort.setArray(integerArray_6);
        assertFalse(integerSort.isArraySorted());
    }

}