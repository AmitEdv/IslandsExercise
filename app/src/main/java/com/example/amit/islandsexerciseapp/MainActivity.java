package com.example.amit.islandsexerciseapp;

import android.content.Intent;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.*;
import android.view.View;
import android.widget.EditText;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

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

    void onClickedRandomizeButton(View view) {
        Log.v(TAG, "onClickedRandomizeButton() called");
        RowColumnPair pair = getBoardSizeInput();

        if (! mPresenter.randomizeBoard(pair)) {
            // TODO: 25/05/2019 Handle logic failure
            Log.e(TAG, "onClickedRandomizeButton() could not randomize board!");
            return;
        }

        startBoardDisplayActivity();
    }

    /*package*/  void initViewMembers() {
        mBoardSizeInputET = (EditText) findViewById(R.id.board_size_input_et);
    }

    /*package*/ RowColumnPair getBoardSizeInput() {
        Log.v(TAG, "getBoardSizeInput() called");
        int num_of_rows = 0;
        int num_of_cols = 0;

        String[] input_tokens = mBoardSizeInputET.getText().toString().split(", ");
        if (input_tokens.length != NUM_OF_INPUT_PARAMS) {
            // TODO: 25/05/2019 Handle input failure
            Log.e(TAG, "getBoardSizeInput() input format is incorrect. Required: n, m");
            return new RowColumnPair(num_of_rows,num_of_cols);
        }

        try {
            num_of_rows = Integer.valueOf(input_tokens[BOARD_SIZE_INPUT_INDEX_ROWS]);
            num_of_cols = Integer.valueOf(input_tokens[BOARD_SIZE_INPUT_INDEX_COLUMNS]);
        } catch (NumberFormatException exception) {
            // TODO: 25/05/2019 Handle input failure
            Log.e(TAG, "getBoardSizeInput() input params should be integers. Required: n, m");
        }

        Log.v(TAG, "getBoardSizeInput() rows input = " + num_of_rows + " cols input = " + num_of_cols);
        return new RowColumnPair(num_of_rows,num_of_cols);
    }

    private void startBoardDisplayActivity() {
        Intent intent = new Intent(this, BoardDisplayActivity.class);
        startActivity(intent);
    }

}
