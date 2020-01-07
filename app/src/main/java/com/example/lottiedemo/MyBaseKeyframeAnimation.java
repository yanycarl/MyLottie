package com.example.lottiedemo;

import androidx.lifecycle.MutableLiveData;

public abstract class MyBaseKeyframeAnimation {

    int size;

    private MutableLiveData<Integer> frame = new MutableLiveData<>();


    public MyBaseKeyframeAnimation(int size){
        this.size = size;
    }

    public MutableLiveData<Integer> getProgress() {
        return frame;
    }

    void setProgress(float progress){
        int frame = (int)(size*progress);
        this.frame.postValue(frame);
    }
}

