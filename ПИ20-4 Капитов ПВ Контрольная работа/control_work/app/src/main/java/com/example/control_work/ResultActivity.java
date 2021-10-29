package com.example.control_work;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    ScrollView scroll_view;
    TextView heading;
    TextView advice;
    ProgressBar progress_bar;
    TextView description;
    ImageView icon;

    boolean result_is_good;
    double percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle arguments = getIntent().getExtras();
        result_is_good = (boolean) arguments.get("result_is_good");
        percent = (double) arguments.get("percent");

        scroll_view = findViewById(R.id.scroll_view);
        heading = findViewById(R.id.heading);
        advice = findViewById(R.id.advice);
        progress_bar = findViewById(R.id.progress_bar);
        description = findViewById(R.id.description);
        icon = findViewById(R.id.icon);

        progress_bar.setProgress((int) (percent * 100));

        if (result_is_good) {
            scroll_view.setBackgroundResource(R.drawable.gradient_green_to_blue);
            advice.setText(R.string.advice_good);
            description.setText(R.string.good_results);
            icon.setImageResource(R.drawable.good_result);
        } else {
            heading.setTextColor(getResources().getColor(R.color.white));
            scroll_view.setBackgroundResource(R.drawable.gradient_red_to_orange);
            advice.setText(R.string.advice_bad);
            description.setText(R.string.bad_results);
            icon.setImageResource(R.drawable.bad_result);
        }
    }
}
