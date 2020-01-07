package com.example.lottiedemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

public class MyShapePath extends MyContentModel implements MyContent, MyDrawingContent {

    private Rect rect;

    MyShapePath(Rect rect){
        this.rect = rect;
    }

    @Override
    public void draw(Canvas canvas, Matrix parentMatrix, int alpha) {
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawRect(rect, paint);
    }

    @Override
    public MyContent toContent() {
        return this;
    }
}
