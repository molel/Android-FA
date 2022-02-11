package com.example.clicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mainText;
    ImageButton increaseButton, decreaseButton, resetButton;
    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = findViewById(R.id.mainTxt);
        increaseButton = findViewById(R.id.plus);
        decreaseButton = findViewById(R.id.minus);
        resetButton = findViewById(R.id.reset);
        View.OnClickListener clickListenerPlus = v -> {
            score++;
            String str = make_text(score);
            mainText.setText(str.toCharArray(), 0, str.length());
        };
        increaseButton.setOnClickListener(clickListenerPlus);
        View.OnClickListener clickListenerMinus = v -> {
            score--;
            String str = make_text(score);
            mainText.setText(str.toCharArray(), 0, str.length());
        };
        decreaseButton.setOnClickListener(clickListenerMinus);
        View.OnClickListener clickListenerReset = v -> {
            score = 0;
            String str = make_text(score);
            mainText.setText(str.toCharArray(), 0, str.length());
        };
        resetButton.setOnClickListener(clickListenerReset);
    }

    public static String make_text(long number) {

        if ((Math.abs(number) >= 2 && Math.abs(number) <= 4) || (Math.abs(number) >= 22 && Math.abs(number) % 10 >= 2 && Math.abs(number) % 10 <= 4)) {
            return "Кликов: " + number + " раза";
        } else {
            return "Кликов: " + number + " раз";
        }
    }
}