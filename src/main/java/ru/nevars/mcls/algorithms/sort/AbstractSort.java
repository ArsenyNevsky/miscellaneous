package ru.nevars.mcls.algorithms.sort;

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
        return array[i].compareTo(array[j]) == -1 || array[i].compareTo(array[j]) == 0;
    }

    protected boolean isAlessB(T a, T b) {
        return a.compareTo(b) == -1 || a.compareTo(b) == 0;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public boolean isArraySorted() {
        if (array == null) {
            throw new NullPointerException("Array must not be null");
        }

        if (array.length == 1) {
            return true;
        }

        for (int i = 1; i <= array.length - 1; i++) {
            if (!isAlessB(i - 1, i)) {
                return false;
            }
        }
        return true;
    }

    public abstract void sort();
}
