package com.example.lottiedemo;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyLottieDrawable extends Drawable implements Drawable.Callback, Animatable {

    private final ValueAnimator animator = new ValueAnimator();
    private MyCompositionLayer compositionLayer;
    private MyComposition composition;

    MyLottieDrawable() {
        ValueAnimator.AnimatorUpdateListener progressUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (compositionLayer != null) {
                    compositionLayer.setProgress((Float) animator.getAnimatedValue());
                }
            }
        };
        animator.addUpdateListener(progressUpdateListener);
    }

    void setComposition(MyComposition composition) {
        this.composition = composition;
        buildCompositionLayer();
        updateBounds();
    }

    private void updateBounds() {
        setBounds(0, 0, 500, 500);
    }

    private void buildCompositionLayer() {
        compositionLayer = new MyCompositionLayer(this, composition.getLayers());
    }

    public void invalidateSelf() {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    private void drawInternal(@NonNull Canvas canvas) {
        drawWithOriginalAspectRatio(canvas);
    }

    private void drawWithOriginalAspectRatio(Canvas canvas) {
        compositionLayer.draw(canvas, null, 255);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        drawInternal(canvas);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void invalidateDrawable(@NonNull Drawable who) {

    }

    @Override
    public void scheduleDrawable(@NonNull Drawable who, @NonNull Runnable what, long when) {

    }

    @Override
    public void unscheduleDrawable(@NonNull Drawable who, @NonNull Runnable what) {

    }

    void playAnimation(){
        animator.setDuration(5000);
        animator.setFloatValues(0.0F, 0.1F, 0.2F, 0.3F, 0.4F, 0.5F, 0.6F, 0.7F, 0.8F, 0.9F, 0.99F);
        animator.start();
    }
}
