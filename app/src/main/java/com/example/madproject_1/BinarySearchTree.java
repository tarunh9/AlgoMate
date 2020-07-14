package com.example.madproject_1;


import android.graphics.Canvas;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class BinarySearchTree {
    private TreeNode root = null;

    public BinarySearchTree() {
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        } else {
            root.insert(value);
        }
    }

    public void positionNodes(int width) {
        if (root != null)
            root.positionSelf(0, width, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void draw(Canvas c) {
        root.draw(c);
    }

    public int click(float x, float y, int target) {
        return root.click(x, y, target);
    }

    private TreeNode search(int value) {
        TreeNode current = root;
        while (current != null)
        {
            if(value == current.getValue())
                break;
            else if(value < current.getValue())
                current = current.left;
            else
                current = current.right;
        }
        return current;
    }
    public void invalidateNode(int targetValue) {
        TreeNode target = search(targetValue);
        if(target != null)
            target.invalidate();
    }
}
