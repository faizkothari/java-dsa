package com.training.interviewbit.dp;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/
 *
 * Description:
 *
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 *
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyStocks2 {

    /**
     * Computes the maximum profit that can be accumulated
     * @param prices The complete list of prices on each day
     * @return maximum profit
     */
    public static int maxProfit(final List<Integer> prices) {

        // If none or only one price point available.
        if (prices.size() < 2) {
            return 0;
        }

        int prevPrice = prices.get(0);
        int profitSum = 0;

        // The trick is to identify ascending sequences of prices and accumulating profits during them.
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > prevPrice) {
                // Buy at previous price and sell at current price
                // and make a profit = difference in price
                profitSum += prices.get(i) - prevPrice;
            }

            prevPrice = prices.get(i);
        }

        return profitSum;
    }

    // Driver Program
    public static void main(String[] args) {
        assert 2 == maxProfit(Arrays.asList(1, 2, 3));
        assert 8 == maxProfit(Arrays.asList(5, 2, 10));
        assert 10 == maxProfit(Arrays.asList(4, 2, 6, 2, 5, 7, 2, 1, 2, 1));
    }
}
