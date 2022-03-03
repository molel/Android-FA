package com.example.pop_up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnPopUp).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "This is pop-up notification", Toast.LENGTH_SHORT).show();
    }
}