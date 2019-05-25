package com.example.amit.islandsexerciseapp;

/**
 * Created by Amit on 25/05/2019.
 */

public class MainActivityPresenter {
    private static final String TAG = "MainActivityPresenter";
    private static final boolean SUCCESSFULLY_DONE = true;

    BoardManager mBoardManager = BoardManager.getInstance();

    /*package*/ boolean randomizeBoard(RowColumnPair boardSize) {
        if (boardSize.getRow() != mBoardManager.getBoardNumOfRows()
                || boardSize.getColumn() != mBoardManager.getBoardNumOfColumns()) {
            //board size requirement is different than current existing board
            try {
                mBoardManager.resetBoardDataAndSize(boardSize);
            } catch (Exception exception) {
                return (! SUCCESSFULLY_DONE);
            }
        }

        mBoardManager.populateBoardWithRandomValues();
        return (SUCCESSFULLY_DONE);
    }
}
