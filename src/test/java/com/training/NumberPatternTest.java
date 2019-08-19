package com.training;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberPatternTest {

    @Test
    public void verify() {
        NumberPattern numberPattern = new NumberPattern();

        assertEquals(1, numberPattern.getCellVall(1, 1));
        assertEquals(1, numberPattern.getCellVall(2, 1));
        assertEquals(1, numberPattern.getCellVall(2, 2));
        assertEquals(1, numberPattern.getCellVall(3, 1));
        assertEquals(2, numberPattern.getCellVall(3, 2));
        assertEquals(1, numberPattern.getCellVall(3, 3));
        assertEquals(20, numberPattern.getCellVall(7, 4));
        assertEquals(35, numberPattern.getCellVall(8, 5));
        assertEquals(35, numberPattern.getCellVall(8, 4));
        assertEquals(70, numberPattern.getCellVall(9, 5));
    }
}
