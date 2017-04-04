package ru.nevars.mcls.algorithms.sort;

public class BubbleSort<T extends Comparable<T>> extends AbstractSort {

    @Override
    public void sortArray() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                if (!isAlessB(j, i)) {
                    swap(j, i);
                }
            }
        }
    }
}
