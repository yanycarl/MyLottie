package com.example.lottiedemo;

import java.util.ArrayList;
import java.util.List;

public class MyComposition {

    private List<MyLayer> myLayerList = new ArrayList<>();

    public void addLayer(MyLayer layer){
        myLayerList.add(layer);
    }

    public List<MyLayer> getLayers() {
        return myLayerList;
    }
}
