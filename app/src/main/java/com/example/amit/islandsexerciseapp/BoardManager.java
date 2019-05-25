package com.example.amit.islandsexerciseapp;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Amit on 25/05/2019.
 */
/*package*/ class BoardManager {
    private static final String TAG = "BoardManager";
    private static BoardManager ourInstance = new BoardManager();

    @Nullable private IslandsBoard mBoard;

    /*package*/ static BoardManager getInstance() {
        return ourInstance;
    }

    private BoardManager() {}

    /*package*/ int getBoardNumOfRows() {
        return (mBoard == null ? 0 : mBoard.getNumOfRows());
    }

    /*package*/ int getBoardNumOfColumns() {
        return (mBoard == null ? 0 : mBoard.getNumOfColumns());
    }

    /*package*/ void resetBoardDataAndSize(RowColumnPair boardRequiredSize) throws Exception{
        Log.v(TAG, "resetBoardDataAndSize() called");
        if ((boardRequiredSize.getRow() <= 0)
                || (boardRequiredSize.getColumn() <= 0))
        {
            String msg = "resetBoardDataAndSize() illegal size, dimensions must be positive";
            Log.e(TAG, msg);
            throw new Exception(msg);
        }

        mBoard = new IslandsBoard(boardRequiredSize.getRow(), boardRequiredSize.getColumn());
    }

    /*package*/ void populateBoardWithRandomValues() {
        Log.v(TAG, "populateBoardWithRandomValues() called");
        mBoard.populateBoardWithRandomValues();
    }

    /*package*/ int countIslandsInBoard() {
        int count = mBoard.calcNumOfIsland();
        Log.v(TAG, "countIslandsInBoard() count = " + count);
        return count;
    }
}
