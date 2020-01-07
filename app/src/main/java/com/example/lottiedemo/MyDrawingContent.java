package com.example.lottiedemo;

import android.graphics.Canvas;
import android.graphics.Matrix;

public interface MyDrawingContent {
    void draw(Canvas canvas, Matrix matrix, int alpha);
}
