package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstAct extends AppCompatActivity {
    Animation bottomAnimation;
    TextView slogan;
    ImageView imageView;
   // Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        slogan = findViewById(R.id.tagLine);
        imageView = findViewById(R.id.img);


        imageView.animate().scaleX((float) 1.5).scaleY((float) 1.5).setDuration(5000).start();
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animantion);
        slogan.setAnimation(bottomAnimation);

        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(7000);
                    Intent intent=new Intent(getApplicationContext(), MainAct.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();


        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);*/


 /*try {
    timer=new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {

            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    },5000);
} catch (Exception e) {
    Toast.makeText(getApplicationContext(),e+" ",Toast.LENGTH_LONG).show();
}*/




    }
}