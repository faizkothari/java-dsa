package com.training.interviewbit.dp;

/**
 * https://www.interviewbit.com/problems/interleaving-strings/
 *
 * Given A, B, C, find whether C is formed by the interleaving of A and B.
 */
public class InterleavingStrings {

    public static int solve(String a, String b, String c) {

        final int TRUE = 1;
        final int FALSE = 0;

        // bail out early
        if ((a.length() + b.length()) != c.length()) {
            return FALSE;
        }

        Boolean[][] il = new Boolean[a.length() + 1][b.length() + 1];
        il[0][0] = true; // when both strings are empty

        // When string A is empty
        for (int i = 1; i <= a.length(); i++) {
            il[i][0] = il[i-1][0] && (a.charAt(i-1) == c.charAt(i-1));
        }

        // When string B is empty
        for (int j = 1; j <= b.length(); j++) {
            il[0][j] = il[0][j-1] && (b.charAt(j-1) == c.charAt(j-1));
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                char charInC = c.charAt(i + j - 1);
                if (a.charAt(i-1) == charInC && b.charAt(j-1) != charInC) {
                    // include character from string A
                    il[i][j] = il[i-1][j];
                }

                if (a.charAt(i-1) != charInC && b.charAt(j-1) == charInC) {
                    // include character from string B
                    il[i][j] = il[i][j-1];
                }

                if (a.charAt(i-1) == charInC && b.charAt(j-1) == charInC) {
                    // include character from string A or string B
                    il[i][j] = il[i-1][j] || il[i][j-1];
                }

                if (a.charAt(i-1) != charInC && b.charAt(j-1) != charInC) {
                    // exclude character from both strings
                    il[i][j] = false;
                }
            }
        }

        return il[a.length()][b.length()] ? TRUE : FALSE;
    }

    public static void main(String[] args) {
        System.out.println(solve("aa", "b", "baa"));
    }
}
