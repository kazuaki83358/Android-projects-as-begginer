package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvSplash,tvSubSplash;
    Animation atg,btgone,btgtwo;
    ImageView ivSplash;
    Button btnget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnget = findViewById(R.id.btnget);
        ivSplash = findViewById(R.id.ivSplash);

        //load animation
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);

        //passing animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgone);
        btnget.startAnimation(btgtwo);

        //passing action listener
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, stop_watch.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular= Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        //customizing size
        tvSplash.setTypeface(MLight);
        tvSubSplash.setTypeface(MMedium);
        btnget.setTypeface(MRegular);

    }
}