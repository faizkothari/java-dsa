package com.training;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FactorialTest {

    @Test
    public void test() {
        assertEquals(120, Factorial.factorialUsingRecursion(5));
        assertEquals(120, Factorial.factorial(5));
        assertEquals(120, Factorial.tailRecursive(5));

        assertEquals(1, Factorial.factorialUsingRecursion(0));
        assertEquals(1, Factorial.factorial(0));
        assertEquals(1, Factorial.tailRecursive(0));

        assertEquals(1, Factorial.factorialUsingRecursion(1));
        assertEquals(1, Factorial.factorial(1));
        assertEquals(1, Factorial.tailRecursive(1));

        try {
            Factorial.factorialUsingRecursion(-1);
        } catch (Throwable t) {
            assertTrue(t instanceof IllegalArgumentException);
        }

        try {
            Factorial.factorial(-1);
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
