package com.example.control_work;

import android.os.Bundle;
import android.util.Log;
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

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = getIntent().getExtras().getString(StringStorage.INTENT_KEY);

        scroll_view = findViewById(R.id.scroll_view);
        heading = findViewById(R.id.heading);
        advice = findViewById(R.id.advice);
        progress_bar = findViewById(R.id.progress_bar);
        description = findViewById(R.id.description);
        icon = findViewById(R.id.icon);
        advice.setText(result);
        heading.setTextColor(getResources().getColor(R.color.black));
        switch (result) {
            case StringStorage.GOOD_RESULT:
                progress_bar.setProgress(90);
                description.setText(R.string.good_results);
                scroll_view.setBackgroundResource(R.drawable.gradient_green_to_blue);
                icon.setImageResource(R.drawable.good_result);
                break;
            case StringStorage.MEDIUM_RESULT:
                progress_bar.setProgress(55);
                description.setText(R.string.medium_results);
                scroll_view.setBackgroundResource(R.drawable.gradient_green_to_blue);
                icon.setImageResource(R.drawable.good_result);
                break;
            case StringStorage.BAD_RESULT:
                progress_bar.setProgress(20);
                description.setText(R.string.bad_results);
                scroll_view.setBackgroundResource(R.drawable.gradient_red_to_orange);
                icon.setImageResource(R.drawable.bad_result);
                break;
            case StringStorage.ERROR_RESULT:
                progress_bar.setProgress(0);
                description.setText(R.string.error_results);
                scroll_view.setBackgroundResource(R.drawable.gradient_red_to_orange);
                icon.setImageResource(R.drawable.bad_result);
                break;
        }
//        progress_bar.setProgress((int) (percent * 100));
//
//        if (result_is_good) {
//            scroll_view.setBackgroundResource(R.drawable.gradient_green_to_blue);
//            advice.setText(R.string.advice_good);
//            description.setText(R.string.good_results);
//            icon.setImageResource(R.drawable.good_result);
//        } else {
//            heading.setTextColor(getResources().getColor(R.color.white));
//            scroll_view.setBackgroundResource(R.drawable.gradient_red_to_orange);
//            advice.setText(R.string.advice_bad);
//            description.setText(R.string.bad_results);
//            icon.setImageResource(R.drawable.bad_result);
//        }
    }
}
