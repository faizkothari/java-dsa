package com.training;

import com.google.common.base.Preconditions;

/**
 * This class holds various methods for computing the nth fibonacci number.
 *
 * @author  Faiz Ilahi Kothari
 */
public class Fibonacci {

    private static final String ERROR_MESSAGE = "n cannot be negative. Found: ";

    /**
     * Computes nth Fibonacci number iteratively.
     *
     * @param n of which Fibonacci number is to be computed
     * @return nth Fibonacci number
     */
    public int fib(int n) {
        Preconditions.checkArgument(n >= 0, ERROR_MESSAGE + n);

        if (n < 2) {
            return n;
        }

        int fibnMinus2 = 0; // fib(n-2)
        int fibnMinus1 = 1; // fib(n-1)

        for (; n > 1; n--) {
            fibnMinus1 = fibnMinus1 + fibnMinus2; // new fib(n-1)
            fibnMinus2 = fibnMinus1 - fibnMinus2; // new fib(n-2)
        }

        return fibnMinus1; // at the end, this holds the resultant fib(n)
    }

    /**
     * Computes nth Fibonacci number recursively.
     * It uses double recursion, following the constraints:
     *      Fib(0) = 0;
     *      Fib(1) = 1;
     *      Fib(n) = Fib(n-1) + Fib(n-2)
     *
     * @param n of which Fibonacci number is to be computed
     * @return nth Fibonacci number
     */
    public int fibUsingDoubleRecursion(int n) {
        Preconditions.checkArgument(n >= 0, ERROR_MESSAGE + n);

        if (n < 2) {
            return n;
        }

        // Fib(n) = Fib(n-1) + Fib(n-2)
        return fibUsingDoubleRecursion(n - 1) + fibUsingDoubleRecursion(n - 2);
    }

    /**
     * Computes nth Fibonacci number recursively.
     * This internally uses a single recursive call.
     *
     * @param n of which Fibonacci number is to be computed
     * @return nth Fibonacci number
     */
    public int fibUsingSingleRecursion(int n) {
        Preconditions.checkArgument(n >= 0, ERROR_MESSAGE + n);

        if (n < 2) {
            return n;
        }

        // start with fib(n-1) = 1 and fib(n-2) = 0 for n >= 2
        return fibRecurWithMemoization(n, 1, 0);
    }

    /**
     * Computes nth Fibonacci number recursively.
     * It uses memoization to keep a track of Fib(n-1) and Fib(n-2)
     * This avoids duplicate intermediate computations
     * as compared to {@link Fibonacci#fibUsingDoubleRecursion}
     *
     * @param n of which Fibonacci number is to be computed
     * @return nth Fibonacci number
     */
    private int fibRecurWithMemoization(int n, int fibnMinus1, int fibnMinus2) {
        Preconditions.checkArgument(n > 0, ERROR_MESSAGE + n);
        // Terminating condition
        if (n < 2) {
            return fibnMinus1;
        }

        // Set the new fib(n-1) and fib(n-2) and recurse.
        return fibRecurWithMemoization(n - 1, fibnMinus1 + fibnMinus2, fibnMinus1);
    }

    /**
     * Computes nth Fibonacci number recursively.
     * It uses tail recursion internally and keeps a track of Fib(n-1) and Fib(n-2)
     *
     * @param n of which Fibonacci number is to be computed
     * @return nth Fibonacci number
     */
    public int fibUsingTailRecursion(int n) {
        Preconditions.checkArgument(n >= 0, ERROR_MESSAGE + n);

        if (n < 2) {
            return n;
        }

        Result result = new Result();

        // start with fib(n-1) = 1 and fib(n-2) = 0 for n >= 2
        fibTailRecur(n, result);

        return result.get();
    }

    /**
     * Computes nth Fibonacci number recursively.
     * It is tail recursive, using a result object to keep a track of Fib(n-1) and Fib(n-2)
     *
     * @param n of which Fibonacci number is to be computed
     * @return nth Fibonacci number
     */
    private void fibTailRecur(int n, Result result) {
        Preconditions.checkArgument(n > 0, ERROR_MESSAGE + n);
        // Terminating condition
        if (n < 2) {
            return;
        }

        fibTailRecur(n - 1, result.next());
    }

    /**
     * Holds the state Fib(n-1) and Fib(n-2)
     */
    private static class Result {
        int fibnMinus2 = 0;
        int fibnMinus1 = 1;

        // updates the state and returns it
        Result next() {
            fibnMinus1 = fibnMinus1 + fibnMinus2; // new fib(n-1)
            fibnMinus2 = fibnMinus1 - fibnMinus2; // new fib(n-2)
            return this;
        }

        int get() {
            return fibnMinus1;
        }
    }
}
