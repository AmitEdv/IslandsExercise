package com.example.amit.islandsexerciseapp;

/**
 * Created by Amit on 25/05/2019.
 */

 /*package*/ class RowColumnPair {
    private final int ROW;
    private final int COLUMN;

    /*package*/ RowColumnPair(int row, int col) {
        this.ROW = row;
        this.COLUMN = col;
    }

    /*package*/ int getRow() {
        return this.ROW;
    }

    /*package*/ int getColumn() { return this.COLUMN; }
}
