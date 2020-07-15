package com.training.interviewbit.dp;

import com.training.utils.Assert;

/**
 * https://www.interviewbit.com/problems/edit-distance/
 *
 * Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 */
public class EditDistanceProblem {

    public static int minEditDistance(String firstStr, String secondStr) {
        /*
        minEditDistance[i, j] = {
            if (i == 0) {
                i // len of second string
            }

            if (j == 0) {
                j // len of first string
            }

            if (firstStr[i] == secondStr[j]) {
                minEditDistance[i-1, j-1]
            } else {
                min(Insert Char, Delete Char, Update char)
                min(
                    1 + minEditDistance[i, j-1],
                    1 + minEditDistance[i-1, j],
                    1 + minEditDistance[i-1, j-1]
                )
            }
        }
         */

        int[][] minEditDistance = new int[firstStr.length() + 1][secondStr.length() + 1];

        for (int j = 1; j <= secondStr.length(); j++) {
            minEditDistance[0][j] = j;
        }

        for (int i = 1; i <= firstStr.length(); i++) {
            minEditDistance[i][0] = i;
        }

        for (int i = 1; i <= firstStr.length(); i++) {
            for (int j = 1; j <= secondStr.length(); j++) {
                if (firstStr.charAt(i-1) == secondStr.charAt(j-1)) {
                    minEditDistance[i][j] = minEditDistance[i-1][j-1];
                } else {
                    minEditDistance[i][j] = Math.min(
                            Math.min(
                                    1 + minEditDistance[i][j-1], // insert char
                                    1 + minEditDistance[i-1][j]  // delete char
                            ),
                            1 + minEditDistance[i-1][j-1] // update char
                    );
                }
            }
        }

        return minEditDistance[firstStr.length()][secondStr.length()];
    }

    public static void main(String[] args) {
        Assert.equals(1, minEditDistance("a", "aa"));
        Assert.equals(3, minEditDistance("casper", "crispr"));
    }
}
