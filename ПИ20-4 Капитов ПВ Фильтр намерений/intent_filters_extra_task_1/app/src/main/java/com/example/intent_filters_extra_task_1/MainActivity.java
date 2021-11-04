package com.example.intent_filters_extra_task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text = findViewById(R.id.edit_text);
        findViewById(R.id.button).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String url = edit_text.getText().toString();
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://" + url;
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}