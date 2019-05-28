package com.example.amit.islandsexerciseapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Amit on 27/05/2019.
 */

 public class BoardView extends View {
    static final int MIN_MARGIN_START_END = 30;
    static final int MIN_MARGIN_TOP_BOTTOM = 30;
    static final int BORDERS_STROKE_WIDTH = 8;
    static final int CELL_VALUE_COLOR_BLACK = 1;

    private int[][] mboardMatrix;
    private int mNumOfRows = 0;
    private int mNumOfCols = 0;
    private int mGridSpacing = 0;
    private int mMarginOffsetStartEnd = 0;
    private int mMarginOffsetTopBottom = 0;
    private boolean mIsColorful = false;
    private Paint mBordersPaint = new Paint();
    private Paint mCellsPaint = new Paint();

    public BoardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        mBordersPaint.setColor(Color.BLACK);
        mBordersPaint.setStrokeWidth(BORDERS_STROKE_WIDTH);
    }

    @Override
    public void onDraw(Canvas canvas) {

        if ((mNumOfRows == 0) || mNumOfCols == 0) {
            return;
        }

        paintGrid(canvas);
        // TODO: 28/05/2019  This function should still be tested
        //paintCells(canvas);
    }

    /*package*/ void setMatrix(int[][] boardMatrix, int numOfRows, int numOfCols) {
        mboardMatrix = boardMatrix;
        mNumOfRows = numOfRows;
        mNumOfCols = numOfCols;
    }

    private void paintGrid(Canvas canvas) {
        float startX;
        float stopX;
        float startY;
        float stopY;

        int canvasWidth = canvas.getWidth() - (2 * MIN_MARGIN_START_END);
        int canvasHeight = canvas.getHeight() - (2 * MIN_MARGIN_TOP_BOTTOM);

        int maxGridSpacingHorizontal = canvasWidth/mNumOfCols;
        int maxGridSpacingVertical = canvasHeight/mNumOfRows;
        mGridSpacing = Math.min(maxGridSpacingHorizontal, maxGridSpacingVertical);
        int boardTotalSizeHorizontal = mNumOfCols * mGridSpacing;
        int boardTotalSizeVertical = mNumOfRows * mGridSpacing;

        mMarginOffsetStartEnd = MIN_MARGIN_START_END + (canvasWidth - boardTotalSizeHorizontal)/2;
        mMarginOffsetTopBottom = MIN_MARGIN_TOP_BOTTOM + (canvasHeight - boardTotalSizeVertical)/2;

        //Vertical Grid-lines
        for (int i = 0; i <= mNumOfCols; i++) {

            startX = mMarginOffsetStartEnd + (i * mGridSpacing);
            startY = mMarginOffsetTopBottom;

            stopX = startX;
            stopY = startY + boardTotalSizeVertical;

            canvas.drawLine(startX, startY, stopX, stopY, mBordersPaint);
        }

        //Horizontal Grid-lines
        for (int i = 0; i <= mNumOfRows; i++) {

            startX = mMarginOffsetStartEnd;
            startY = mMarginOffsetTopBottom + (i * mGridSpacing);

            stopX = startX + boardTotalSizeHorizontal;
            stopY = startY;

            canvas.drawLine(startX, startY, stopX, stopY, mBordersPaint);
        }
    }

    private void paintCells(Canvas canvas) {
        // TODO: 28/05/2019 This function should still be tested
        mCellsPaint.setColor(Color.BLACK);

        int cellWidth = mGridSpacing;
        int cellHeight = mGridSpacing;

        for (int row = 0; row <= mNumOfRows; row++) {
            for (int col = 0; col <= mNumOfCols; col++) {
                if (isCellColored(row, col)) {
                    canvas.drawRect(row * cellWidth, col * cellHeight,
                            (row + 1) * cellWidth, (col + 1) * cellHeight,
                            mCellsPaint);
                }
            }
        }
    }

    private boolean isCellColored(int row, int col) {
        // TODO: 28/05/2019 determine the color of the cell according to its value
        // use intdef
        return (mboardMatrix[row][col] == CELL_VALUE_COLOR_BLACK);
    }
}
