package com.training;

/**
 * Rotates the given array by a specified number of times. Array is rotated towards the right.
 *
 * For example:
 * [1, 2, 3, 4, 5, 6, 7] when rotated 3 times: [5, 6, 7, 1, 2, 3, 4]
 *
 * Time complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author  Faiz Ilahi Kothari
 */
public class ArrayRotation {

    /**
     * Rotates the given array by a specific count. The original array is modified.
     * @param array elements to be rotated
     * @param nRotationCount rotation count
     * @param <T> Type of element
     */
    public static <T> void rotateArray(T[] array, int nRotationCount) {
        nRotationCount = nRotationCount % array.length;

        int start = 0;
        while (nRotationCount > 0) {
            swapArray(array, start, array.length, nRotationCount);
            start = start + nRotationCount;
            nRotationCount = nRotationCount % (array.length - start);
        }
    }

    /**
     * Swaps last n elements of the array with first n elements
     * @param arr array of elements
     * @param start start index inclusive
     * @param end end index exclusive
     * @param swapCount number of elements to swap
     * @param <T> Type of element
     */
    private static <T> void swapArray(T[] arr, int start, int end, int swapCount) {
        int i = start;
        int j = end - swapCount;

        for (; j < end; j++, i++) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
