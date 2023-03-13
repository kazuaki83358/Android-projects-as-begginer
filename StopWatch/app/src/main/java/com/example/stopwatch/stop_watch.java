package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class stop_watch extends AppCompatActivity {
    Button btnstart,btnstop;
    ImageView icacnhor;
    Animation roundingalone;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        //finding objects by their id
        btnstart = findViewById(R.id.btnstart);
        icacnhor = findViewById(R.id.icacnhor);
        btnstop = findViewById(R.id.btnstop);
        timerHere = findViewById(R.id.timerHere);

        //create optional animation
        btnstop.setAlpha(0);

        //loading animation
        roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundingalone);

        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        //passing font to button
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        //setting OnClickListener for start button
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icacnhor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).setDuration(80).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                //starting timer
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });

        //setting OnClickListener for stop button
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icacnhor.clearAnimation();
                btnstart.animate().alpha(1).setDuration(300).start();
                btnstop.animate().alpha(0).setDuration(80).start();
                //stopping timer
                timerHere.stop();
                timerHere.setBase(SystemClock.elapsedRealtime());
            }
        });

    }
}
