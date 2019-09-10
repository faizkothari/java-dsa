package com.training;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ArrayRotationTest {

    @Test
    public void verify() {
        for (int i = 1; i < 100; i++) {
            Integer[] arr = getIntArray(100);
            Integer[] expRot = getIntArrayRotated(100, i);
            ArrayRotation.rotateArray(arr, i);
            assertArrayEquals(expRot, arr);
        }
    }

    private Integer[] getIntArray(int len) {
        Integer[] arr = new Integer[len];
        for (int i = 1; i <= len; i++) {
            arr[i - 1] = i;
        }
        return arr;
    }

    private Integer[] getIntArrayRotated(int len, int rotation) {
        Integer[] arr = new Integer[len];
        rotation = rotation % len;
        int i = 1;
        for (; i + rotation <= len; i++) {
            arr[i - 1 + rotation] = i;
        }

        for (int k = 1; k <= rotation; k++, i++) {
            arr[k - 1] = i;
        }

        return arr;
    }
}
