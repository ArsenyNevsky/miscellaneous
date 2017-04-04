package ru.nevars.mcls.algorithms.sort;

public class InsertSort<T extends Comparable<T>> extends AbstractSort {

    // 0 5 1
    // 0 5 1 4 2 3
    @Override
    protected void sortArray() {
        for (int i = 1; i < ARRAY_SIZE; i++) {
            int j = i;

            for (int k = j - 1; k >= 0 && array[k + 1].compareTo(array[k]) < 0; k--) {
                if (isAlessB(k + 1, k)) {
                    swap(k + 1, k);
                }
            }
        }
    }
}
