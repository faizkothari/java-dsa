package com.training;

import java.util.Arrays;

/**
 * Given string eg: nnfddf Find the longest possible substring with no repeating characters.
 *
 * Time to solve 32 min (28 min to solve and 4 min to test and fix)
 */
public class LongestSubstringProblem {

    // Driver program
    public static void main(String[] args) {
        System.out.println(solution1("nnfddf"));
        System.out.println(solution1("abcdefgh"));
        System.out.println(solution1("hfkjsdhljfhjlsagfjkhgshfgjhkgshfhjkagfgh"));
        System.out.println(solution1("nnnnabbcd"));
    }

    // Time complexity: O(n)
    // Space complexity: Constant
    public static String solution1(String str) {

        if (str.length() == 1) {
            return str;
        }

        boolean[] isCharSet = new boolean[26];
        Arrays.fill(isCharSet, false);

        int start = 0;
        int end = 1;

        int maxLen = 1;
        int maxStart = 0;
        int maxEnd = 1;

        isCharSet[str.charAt(start) - 'a'] = true;

        while (end < str.length()) {
            if (isCharSet[str.charAt(end) - 'a']) {
                // character already seen
                // update max if possible
                // start = end
                // clear set

                if ((end - start) > maxLen) {
                    maxLen = end - start;
                    maxStart = start;
                    maxEnd = end;
                }

                start = end;

                clearSet(isCharSet);
            }

            isCharSet[str.charAt(end) - 'a'] = true;
            end++;
        }

        if ((end - start) > maxLen) {
            maxLen = end - start;
            maxStart = start;
            maxEnd = end;
        }

        return str.substring(maxStart, maxEnd);
    }

    private static void clearSet(boolean[] set) {
        Arrays.fill(set, false);
    }
}
