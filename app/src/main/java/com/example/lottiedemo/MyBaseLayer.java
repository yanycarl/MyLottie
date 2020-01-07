package com.example.lottiedemo;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.DrawingContent;
import java.util.ArrayList;
import java.util.List;

public abstract class MyBaseLayer implements DrawingContent {

    private final List<MyBaseKeyframeAnimation> animations = new ArrayList<>();
    private MyLottieDrawable lottieDrawable;
    private MyLayer layerModel;
    MyContentGroup contentGroup;

    @SuppressLint("RestrictedApi")
    private final Paint clearPaint = new LPaint(PorterDuff.Mode.CLEAR);
    private final RectF rect = new RectF();

    private int frame;

    private Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onChanged(Integer intValue) {
            MyBaseLayer.this.frame  = intValue;
            invalidateSelf();
        }
    };

    static MyBaseLayer forModel(MyLayer layerModel, MyLottieDrawable drawable) {
        if (layerModel.getLayerType() == MyLayer.LayerType.SHAPE) {
            return new MyShapeLayer(drawable, layerModel);
        }
        return null;
    }

    MyBaseLayer(MyLottieDrawable lottieDrawable, @Nullable MyLayer layerModel) {
        this.layerModel = layerModel;
        this.lottieDrawable = lottieDrawable;
        if(layerModel != null){
            addAnimation(new MyShapeKeyFrameAnimation(layerModel.getModels().size()));
        }
    }

    private void addAnimation(MyBaseKeyframeAnimation animation){
        animations.add(animation);
        animation.getProgress().observeForever(observer);
    }

    private void invalidateSelf() {
        lottieDrawable.invalidateSelf();
    }

    public void setProgress(@FloatRange(from = 0f, to = 1f) float progress){
        for (int i = 0; i < animations.size(); i++) {
            animations.get(i).setProgress(progress);
        }
    }

    @Override
    public void draw(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        clearCanvas(canvas);
        drawLayer(canvas, parentMatrix, 255, this.frame);
    }

    private void clearCanvas(Canvas canvas) {
        canvas.drawRect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1, clearPaint);
    }

    public abstract void drawLayer(Canvas canvas, Matrix parentMatrix, int parentAlpha, int frame);

    @Override
    public String getName() {
        return layerModel.getName();
    }
}
