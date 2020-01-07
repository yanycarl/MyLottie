package com.example.lottiedemo;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

import com.airbnb.lottie.animation.content.Content;

import java.util.List;

public class MyShapeLayer extends MyBaseLayer {

    MyShapeLayer(MyLottieDrawable lottieDrawable, MyLayer layerModel) {
        super(lottieDrawable, layerModel);
        contentGroup = new MyContentGroup(layerModel.getModels());
    }

    @Override
    public void setProgress(float progress) {
        super.setProgress(progress);
    }

    @Override
    public void drawLayer(Canvas canvas, Matrix parentMatrix, int parentAlpha, int frame) {
        contentGroup.draw(canvas, parentMatrix, parentAlpha, frame);
    }

    @Override
    public void getBounds(RectF outBounds, Matrix parentMatrix, boolean applyParents) {}

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setContents(List<Content> contentsBefore, List<Content> contentsAfter) {}
}
