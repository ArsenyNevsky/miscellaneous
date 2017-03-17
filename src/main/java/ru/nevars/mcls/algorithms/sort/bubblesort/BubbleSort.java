package ru.nevars.mcls.algorithms.sort.bubblesort;

import ru.nevars.mcls.algorithms.sort.AbstractSort;

public class BubbleSort<T extends Comparable<T>> extends AbstractSort {

    public BubbleSort(T[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                if (isAlessB(j, i)) {
                    swap(j, i);
                }
            }
        }
    }
}
