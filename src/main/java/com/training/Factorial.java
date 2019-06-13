package com.training;

/**
 * This class holds various methods for calculating factorial of a non-negative integer.
 * @author  Faiz Ilahi Kothari
 */
public class Factorial {

    private static final String ERROR_MESSAGE = "Only non-negative arguments allowed.";

    /**
     * Computes factorial of a non-negative integer recursively.
     * If <tt>n</tt> is too large, the thread would run out of stack.
     *
     * @param n integer whose factorial is to be computed
     * @return <tt>true</tt> if this list contains the specified element
     * @throws IllegalArgumentException if <tt>n</tt> is negative
     */
    public static long recursive(int n) {

        if (n < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " Found: " + n + ".");
        }

        if (n == 0) {
            return 1;
        }

        return n * recursive(n - 1);
    }

    /**
     * Computes factorial of a non-negative integer recursively.
     * This method's implementation is used to demonstrate tail calls.
     * Since Java compiler doesn't support Tail Call Optimization,
     * it won't be converted to an iterative call after compilation.
     * If <tt>n</tt> is too large, the thread would run out of stack.
     *
     * @param n integer whose factorial is to be computed
     * @return <tt>true</tt> if this list contains the specified element
     * @throws IllegalArgumentException if <tt>n</tt> is negative
     */
    public static long tailRecursive(int n) {
        Result res = new Result();
        recurWithAccumulator(n, res);
        return res.get();
    }

    /**
     * Computes factorial of a non-negative integer iteratively.
     * This removes the possibility of stack overflow.
     *
     * @param n integer whose factorial is to be computed
     * @return <tt>true</tt> if this list contains the specified element
     * @throws IllegalArgumentException if <tt>n</tt> is negative
     */
    public static long iterative(int n) {

        if (n < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " Found: " + n + ".");
        }

        long factorial = 1;
        while (n > 0) {
            factorial *= n;
            n--;
        }

        return factorial;
    }

    /**
     * This is the internal tail recursive method to compute the factorial.
     *
     * @param n non-negative integer whose factorial is to be computed
     * @param res holds the result of the factorial
     * @throws IllegalArgumentException if <tt>n</tt> is negative
     */
    private static void recurWithAccumulator(int n, Result res) {

        if (n < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " Found: " + n + ".");
        }

        if (n == 0) {
            res.inc(1);
            return;
        }

        res.inc(n);
        recurWithAccumulator(n - 1, res);
    }

    /**
     * A Result class to hold and update factorial of a number.
     */
    private static class Result {
        long result = 1;

        void inc(long n) {
            result *= n;
        }

        long get() {
            return result;
        }
    }
}
