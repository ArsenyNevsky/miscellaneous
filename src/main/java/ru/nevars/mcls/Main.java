package ru.nevars.mcls;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int arr[] = new int[3];
        IntStream.range(0, 3).forEach(i -> arr[i] = i);
        System.out.println(Arrays.toString(arr));
    }
}
