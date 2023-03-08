package com.example.digitalclock;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {
    TextClock textClock,textampm,textdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        textClock = findViewById(R.id.textclockid);
        textampm =findViewById(R.id.textampmid);
        textdate = findViewById(R.id.textdateid);
        Typeface myfont = Typeface.createFromAsset(getApplication().getAssets(), "Fonts/digitalfont.ttf");
        textClock.setTypeface(myfont);
        textdate.setTypeface(myfont);
        textampm.setTypeface(myfont);


    }
}