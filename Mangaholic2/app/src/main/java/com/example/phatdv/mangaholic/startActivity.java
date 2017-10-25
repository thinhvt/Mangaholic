package com.example.phatdv.mangaholic;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class startActivity extends AppCompatActivity {
    private  static int DELAY_TIME = 4000;
    AnimationDrawable animation;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
        imageView = (ImageView) findViewById(R.id.viewImage) ;
        if(imageView == null) throw new  AssertionError();
        imageView.setBackgroundResource(R.drawable.animation_loading);
        animation = (AnimationDrawable) imageView.getBackground();
        animation.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(startActivity.this, MainActivity.class);
                startActivity(homeIntent);

                finish();
            }
        },DELAY_TIME);
    }
}
