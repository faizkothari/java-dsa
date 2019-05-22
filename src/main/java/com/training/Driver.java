package com.training;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        Integer[] items1 = {1, 5, 3, 2, 4};
        System.out.println("Before sort: " + Arrays.toString(items1));
        Sorter.insertionSort(items1, Sorter.Order.INCR);
        System.out.println("After sort: " + Arrays.toString(items1));

        Integer[] items2 = {1, 5, 3, 2, 4};
        System.out.println("Before sort: " + Arrays.toString(items2));
        Sorter.selectionSort(items2, Sorter.Order.INCR);
        System.out.println("After sort: " + Arrays.toString(items2));

        Integer[] items3 = {0, 2, 1, 4, 3};
        System.out.println("Before sort: " + Arrays.toString(items3));
        Sorter.quickSort(items3, Sorter.Order.DECR);
        System.out.println("After sort: " + Arrays.toString(items3));
    }
}
