package com.example.intent_filters_extra_task_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        findViewById(R.id.red).setOnClickListener(this);
        findViewById(R.id.green).setOnClickListener(this);
        findViewById(R.id.blue).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.red:
                intent.putExtra("color", Color.RED);
                break;
            case R.id.green:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.blue:
                intent.putExtra("color", Color.BLUE);
                break;
            default:
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }

}