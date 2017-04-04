package ru.nevars.mcls.algorithms.sort;

public abstract class AbstractSort<T extends Comparable<T>> {

    protected T[] array;

    protected int ARRAY_SIZE;

    public AbstractSort() {
        array = null;
        ARRAY_SIZE = 0;
    }

    public AbstractSort(T[] array) {
        setArray(array);
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
        if (array == null) {
            throw new NullPointerException("Array must not be null");
        }

        this.array = array;
        ARRAY_SIZE = array.length;
    }

    public boolean isArraySorted() {
        if (array.length == 0) {
            return true;
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

    public void sort() {
        if (array == null) {
            throw new NullPointerException("Array must not be null");
        }

        if (array.length == 1) {
            return;
        }

        sortArray();
    }

    protected abstract void sortArray();
}
