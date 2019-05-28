package com.example.amit.islandsexerciseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final int NUM_OF_INPUT_PARAMS = 2;
    private static final int BOARD_SIZE_INPUT_INDEX_ROWS = 0;
    private static final int BOARD_SIZE_INPUT_INDEX_COLUMNS = 1;

    MainActivityPresenter mPresenter = new MainActivityPresenter();
    EditText mBoardSizeInputET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewMembers();
    }

    @Override
    protected void onStart() {
        Log.v(TAG, "OnStart() called");
        super.onStart();
    }

    /*package*/  void initViewMembers() {
        mBoardSizeInputET = (EditText) findViewById(R.id.board_size_input_et);
        Button randomizeBtn = (Button)  findViewById(R.id.randomize_btn);
        randomizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedRandomizeButton();
            }
        });
    }

    /*package*/ void onClickedRandomizeButton() {
        Log.v(TAG, "onClickedRandomizeButton() called");
        RowColumnPair pair = getBoardSizeInput();

        if (! mPresenter.randomizeBoard(pair)) {
            // TODO: 25/05/2019 Handle logic failure
            Log.e(TAG, "onClickedRandomizeButton() could not randomize board!");
            return;
        }

        startBoardDisplayActivity();
    }

    /*package*/ RowColumnPair getBoardSizeInput() {
        Log.v(TAG, "getBoardSizeInput() called");
        int numOfRows = 0;
        int numOfCols = 0;

        String[] input_tokens = mBoardSizeInputET.getText().toString().split(", ");
        if (input_tokens.length != NUM_OF_INPUT_PARAMS) {
            // TODO: 25/05/2019 Handle input failure
            Log.e(TAG, "getBoardSizeInput() input format is incorrect. Required: n, m");
            return new RowColumnPair(numOfRows,numOfCols);
        }

        try {
            numOfRows = Integer.valueOf(input_tokens[BOARD_SIZE_INPUT_INDEX_ROWS]);
            numOfCols = Integer.valueOf(input_tokens[BOARD_SIZE_INPUT_INDEX_COLUMNS]);
        } catch (NumberFormatException exception) {
            // TODO: 25/05/2019 Handle input failure
            Log.e(TAG, "getBoardSizeInput() input params should be integers. Required: n, m");
        }

        Log.v(TAG, "getBoardSizeInput() rows input = " + numOfRows + " cols input = " + numOfCols);
        return new RowColumnPair(numOfRows,numOfCols);
    }

    private void startBoardDisplayActivity() {
        Intent intent = new Intent(this, BoardDisplayActivity.class);
        startActivity(intent);
    }

}
