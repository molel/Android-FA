package com.example.intent_filters_extra_task_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.cont);
        textView = findViewById(R.id.text);
        findViewById(R.id.color).setOnClickListener(this);
        findViewById(R.id.align).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.color:
                Intent color_intent = new Intent(this, ColorActivity.class);
                startActivityForResult(color_intent, 1);
                break;
            case R.id.align:
                Intent align_intent = new Intent(this, AlignActivity.class);
                startActivityForResult(align_intent, 2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case 1:
                    int colorInt = data.getIntExtra("color", -1);
                    if (colorInt != -1) {
                        textView.setTextColor(colorInt);
                    }
                    break;
                case 2:
                    switch (data.getStringExtra("align")) {
                        case "start":
                            layout.setGravity(Gravity.START);
                            break;
                        case "center":
                            layout.setGravity(Gravity.CENTER);
                            break;
                        case "end":
                            layout.setGravity(Gravity.END);
                            break;
                    }
            }
        }
    }
}