package ru.nevars.mcls.algorithms.sort;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class AbstractSort<T extends Comparable<T>> {

    protected T[] array;

    protected final int ARRAY_SIZE;

    public AbstractSort(T[] array) {
        if (array == null) {
            throw new NullPointerException("Array must not be null");
        }

        this.array = array;
        ARRAY_SIZE = array.length;
    }

    protected void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    protected boolean isAlessB(int i, int j) {
        return array[i].compareTo(array[j]) == -1;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public boolean isArraySorted() {

    }

    public abstract void sort();
}
