package com.example.simple_data_storage_extra_task_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    final String DATA = "data";
    final String NAME = "name";
    final String GROUP = "group";
    final String AGE = "age";
    final String DATE = "date";
    final String IMAGE_PATH = "image";
    final String IMAGE_NAME = "image.jpeg";

    EditText etName, etDate;
    Spinner spGroup, spAge;
    ArrayAdapter<String> aaGroup;
    ArrayAdapter<String> aaAge;
    String[] groups = {"ПИ20-4", "ПИ20-5", "ПИ20-6"};
    String[] ages = new String[82];
    int currentGroupId, ageId;
    ImageView ivImage;
    Bitmap bmImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etDate = findViewById(R.id.etDate);

        spGroup = findViewById(R.id.spGroup);
        spAge = findViewById(R.id.spAge);


        for (int i = 0; i < ages.length; i++) {
            ages[i] = String.valueOf(i + 18);
        }

        aaGroup = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, groups);
        aaAge = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ages);

        aaGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aaAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spGroup.setAdapter(aaGroup);
        spAge.setAdapter(aaAge);

        spGroup.setSelection(0);
        spAge.setSelection(0);

        spGroup.setOnItemSelectedListener(this);
        spAge.setOnItemSelectedListener(this);

        findViewById(R.id.btnImage).setOnClickListener(this);

        ivImage = findViewById(R.id.ivImage);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);

        etName.setText(preferences.getString(NAME, ""));
        spGroup.setSelection(preferences.getInt(GROUP, 0));
        spAge.setSelection(preferences.getInt(AGE, 0));
        etDate.setText(preferences.getString(DATE, ""));
        loadImage(preferences.getString(IMAGE_PATH, ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferences = getPreferences(MODE_PRIVATE).edit();
        preferences.putString(NAME, etName.getText().toString());
        preferences.putInt(GROUP, currentGroupId);
        preferences.putInt(AGE, ageId);
        preferences.putString(DATE, etDate.getText().toString());
        preferences.putString(IMAGE_PATH, saveImage(bmImage));
        preferences.apply();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnImage) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
                Bundle bundle = data.getExtras();
                bmImage = (Bitmap) bundle.get(DATA);
                ivImage.setImageBitmap(bmImage);
            }
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (view.getId()) {
            case R.id.spGroup:
                currentGroupId = i;
                break;
            case R.id.spAge:
                ageId = i;
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void loadImage(String path) {
        try {
            bmImage = BitmapFactory.decodeStream(new FileInputStream(new File(path, IMAGE_NAME)));
            ivImage.setImageBitmap(bmImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String saveImage(Bitmap bitmap) {
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File directory = contextWrapper.getDir("imageDir", Context.MODE_PRIVATE);
        File path = new File(directory, IMAGE_NAME);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }
}