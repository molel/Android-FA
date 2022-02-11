package com.example.extra_tasks_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        TextView textView = findViewById(R.id.username);
        textView.setText(String.format("Ваше имя: %s", username));
    }
}