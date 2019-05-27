package com.example.amit.islandsexerciseapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Amit on 25/05/2019.
 */

public class BoardDisplayActivity extends AppCompatActivity {
    private static final String TAG = "BoardDisplayActivity";

    BoardManager mBoardManager = BoardManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BoardView boardView = new BoardView(this);
        boardView.setNumColumns(mBoardManager.getBoardNumOfColumns());
        boardView.setNumRows(mBoardManager.getBoardNumOfRows());
        setContentView(boardView);

        //initViewMembers();
    }

    private void initViewMembers() {


    }


}
