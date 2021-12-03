package com.example.work_with_images_main_task;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String extraWeek = "currentWeekArrayList";
    String extraImportant = "importantArrayList";

    ArrayList<String> currentWeek = new ArrayList<>();
    ArrayList<String> important = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCurrentWeek).setOnClickListener(this);
        findViewById(R.id.btnImportant).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btnCurrentWeek:
                intent = new Intent(this, CurrentWeekActivity.class);
                break;
            case R.id.btnImportant:
                intent = new Intent(this, ImportantActivity.class);
                break;
        }
        if (currentWeek != null) {
            intent.putExtra(extraWeek, currentWeek);
        }
        if (important != null) {
            intent.putExtra(extraImportant, important);
        }
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                currentWeek = data.getExtras().getStringArrayList(extraWeek);
                important = data.getExtras().getStringArrayList(extraImportant);
            }
        }
    }
}