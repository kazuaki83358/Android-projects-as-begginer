package com.example.fiirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fiirstapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = findViewById(R.id.button);
        Button skipButton = findViewById(R.id.button2);

        nextButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "please wait......", Toast.LENGTH_SHORT).show();
        });

        skipButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Skipping......", Toast.LENGTH_SHORT).show();
        });
    }
}
