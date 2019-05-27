package com.example.amit.islandsexerciseapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Amit on 25/05/2019.
 */

public class BoardDisplayActivity extends AppCompatActivity {
    private static final String TAG = "BoardDisplayActivity";

    TextView mSolutionTextView;
    Button  mSolveBtn;
    Button  mRestartBtn;

    BoardManager mBoardManager = BoardManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_display);

        initViewMembers();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initViewMembers() {
        BoardView boardView = (BoardView) findViewById(R.id.board_bv);
        boardView.setNumColumns(mBoardManager.getBoardNumOfColumns());
        boardView.setNumRows(mBoardManager.getBoardNumOfRows());

        mSolveBtn = (Button) findViewById(R.id.solve_btn);
        mSolveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedSolveButton();
            }
        });

        mSolutionTextView = (TextView) findViewById(R.id.solution_txt);
        mRestartBtn = (Button) findViewById(R.id.restart_btn);
        mRestartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /*package*/ void onClickedSolveButton() {
        Log.v(TAG, "onClickedSolveButton() called");
        // TODO: 28/05/2019 data binding
        updateUIWithResult();
        updateUIAsDone();
    }

    private void updateUIWithResult() {
        int islandsNum = mBoardManager.countIslandsInBoard();
        String solutionText = String.format(getString(R.string.solution), islandsNum);
        mSolutionTextView.setText(solutionText);
    }

    private void updateUIAsDone() {
        mSolveBtn.setVisibility(View.INVISIBLE);
        mRestartBtn.setVisibility(View.VISIBLE);
    }
}
