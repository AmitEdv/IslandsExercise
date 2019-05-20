package com.example.amit.islandsexerciseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
   private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.v(TAG, "OnStart() called");
        super.onStart();

        IslandsBoard board = new IslandsBoard(1000, 1000);
        board.populateBoardWithRandomValues();
        int count = board.calcNumOfIsland();

        Log.v(TAG, "OnStart() count = " + count);
    }
}
