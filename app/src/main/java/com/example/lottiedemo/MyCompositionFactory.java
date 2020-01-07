package com.example.lottiedemo;

import android.graphics.Rect;

class MyCompositionFactory {

    private MyCompositionFactory() {
    }

    static MyComposition fromAsset() {
        MyComposition composition = new MyComposition();
        MyLayer layer = new MyLayer();
        for(int i=0; i<60; i++){
            Rect rect = new Rect(i+50, i+50, i*5+100, i*5+100);
            MyShapePath shapePath = new MyShapePath(rect);
            layer.addModel(shapePath);
        }
        composition.addLayer(layer);
        return composition;
    }
}
