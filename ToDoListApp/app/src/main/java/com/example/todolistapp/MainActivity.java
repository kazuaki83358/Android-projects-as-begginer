package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvSplash,tvSubSplash;
    ImageView ivSplash;
    Button btnget;
    Animation utd,utd1,utd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        //giving value using R.id
        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        ivSplash = findViewById(R.id.ivSplash);
        btnget = findViewById(R.id.btnget);

        //now that animation folder we make in res time to load the animation
        utd = AnimationUtils.loadAnimation(this,R.anim.utd);
        utd1 = AnimationUtils.loadAnimation(this,R.anim.utd1);
        utd2 = AnimationUtils.loadAnimation(this,R.anim.utd2);

        //now passing the animation
        ivSplash.startAnimation(utd);
        tvSplash.startAnimation(utd1);
        tvSubSplash.startAnimation(utd1);
        btnget.startAnimation(utd2);

        //passing events
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, Home_Page.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }
}