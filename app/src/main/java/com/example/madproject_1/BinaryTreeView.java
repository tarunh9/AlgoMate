package com.example.madproject_1;


import android.content.Context;
import android.graphics.Canvas;

import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class BinaryTreeView extends View {
    int TREE_SIZE;
    private BinarySearchTree tree = null;
    private ArrayList<Integer> searchSequence = null;
    private int searchPosition;

    public BinaryTreeView(Context context) {
        super(context);
        //this.textView = textView;
    }

    public void initialize(ArrayList listt) {
        tree = new BinarySearchTree();
        TREE_SIZE=listt.size();
        for (int i=0;i<listt.size();i++) {
            tree.insert((Integer) listt.get(i));
        }
        tree.positionNodes(this.getWidth());

        searchSequence=listt;
        searchPosition = 0;
        //updateMessage();
        invalidate();
    }

//    private ArrayList<Integer> generateRandomSequence(int size,ArrayList str) {
//        ArrayList<Integer> numbers = new ArrayList<>(size);
//        for (int i :str) {
//            numbers.add(i);
//        }
//        //Collections.shuffle(numbers);
//        return numbers;
//    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas) {
        if (tree != null) {
            tree.draw(canvas);
        }
    }

//    private void updateMessage() {
//        if (searchPosition < searchSequence.size())
//            textView.setText("Looking for node " + searchSequence.get(searchPosition));
//        else
//            textView.setText("Done!");
//    }

    public boolean onTouchEvent(MotionEvent event) {
        if (tree != null && searchPosition < searchSequence.size()) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    int targetValue = searchSequence.get(searchPosition);
                    int hitValue = tree.click(event.getX(), event.getY(), targetValue);
                    if (hitValue != -1) {
                        invalidate();
                        if (hitValue != targetValue) {
                            tree.invalidateNode(targetValue);
                            searchSequence.remove(new Integer(hitValue));
                        }
                        //Log.v("message", searchSequence+"\t\tsize="+searchSequence.size()+"\nhitvalue="+hitValue+"\ttargetvalue"+targetValue+"\tsearchposition"+searchPosition);
                        searchPosition++;
                        //updateMessage();
                        return true;
                    }
            }
        }
        return super.onTouchEvent(event);
    }
}

