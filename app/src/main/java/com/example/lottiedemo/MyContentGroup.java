package com.example.lottiedemo;

import android.graphics.Canvas;
import android.graphics.Matrix;

import java.util.ArrayList;
import java.util.List;

class MyContentGroup{

    private List<MyContent> contents;

    MyContentGroup(List<MyContentModel> contents) {
        List<MyContent> list = new ArrayList<>();
        for(MyContentModel contentModel: contents){
            list.add(contentModel.toContent());
        }
        this.contents = list;
    }

    void draw(Canvas canvas, Matrix parentMatrix, int parentAlpha, int index) {
        if(index >=0 && index < contents.size()){
            MyContent content = contents.get(index);
            if (content instanceof MyDrawingContent) {
                ((MyDrawingContent) content).draw(canvas, parentMatrix, parentAlpha);
            }
        }
    }
}
