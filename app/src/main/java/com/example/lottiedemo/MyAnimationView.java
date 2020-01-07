package com.example.lottiedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;

public class MyAnimationView extends AppCompatImageView {

    final MyLottieDrawable lottieDrawable = new MyLottieDrawable();
    LottieTask<MyComposition> compositionTask;
    MyComposition myComposition;

    private final LottieListener<MyComposition> loadedListener = new LottieListener<MyComposition>() {
        @Override public void onResult(MyComposition composition) {
            setComposition(composition);
        }
    };

    private final LottieListener<Throwable> wrappedFailureListener = new LottieListener<Throwable>() {
        @Override
        public void onResult(Throwable result) {
            Log.d("yanyao", "failed");
        }
    };

    public MyAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        setLayerType(2, null);
        setScaleType(ScaleType.FIT_CENTER);
    }

    public void setAnimation(final String assetName) {
//        LottieTask<MyComposition> task = MyCompositionFactory.fromAsset(getContext(), assetName);
//        setCompositionTask(task);
        myComposition = MyCompositionFactory.fromAsset();
        setComposition(myComposition);
    }

    private void setCompositionTask(LottieTask<MyComposition> compositionTask) {
        this.compositionTask = compositionTask
                .addListener(loadedListener)
                .addFailureListener(wrappedFailureListener);
    }

    public void setComposition(@NonNull MyComposition composition) {
        lottieDrawable.setCallback(this);
        lottieDrawable.setComposition(composition);
        setImageDrawable(lottieDrawable);
    }

    public void playAnimation() {
        lottieDrawable.playAnimation();
    }
}
