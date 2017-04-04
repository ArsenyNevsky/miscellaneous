package ru.nevars.mcls.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InsertSortTest extends AbstractSortTest {


    @Before
    public void setUp() throws Exception {
        integerSort = new InsertSort<Integer>();
    }

    @Test(expected = NullPointerException.class)
    public void sortNullArray() throws Exception {
        integerSort.setArray(integerArray_1);
        integerSort.sort();
    }

    @Test
    public void sortEmptyArray() throws Exception {
        integerSort.setArray(integerArray_2);
        integerSort.sort();
    }

    @Test
    public void sortNotEmptyArrays() throws Exception {
        integerSort.setArray(integerArray_3);
        integerSort.sort();
        assertTrue(integerSort.isArraySorted());

        integerSort.setArray(integerArray_4);
        integerSort.sort();
        assertTrue(integerSort.isArraySorted());

        integerSort.setArray(integerArray_5);
        integerSort.sort();
        assertTrue(integerSort.isArraySorted());

        integerSort.setArray(integerArray_6);
        integerSort.sort();
        assertTrue(integerSort.isArraySorted());
    }

}