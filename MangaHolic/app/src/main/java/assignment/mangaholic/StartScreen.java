package assignment.mangaholic;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class StartScreen extends AppCompatActivity {

    private  static int DELAY_TIME = 2000;
    AnimationDrawable animation;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        getSupportActionBar().hide();
        imageView = (ImageView) findViewById(R.id.viewImage) ;
        if(imageView == null) throw new  AssertionError();
        imageView.setBackgroundResource(R.drawable.animation_loading);
        animation = (AnimationDrawable) imageView.getBackground();
        animation.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainScreen = new Intent(StartScreen.this, MainScreen.class);
                startActivity(mainScreen);
                finish();
            }
        },DELAY_TIME);
    }
}
