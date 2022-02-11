package com.example.simple_data_storage_extra_task_3;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String CROSS = "✖";
    final String ZERO = "⭘";
    final String EMPTY = "";
    final String BTN11 = "btn11", BTN12 = "btn12", BTN13 = "btn13";
    final String BTN21 = "btn21", BTN22 = "btn22", BTN23 = "btn23";
    final String BTN31 = "btn31", BTN32 = "btn32", BTN33 = "btn33";
    final String MOVES = "moves";
    final int CELLS = 9;
    String[] BUTTONS = {BTN11, BTN12, BTN13, BTN21, BTN22, BTN23, BTN31, BTN32, BTN33};
    Button btn11, btn12, btn13;
    Button btn21, btn22, btn23;
    Button btn31, btn32, btn33;
    Button[] buttons;
    int moves = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);
        btn23 = findViewById(R.id.btn23);
        btn31 = findViewById(R.id.btn31);
        btn32 = findViewById(R.id.btn32);
        btn33 = findViewById(R.id.btn33);

        buttons = new Button[]{btn11, btn12, btn13, btn21, btn22, btn23, btn31, btn32, btn33};

        for (Button button : buttons) {
            button.setOnClickListener(this);
        }

        clear();

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        for (int i = 0; i < CELLS; i++) {
            buttons[i].setText(preferences.getString(BUTTONS[i], ""));
        }
        moves = preferences.getInt(MOVES, 0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferences = getPreferences(MODE_PRIVATE).edit();
        for (int i = 0; i < CELLS; i++) {
            preferences.putString(BUTTONS[i], buttons[i].getText().toString());
        }
        preferences.putInt(MOVES, moves);
        preferences.apply();
    }

    public void check(Button first, Button second, Button third) {
        if (first.getText().toString().equals(second.getText().toString()) && second.getText().toString().equals(third.getText().toString()) && !first.getText().toString().equals(EMPTY)) {
            Toast.makeText(getApplicationContext(), "Игрок " + first.getText().toString() + " одержал победу!", Toast.LENGTH_LONG).show();
            clear();
        } else if (moves == 9) {
            Toast.makeText(getApplicationContext(), "Ничья!", Toast.LENGTH_LONG).show();
            clear();
        }
    }

    public void setChar(Button button) {
        if (button.getText().toString().equals(EMPTY)) {
            if (moves % 2 == 0) {
                button.setText(CROSS);
            } else {
                button.setText(ZERO);
            }
            moves++;
        }
    }

    public void clear() {
        for (Button button : buttons) {
            button.setText(EMPTY);
        }
        moves = 0;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn11:
                setChar(btn11);
                check(btn11, btn12, btn13);
                check(btn11, btn22, btn33);
                check(btn11, btn21, btn31);
                break;
            case R.id.btn12:
                setChar(btn12);
                check(btn11, btn12, btn13);
                check(btn12, btn22, btn32);
                break;
            case R.id.btn13:
                setChar(btn13);
                check(btn11, btn12, btn13);
                check(btn13, btn22, btn31);
                check(btn13, btn23, btn33);
                break;
            case R.id.btn21:
                setChar(btn21);
                check(btn11, btn21, btn31);
                check(btn21, btn22, btn23);
                break;
            case R.id.btn22:
                setChar(btn22);
                check(btn11, btn22, btn33);
                check(btn31, btn22, btn13);
                check(btn21, btn22, btn23);
                check(btn12, btn22, btn32);
                break;
            case R.id.btn23:
                setChar(btn23);
                check(btn13, btn23, btn33);
                check(btn21, btn22, btn23);
                break;
            case R.id.btn31:
                setChar(btn31);
                check(btn11, btn21, btn31);
                check(btn13, btn22, btn31);
                check(btn31, btn32, btn32);
                break;
            case R.id.btn32:
                setChar(btn32);
                check(btn31, btn32, btn33);
                check(btn12, btn22, btn32);
                break;
            case R.id.btn33:
                setChar(btn33);
                check(btn31, btn32, btn33);
                check(btn11, btn22, btn33);
                check(btn13, btn23, btn33);
                break;
        }
    }
}