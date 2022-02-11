package com.example.intent_filters_extra_task_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AlignActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);
        findViewById(R.id.text_start).setOnClickListener(this);
        findViewById(R.id.text_center).setOnClickListener(this);
        findViewById(R.id.text_end).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.text_start:
                intent.putExtra("align", "start");
                break;
            case R.id.text_center:
                intent.putExtra("align", "center");
                break;
            case R.id.text_end:
                intent.putExtra("align", "end");
                break;
            default:
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}