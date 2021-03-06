package com.singh.aakash.dbconnector;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by aakash on 01-10-2015.
 */
public class CategoryRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    public static interface OnItemClickListener {

        public void onItemClick(View view, int position);

        public void onItemLongClick(View view, int position);

    }

    private OnItemClickListener mListener;
    private GestureDetector mGestureDetector;

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public CategoryRecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && mListener != null) {
                    mListener.onItemLongClick(childView, recyclerView.getChildPosition(childView));
                }
            }
        });

    }

    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (mListener != null && childView != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildPosition(childView));
        }
        return false;
    }

    public void onTouchEvent(RecyclerView view,MotionEvent e){

    }

}

