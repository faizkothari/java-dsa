package com.training;

public class Driver {
    public static void main(String[] args) {
        int eightQueensSol = EightQueens.solve();
        System.out.println("Number of possible solutions for Eight Queens problem: " + eightQueensSol);
    }
}
