package com.training;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SorterTest {

    @Test
    public void verifyInsertionSort() {
        Integer[] data1 = getEmptyData();
        Sorter.insertionSort(data1, Sorter.Order.INCR);
        assertArrayEquals(data1, getEmptyData());

        Integer[] data2 = getUnitData();
        Sorter.insertionSort(data2, Sorter.Order.INCR);
        assertArrayEquals(data2, getUnitData());

        Integer[] data3 = getUnitData();
        Sorter.insertionSort(data3, Sorter.Order.DECR);
        assertArrayEquals(data3, getUnitData());

        Integer[] data4 = getUnSortedData();
        Sorter.insertionSort(data4, Sorter.Order.INCR);
        assertArrayEquals(data4, getIncrSortedData());

        Integer[] data5 = getUnSortedData();
        Sorter.insertionSort(data5, Sorter.Order.DECR);
        assertArrayEquals(data5, getDecrSortedData());
    }

    @Test
    public void verifyBubbleSort() {
        Integer[] data1 = getEmptyData();
        Sorter.bubbleSort(data1, Sorter.Order.INCR);
        assertArrayEquals(data1, getEmptyData());

        Integer[] data2 = getUnitData();
        Sorter.bubbleSort(data2, Sorter.Order.INCR);
        assertArrayEquals(data2, getUnitData());

        Integer[] data3 = getUnitData();
        Sorter.bubbleSort(data3, Sorter.Order.DECR);
        assertArrayEquals(data3, getUnitData());

        Integer[] data4 = getUnSortedData();
        Sorter.bubbleSort(data4, Sorter.Order.INCR);
        assertArrayEquals(data4, getIncrSortedData());

        Integer[] data5 = getUnSortedData();
        Sorter.bubbleSort(data5, Sorter.Order.DECR);
        assertArrayEquals(data5, getDecrSortedData());
    }

    @Test
    public void verifySelectionSort() {
        Integer[] data1 = getEmptyData();
        Sorter.selectionSort(data1, Sorter.Order.INCR);
        assertArrayEquals(data1, getEmptyData());

        Integer[] data2 = getUnitData();
        Sorter.selectionSort(data2, Sorter.Order.INCR);
        assertArrayEquals(data2, getUnitData());

        Integer[] data3 = getUnitData();
        Sorter.selectionSort(data3, Sorter.Order.DECR);
        assertArrayEquals(data3, getUnitData());

        Integer[] data4 = getUnSortedData();
        Sorter.selectionSort(data4, Sorter.Order.INCR);
        assertArrayEquals(data4, getIncrSortedData());

        Integer[] data5 = getUnSortedData();
        Sorter.selectionSort(data5, Sorter.Order.DECR);
        assertArrayEquals(data5, getDecrSortedData());
    }

    @Test
    public void verifyQuickSort() {
        Integer[] data1 = getEmptyData();
        Sorter.quickSort(data1, Sorter.Order.INCR);
        assertArrayEquals(data1, getEmptyData());

        Integer[] data2 = getUnitData();
        Sorter.quickSort(data2, Sorter.Order.INCR);
        assertArrayEquals(data2, getUnitData());

        Integer[] data3 = getUnitData();
        Sorter.quickSort(data3, Sorter.Order.DECR);
        assertArrayEquals(data3, getUnitData());

        Integer[] data4 = getUnSortedData();
        Sorter.quickSort(data4, Sorter.Order.INCR);
        assertArrayEquals(data4, getIncrSortedData());

        Integer[] data5 = getUnSortedData();
        Sorter.quickSort(data5, Sorter.Order.DECR);
        assertArrayEquals(data5, getDecrSortedData());
    }

    private static Integer[] getEmptyData() {
        return new Integer[]{};
    }

    private static Integer[] getUnitData() {
        return new Integer[]{2};
    }

    private static Integer[] getIncrSortedData() {
        return new Integer[]{-1, 0, 1, 2, 7, 8, 16};
    }

    private static Integer[] getDecrSortedData() {
        return new Integer[]{16, 8, 7, 2, 1, 0, -1};
    }

    private static Integer[] getUnSortedData() {
        return new Integer[]{1, 7, 16, 8, -1, 2, 0};
    }
}
