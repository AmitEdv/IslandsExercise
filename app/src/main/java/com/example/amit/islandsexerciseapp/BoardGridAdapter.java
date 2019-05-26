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
    private View mCellView;
    private LinearLayout mCellLayout;

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
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mCellView = inflater.inflate(R.layout.item_board_cell_water, null);
        mCellLayout = (LinearLayout) mCellView.findViewById(R.id.item_board_cell_ll);

        Integer cell = mBoardCells.get(position);
        @ColorInt int cellColor = Color.WHITE; // cell == IslandsBoard.CELL_VALUE_WATER
        if (cell == IslandsBoard.CELL_VALUE_PART_OF_ISLAND) {
            cellColor = Color.BLACK;
        }

        mCellLayout.setBackgroundColor(cellColor);
        return mCellView;
    }

}

