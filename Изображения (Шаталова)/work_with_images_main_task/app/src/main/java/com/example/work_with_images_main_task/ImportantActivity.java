package com.example.work_with_images_main_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ImportantActivity extends AppCompatActivity implements View.OnClickListener {
    String extraWeek = "currentWeekArrayList";
    String extraImportant = "importantArrayList";

    EditText editText;
    ListView listView;
    ArrayList arrayListWeek, arrayListImportant;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important);
        listView = findViewById(R.id.lvImportant);

        Intent intent = getIntent();
        arrayListWeek = intent.getStringArrayListExtra(extraWeek);
        arrayListImportant = intent.getStringArrayListExtra(extraImportant);

        findViewById(R.id.btnImportant).setOnClickListener(this);
        if (arrayListImportant == null) {
            arrayListImportant = new ArrayList();
        }
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListImportant);
        listView.setAdapter(arrayAdapter);

        editText = findViewById(R.id.etImportant);
    }

    @Override
    public void onClick(View view) {
        arrayListImportant.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        Intent intent = new Intent();
        intent.putExtra(extraImportant, arrayListImportant);
        intent.putExtra(extraWeek, arrayListWeek);
        setResult(RESULT_OK, intent);
        finish();
    }
}