package com.training.interviewbit.dp;

import com.training.utils.Assert;

/**
 * https://www.interviewbit.com/problems/longest-common-subsequence/
 *
 * Given two strings A and B. Find the longest common sequence ( A sequence which does not need to be contiguous),
 * which is common in both the strings. Return the length of such longest common subsequence.
 *
 */
public class LongestCommonSubsequence {

    public static int solve(String a, String b) {
        int[][] lcs = new int[a.length() + 1][b.length() + 1];

        // when string 'a' is empty
        for (int i = 0, j = 0; j <= b.length(); j++) {
            lcs[i][j] = 0;
        }

        // // when string 'b' is empty
        for (int i = 0, j = 0; i <= a.length(); i++) {
            lcs[i][j] = 0;
        }

        /*
        Example: longest common subsequence ("bbadcgf" "abbcdgf")

            -  a  b  b  c  d  g  f
         -  0  0  0  0  0  0  0  0
         b  0  0  1  1  1  1  1  1
         b  0  0  1  2  2  2  2  2
         a  0  1  1  2  2  2  2  2
         d  0  1  1  2  2  3  3  3
         c  0  1  1  2  3  3  3  3
         g  0  1  1  2  3  3  4  4
         f  0  1  1  2  3  3  4  5

         */
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    // include this character
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    // Include one character from either strings or don't include at all from either
                    lcs[i][j] = Math.max(lcs[i - 1][j], Math.max(lcs[i][j - 1], lcs[i-1][j-1]));
                }
            }
        }

        return lcs[a.length()][b.length()];
    }

    public static void main(String[] args) {

        Assert.equals(1, solve(
                "a", "aa"
        ));

        Assert.equals(5, solve(
                "bbadcgf", "abbcdgf"
        ));

        Assert.equals(12, solve(
                "bebdeeedaddecebbbbbabebedc",
                "abaaddaabbedeedeacbcdcaaed"
        ));
    }
}
