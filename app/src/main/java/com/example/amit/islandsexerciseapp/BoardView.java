package com.example.amit.islandsexerciseapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Amit on 27/05/2019.
 */

/*package*/ class BoardView extends View {
    static final int MIN_MARGIN_START_END = 30;
    static final int MIN_MARGIN_TOP_BOTTOM = 30;

    int mNumOfRows = 0;
    int mNumOfCols = 0;
    Paint mBordersPaint = new Paint();

    /*package*/ BoardView(Context context) {
        super(context);

        mBordersPaint.setColor(Color.BLACK);
        mBordersPaint.setStrokeWidth(8);
    }

    @Override
    public void onDraw(Canvas canvas) {

        if ((mNumOfRows == 0) || mNumOfCols == 0) {
            return;
        }

        float startX;
        float stopX;
        float startY;
        float stopY;

        int canvasWidth = canvas.getWidth() - (2 * MIN_MARGIN_START_END);
        int canvasHeight = canvas.getHeight() - (2 * MIN_MARGIN_TOP_BOTTOM);

        int gridSpacing;
        int maxGridSpacingHorizontal = canvasWidth/mNumOfCols;
        int maxGridSpacingVertical = canvasHeight/mNumOfRows;
        gridSpacing = Math.min(maxGridSpacingHorizontal, maxGridSpacingVertical);
        int boardTotalSizeHorizontal = mNumOfCols * gridSpacing;
        int boardTotalSizeVertical = mNumOfRows * gridSpacing;

        int marginOffsetStartEnd = MIN_MARGIN_START_END + (canvasWidth - boardTotalSizeHorizontal)/2;
        int marginOffsetTopBottom = MIN_MARGIN_TOP_BOTTOM + (canvasHeight - boardTotalSizeVertical)/2;

        //Vertical Grid-lines
        for (int i = 0; i <= mNumOfCols; i++) {

            startX = marginOffsetStartEnd + (i * gridSpacing);
            startY = marginOffsetTopBottom;

            stopX = startX;
            stopY = startY + boardTotalSizeVertical;

            canvas.drawLine(startX, startY, stopX, stopY, mBordersPaint);
        }

        //Horizontal Grid-lines
        for (int i = 0; i <= mNumOfRows; i++) {

            startX = marginOffsetStartEnd;
            startY = marginOffsetTopBottom + (i * gridSpacing);

            stopX = startX + boardTotalSizeHorizontal;
            stopY = startY;

            canvas.drawLine(startX, startY, stopX, stopY, mBordersPaint);
        }
    }

    /*package*/ void setNumRows(int rows) {
        mNumOfRows = rows;
    }

    /*package*/ void setNumColumns(int cols) {
        mNumOfCols = cols;
    }
}
