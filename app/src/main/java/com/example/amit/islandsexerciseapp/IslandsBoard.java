package com.example.amit.islandsexerciseapp;

import android.util.Log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Amit on 20/05/2019.
 */

public class IslandsBoard {
    private static final String TAG = "IslandsBoard";

    /*package*/ static final Integer CELL_VALUE_WATER = 0;
    /*package*/ static final Integer CELL_VALUE_PART_OF_ISLAND = 1;
    private static final int[] ADJACENT_ROWS = { -1, -1, -1, 0, 1, 0, 1, 1 };
    private static final int[] ADJACENT_COLS = { -1, 1, 0, -1, -1, 1, 0, 1 };

    private final int mBoard[][];
    private final int mNumOfRows;
    private final int mNumOfCols;

    /*package*/ IslandsBoard(int num_of_rows, int num_of_columns) {
        mBoard = new int[num_of_rows][num_of_columns];
        this.mNumOfRows = num_of_rows;
        this.mNumOfCols = num_of_columns;
    }

    /*package*/ int getNumOfRows() { return mNumOfRows; }
    /*package*/ int getNumOfColumns() { return mNumOfCols; }

    /*package*/ ArrayList<Integer> toArray() {
        ArrayList<Integer> boardArray = new ArrayList<>();
        for (int i = 0; i < mNumOfRows; i++) {
            for (int j = 0; j < mNumOfCols; j++) {
                boardArray.add(mBoard[i][j]);
            }
        }

        return boardArray;
    }

    /*package*/ void populateBoardWithRandomValues() {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < mNumOfRows; i++) {
            for (int j = 0; j < mNumOfCols; j++) {
                Integer r = rand.nextInt() % 2;
                mBoard[i][j] = Math.abs(r);
            }
        }
    }

    /*package*/ int calcNumOfIsland() {
        boolean[][] processed = new boolean[mNumOfRows][mNumOfCols];

        int island = 0;
        for (int i = 0; i < mNumOfRows; i++) {
            for (int j = 0; j < mNumOfCols; j++) {
                // start BFS from each unprocessed node and
                // increment island count
                if (mBoard[i][j] == 1 && !processed[i][j])
                {
                    BFS(processed, i, j);
                    island++;
                }
            }
        }

        return island;
    }

    //Debug usage only
    private void printBoardToLogs() {
        for (int i = 0; i < mNumOfRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int num : mBoard[i]) {
                list.add(num);
            }

            Log.v(TAG, "" +  list.toString());
        }
    }

    private void BFS(boolean[][] processed, int row, int col) {
        // create an empty queue and enqueue source node
        Queue<RowColumnPair> q = new ArrayDeque<>();
        q.add(new RowColumnPair(row, col));

        // mark source node as processed
        processed[row][col] = true;

        // run till queue is not empty
        while (!q.isEmpty())
        {
            // pop front node from queue and process it
            int x = q.peek().getRow();
            int y = q.peek().getColumn();
            q.poll();

            // check for all 8 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 8; k++) {
                // Skip if location is invalid or already processed or has water
                if (isSafe(x + ADJACENT_ROWS[k], y + ADJACENT_COLS[k], processed)) {
                    // skip if location is invalid or it is already
                    // processed or consists of water
                    processed[x + ADJACENT_ROWS[k]][y + ADJACENT_COLS[k]] = true;
                    q.add(new RowColumnPair(x + ADJACENT_ROWS[k], y + ADJACENT_COLS[k]));
                }
            }
        }
    }

    private boolean isSafe(int row, int col, boolean[][] processed) {
        return ((row >= 0) && (row < processed.length)
                && (col >= 0) && (col < processed[0].length)
                && (mBoard[row][col] == 1 && !processed[row][col]));
    }
}
