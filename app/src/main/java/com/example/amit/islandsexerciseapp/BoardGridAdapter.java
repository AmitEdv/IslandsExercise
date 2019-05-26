package com.example.amit.islandsexerciseapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Amit on 26/05/2019.
 */

class BoardGridAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<Integer> mBoardCells;

    BoardGridAdapter(Context context, ArrayList<Integer> cells) {
        mContext = context;
        mBoardCells = cells;
    }

    @Override
    public int getCount() {
        return mBoardCells.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Integer cell = mBoardCells.get(position);
        LinearLayout cellView = new LinearLayout(mContext);
        cellView.setMinimumHeight(15);
        cellView.setMinimumWidth(15);
        @ColorInt int cellColor = Color.WHITE; // cell == IslandsBoard.CELL_VALUE_WATER
        if (cell == IslandsBoard.CELL_VALUE_PART_OF_ISLAND) {
            cellColor = Color.BLACK;
        }

        cellView.setBackgroundColor(cellColor);
        return cellView;
    }

}

