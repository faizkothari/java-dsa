package com.training;

import com.google.common.base.Preconditions;

/**
 * Compute the value at a row and column where the values follow the following pattern:
 *
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 * 1 6 15 20 15 6 1
 * 1 7 21 35 35 21 7 1
 *
 *
 * The pattern has following properties:
 *
 * - Assuming that the row and the column numbers start from 1, the number of columns in a row is
 *   equal to the row number.
 * - In a row the value of the first and last columns are always 1.
 * - In any row the value of a cell is the sum of its adjacent cells in the previous row.
 *   CellVal(RowNum, ColNum) = CellVal(RowNum - 1, ColNum - 1) + CellVal(RowNum - 1, ColNum)
 */
public class NumberPattern {

    /**
     * @param nRowNum Row number, assuming indexing starts from 1
     * @param nColNum Column number, assuming indexing starts from 1
     * @return value at a particular row and column.
     */
    public int getCellVall(int nRowNum, int nColNum) {
        Preconditions.checkArgument(nRowNum > 0);
        Preconditions.checkArgument(nColNum <= nRowNum);

        if (nRowNum < 3) {
            return 1;
        }

        int[] values = new int[nRowNum];
        values[0] = 1;
        values[1] = 1;

        for (int i = 2; i < nRowNum; i++) {
            for (int j = i - 1; j > 0; j--) {
                values[j] = values[j - 1] + values[j];
            }
            values[i] = 1;
        }

        return values[nColNum - 1];
    }
}
