package com.training;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FibonacciTest {

    @Test
    public void test() {

        Fibonacci fibonacci = new Fibonacci();
        assertEquals(0, fibonacci.fib(0));
        assertEquals(1, fibonacci.fib(1));
        assertEquals(1, fibonacci.fib(2));
        assertEquals(2, fibonacci.fib(3));
        assertEquals(3, fibonacci.fib(4));
        assertEquals(5, fibonacci.fib(5));
        assertEquals(8, fibonacci.fib(6));

        assertEquals(0, fibonacci.fibUsingDoubleRecursion(0));
        assertEquals(1, fibonacci.fibUsingDoubleRecursion(1));
        assertEquals(1, fibonacci.fibUsingDoubleRecursion(2));
        assertEquals(2, fibonacci.fibUsingDoubleRecursion(3));
        assertEquals(3, fibonacci.fibUsingDoubleRecursion(4));
        assertEquals(5, fibonacci.fibUsingDoubleRecursion(5));
        assertEquals(8, fibonacci.fibUsingDoubleRecursion(6));

        assertEquals(0, fibonacci.fibUsingSingleRecursion(0));
        assertEquals(1, fibonacci.fibUsingSingleRecursion(1));
        assertEquals(1, fibonacci.fibUsingSingleRecursion(2));
        assertEquals(2, fibonacci.fibUsingSingleRecursion(3));
        assertEquals(3, fibonacci.fibUsingSingleRecursion(4));
        assertEquals(5, fibonacci.fibUsingSingleRecursion(5));
        assertEquals(8, fibonacci.fibUsingSingleRecursion(6));

        assertEquals(0, fibonacci.fibUsingTailRecursion(0));
        assertEquals(1, fibonacci.fibUsingTailRecursion(1));
        assertEquals(1, fibonacci.fibUsingTailRecursion(2));
        assertEquals(2, fibonacci.fibUsingTailRecursion(3));
        assertEquals(3, fibonacci.fibUsingTailRecursion(4));
        assertEquals(5, fibonacci.fibUsingTailRecursion(5));
        assertEquals(8, fibonacci.fibUsingTailRecursion(6));

        try {
            fibonacci.fib(-1);
        } catch (Throwable t) {
            assertTrue(t instanceof IllegalArgumentException);
        }

        try {
            fibonacci.fibUsingDoubleRecursion(-1);
        } catch (Throwable t) {
            assertTrue(t instanceof IllegalArgumentException);
        }

        try {
            fibonacci.fibUsingSingleRecursion(-1);
        } catch (Throwable t) {
            assertTrue(t instanceof IllegalArgumentException);
        }
    }
}
