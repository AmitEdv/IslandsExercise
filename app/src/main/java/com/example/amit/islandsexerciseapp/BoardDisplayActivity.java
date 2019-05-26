package com.example.amit.islandsexerciseapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * Created by Amit on 25/05/2019.
 */

public class BoardDisplayActivity extends AppCompatActivity {
    private static final String TAG = "BoardDisplayActivity";

    GridView mGridView;
    BoardGridAdapter mBoardGridAdapter;
    BoardManager mBoardManager = BoardManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_display);

        initViewMembers();
    }

    private void initViewMembers() {
        Log.v(TAG, "initViewMembers() called");
        mGridView = (GridView) findViewById(R.id.board_gv);
        mBoardGridAdapter = new BoardGridAdapter(this, mBoardManager.getBoardAsArray());
        mGridView.setAdapter(mBoardGridAdapter);
        mGridView.setNumColumns(mBoardManager.getBoardNumOfColumns());
    }


}
