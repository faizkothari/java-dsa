package com.training;

public class Sorter {

    public enum Order {
        INCR,
        DECR
    }

    /**
     * Sorts elements by picking one element and adding it
     * to an already sorted array of elements.
     * @param items items to sort
     * @param order sort order (incremental or decremental)
     * @param <T> item of type Comparable
     */
    public static <T extends Comparable<T>> void insertionSort(T[] items, Order order) {
        if (items == null || items.length < 2) {
            return;
        }
        int len = items.length;
        for (int i = 1; i < len; i++) {
            T current = items[i];
            insert(items, current, order, 0, i);
        }
    }

    /**
     * Sorts elements by selecting the largest/smallest element
     * and placing it at the beginning of the array.
     * @param items items to sort
     * @param order sort order (incremental or decremental)
     * @param <T>
     */
    public static <T extends Comparable<T>> void selectionSort(T[] items, Order order) {
        if (items == null || items.length < 2) {
            return;
        }
        for (int i = 0; i < items.length; i++) {
            int itemIdx = i;
            if (order == Order.INCR) {
                itemIdx = indexOfMin(items, i, items.length);
            }
            if (order == Order.DECR) {
                itemIdx = indexOfMax(items, i, items.length);
            }
            swap(items, i, itemIdx);
        }
    }

    /**
     * Sorts the elements by bubbling up the minimum or maximum
     * element by swapping elements in every iteration till the
     * array is completely sorted.
     * @param items items to sort
     * @param order sort order (incremental or decremental)
     * @param <T>
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] items, Order order) {
        if (items == null || items.length < 2) {
            return;
        }
        for (int i = items.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                swap(items, order, j, j+1);
            }
        }
    }

    /**
     * Sorts elements by picking a pivot element and placing it at it's correct position.
     * Then continue with the same strategy for the items on the left and right side of the
     * pivot till all the items are in their right place.
     * @param items items to sort
     * @param order sort order (incremental or decremental)
     * @param <T>
     */
    public static <T extends Comparable<T>> void quickSort(T[] items, Order order) {
        qSort(items, order, 0, items.length);
    }

    private static <T extends Comparable<T>> void qSort(T[] items, Order order, int start, int end) {
        if (start >= end) {
            return;
        }
        T pivot = items[(start + end)/2];

        int i = start;
        int j = end - 1;

        // partition step
        while (i < j) {
            while (!outOfOrder(items[i], pivot, order)) {
                i++;
            }

            while (!outOfOrder(pivot, items[j], order)) {
                j--;
            }

            swap(items, i, j);
        }
        qSort(items, order, start, i);
        qSort(items, order, i + 1, end);
    }

    /**
     * Insert an item in a sorted array of items: items[start, end)
     * The length of items array should be at least (end - start + 1).
     * end >= start, otherwise simply returns.
     * @param items list of items in which one more item needs to be inserted
     * @param item the item to be inserted
     * @param order order in which items are sorted
     * @param start start index in items
     * @param end end index in items
     * @param <T>
     */
    private static <T extends Comparable<T>> void insert(T[] items, T item, Order order, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start;
        while (i < end && !outOfOrder(items[i], item, order)) {
            i++;
        }
        int j = end;
        while (j > i) {
            items[j] = items[--j];
        }
        items[i] = item;
    }

    /**
     * Returns index of the minimum item in the array.
     * @param items array of items: items[start, end)
     * @param start start index of array
     * @param end end index of array
     * @param <T>
     * @return
     */
    private static <T extends Comparable<T>> int indexOfMin(T[] items, int start, int end) {
        int minIdx = start;
        for (int i = start; i < end; i++) {
            if (outOfOrder(items[minIdx], items[i], Order.INCR)) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    /**
     * Returns index of the maximum item in the array.
     * @param items array of items: items[start, end)
     * @param start start index of array
     * @param end end index of array
     * @param <T>
     * @return
     */
    private static <T extends Comparable<T>> int indexOfMax(T[] items, int start, int end) {
        int maxIdx = start;
        for (int i = start; i < end; i++) {
            if (outOfOrder(items[maxIdx], items[i], Order.DECR)) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    /**
     * Swap two elements in an array of items if out of order.
     * @param items array of items
     * @param order resulting order
     * @param i index of item1
     * @param j index of item2
     * @param <T>
     */
    private static <T extends Comparable<T>> void swap(T[] items, Order order, int i, int j) {
        if (outOfOrder(items[i], items[j], order)) {
            swap(items, i, j);
        }
    }

    /**
     * Returns true if the two elements are out of order, else false.
     * If both the elements are same, then also they are out of order.
     * @param item1 item1
     * @param item2 item2
     * @param order order in which they should be
     * @param <T>
     * @return
     */
    private static <T extends Comparable<T>> boolean outOfOrder(T item1, T item2, Order order) {
        int res = item1.compareTo(item2);
        return (order == Order.INCR && res >= 0) || (order == Order.DECR && res <= 0);
    }

    /**
     * Swap the items at index i and j in an array of items
     * @param items array of items
     * @param i index i
     * @param j index j
     * @param <T>
     */
    private static <T> void swap(T[] items, int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
