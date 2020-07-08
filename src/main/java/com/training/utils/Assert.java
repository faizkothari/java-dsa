package com.training.utils;

public class Assert {

    public static void equals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Expected: " + expected + " got: " + actual);
        }
    }
}
