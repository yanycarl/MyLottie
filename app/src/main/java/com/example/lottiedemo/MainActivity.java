package com.example.lottiedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    MyAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationView = findViewById(R.id.animation_view);
        animationView.setAnimation("p2.json");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationView.playAnimation();
            }
        });
    }
}
