package ru.nevars.mcls.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractSortTest {

    private AbstractSort<Integer> integerSort;
    private AbstractSort<String> stringSort;
    private AbstractSort<Double> doubleSort;

    @Before
    public void setUp() throws Exception {
        integerSort = new AbstractSort<Integer>(new Integer[]{new Integer(2), new Integer(3), new Integer(1)}) {
            @Override
            public void sort() {

            }
        };
    }

    @Test
    public void swap() throws Exception {
        Integer[] array = {new Integer(2), new Integer(1)};
        integerSort.setArray(array);
        integerSort.swap(0, 1);
        assertTrue(integerSort.getArray()[0] == 1);
        assertTrue(integerSort.getArray()[1] == 2);
    }

    @Test
    public void isAlessB() throws Exception {
        assertTrue(integerSort.isAlessB(2, 1));
        assertTrue(integerSort.isAlessB(0, 1));
        assertFalse(integerSort.isAlessB(1, 0));
    }

    @Test
    public void getArray() throws Exception {
        Integer[] array = integerSort.getArray();
        assertArrayEquals(integerSort.getArray(), array);
    }

    @Test(expected = NullPointerException.class)
    public void testNullArray() throws Exception {
        integerSort = new AbstractSort<Integer>(null) {
            @Override
            public void sort() {

            }
        };
    }

}