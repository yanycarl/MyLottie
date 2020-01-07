package com.example.lottiedemo;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

import com.airbnb.lottie.animation.content.Content;

import java.util.ArrayList;
import java.util.List;

public class MyCompositionLayer extends MyBaseLayer {
    private final List<MyBaseLayer> layers = new ArrayList<>();

    MyCompositionLayer(MyLottieDrawable lottieDrawable, List<MyLayer> layerModels) {
        super(lottieDrawable, null);

        for (int i = layerModels.size() - 1; i >= 0; i--) {
            MyLayer lm = layerModels.get(i);
            MyBaseLayer layer = MyBaseLayer.forModel(lm, lottieDrawable);
            if (layer == null) {
                continue;
            }
            layers.add(layer);
        }
    }

    public void setProgress(float progress) {
        for (int i = layers.size() - 1; i >= 0; i--) {
            layers.get(i).setProgress(progress);
        }
    }

    @Override
    public void drawLayer(Canvas canvas, Matrix parentMatrix, int parentAlpha, int frame) {
        for (int i = layers.size() - 1; i >= 0; i--) {
            MyBaseLayer layer = layers.get(i);
            layer.draw(canvas, parentMatrix, parentAlpha);
        }
    }

    @Override
    public void getBounds(RectF outBounds, Matrix parentMatrix, boolean applyParents) {}

    @Override
    public void setContents(List<Content> contentsBefore, List<Content> contentsAfter) {}
}
