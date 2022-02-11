package com.example.main_elements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    Button button;
    EditText editText;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList arrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.add_to_list);
        editText = findViewById(R.id.list_edit_text);
        listView = findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this::onItemClick);
    }

    @Override
    public void onClick(View view) {
        arrayList.add(editText.getText().toString());
        editText.setText(R.string.empty);
        Collections.sort(arrayList);
        arrayAdapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        arrayList.remove(position);
        arrayAdapter.notifyDataSetChanged();
    }
}