package com.example.lottiedemo;

import java.util.ArrayList;
import java.util.List;

class MyLayer {

    public enum LayerType {
        SHAPE
    }

    private final List<MyContentModel> models = new ArrayList<>();
    private LayerType layerType = LayerType.SHAPE;

    LayerType getLayerType() {
        return layerType;
    }

    List<MyContentModel> getModels() {
        return models;
    }

    void addModel(MyContentModel contentModel) {
        models.add(contentModel);
    }

    String getName() {
        return "Layer";
    }
}
