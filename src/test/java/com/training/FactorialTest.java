package com.training;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FactorialTest {

    @Test
    public void test() {
        assertEquals(120, Factorial.recursive(5));
        assertEquals(120, Factorial.iterative(5));
        assertEquals(120, Factorial.tailRecursive(5));

        assertEquals(1, Factorial.recursive(0));
        assertEquals(1, Factorial.iterative(0));
        assertEquals(1, Factorial.tailRecursive(0));

        assertEquals(1, Factorial.recursive(1));
        assertEquals(1, Factorial.iterative(1));
        assertEquals(1, Factorial.tailRecursive(1));

        try {
            Factorial.recursive(-1);
        } catch (Throwable t) {
            assertTrue(t instanceof IllegalArgumentException);
        }

        try {
            Factorial.iterative(-1);
        } catch (Throwable t) {
            assertTrue(t instanceof IllegalArgumentException);
        }

        try {
            Factorial.tailRecursive(-1);
        } catch (Throwable t) {
            assertTrue(t instanceof IllegalArgumentException);
        }
    }
}
