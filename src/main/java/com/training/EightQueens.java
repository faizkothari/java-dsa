package com.training;

import java.util.Arrays;

public class EightQueens {
    /**
     * Solves the 8 Queens problem, i.e. tries to find all the possible ways
     * in which 8 Queens can be placed on an 8x8 chess board such that they
     * don't cancel each other out.
     *
     * @return The total number of possible ways
     */
    public static int solve() {

        int[] board = new int[8];
        Arrays.fill(board, -1);
        int possibilities = 0;
        for (int i = 0; i < board.length; i++) {
            possibilities += put(0, i, board); // keep adding possibilities
            board[0] = -1;
        }
        return possibilities;
    }

    /**
     * Tries to place a queen at a particular cell. If success, continues recursively
     * and returns the total number of possible solutions under this particular
     * placement of the queen.
     *
     * @param row   row index
     * @param col   column index
     * @param board chess board representing the placement of queens
     * @return
     */
    private static int put(final int row, final int col, int[] board) {
        int possibilities = 0;

        if (!underAttack(row, col, board)) {
            board[row] = col; // put the queen at that row and column.

            if (row == board.length - 1) {
                return 1;
            }

            for (int i = 0; i < board.length; i++) {
                possibilities += put(row + 1, i, board); // accumulate possibilities
                board[row + 1] = -1;
            }
        }

        return possibilities;
    }

    /**
     * Each integer in board represents the column number and it's position represents the row.
     * Using an 8 element array instead of 8x8 matrix, saves memory.
     * This method checks whether a queen at a particular row and column is under attack or not.
     *
     * @param row   row index
     * @param col   column index
     * @param board chess board representing the placement of queens
     * @return true if queen is under attack, else false
     */
    private static boolean underAttack(int row, int col, int[] board) {
        // Check if any queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i] == col) {
                return true;
            }
        }

        // check if any queen in top left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i] == j) {
                return true;
            }
        }

        // check if any queen in top right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i] == j) {
                return true;
            }
        }

        return false;
    }
}