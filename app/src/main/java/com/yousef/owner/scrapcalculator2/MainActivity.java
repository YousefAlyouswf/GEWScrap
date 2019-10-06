package com.yousef.owner.scrapcalculator2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int Start_Screen = 3000;

    private TextView textView;
    private ImageView imageView;
    private LinearLayout green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.starttext);
        imageView = findViewById(R.id.imageView2);
        green = findViewById(R.id.back);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        textView.startAnimation(animation);
        imageView.startAnimation(animation);
        green.startAnimation(animation);
        animate();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, Home.class);
                startActivity(homeIntent);
                finish();
            }
        }, Start_Screen);
    }

    public void animate() {
        Animation animation=new TranslateAnimation(Animation.ABSOLUTE,Animation.ABSOLUTE,Animation.ABSOLUTE,-1200);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        green.startAnimation(animation);
    }

}
