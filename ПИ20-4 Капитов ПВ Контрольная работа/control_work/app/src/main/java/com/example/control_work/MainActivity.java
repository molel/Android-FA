package com.example.control_work;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner spinner_day;
    Spinner spinner_month;
    Spinner spinner_year;
    Spinner spinner_sex;

    ArrayAdapter<Integer> spinner_day_adapter;
    ArrayAdapter<String> spinner_month_adapter;
    ArrayAdapter<Integer> spinner_year_adapter;
    ArrayAdapter<String> spinner_sex_adapter;

    EditText edit_text_lying;
    EditText edit_text_standing;

    Button complete_button;

    Integer[] days = new Integer[31];
    String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    Integer[] years = new Integer[122];
    String[] sexes = {"М", "Ж"};

    int day;
    String month;
    int year;
    String sex;

    int lying_pulse;
    int standing_pulse;

    public static class Pair<T1, T2> {
        public T1 first;
        public T2 second;

        public Pair(T1 _first, T2 _second) {
            first = _first;
            second = _second;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_days_and_years();
        set_elements();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinner_day_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, get_days());
        spinner_day_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_day.setAdapter(spinner_day_adapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onClick(View view) {
        get_date();
        if (!check_pulse()) {
            change_border(R.drawable.circle_corners_incorrect);
            Toast.makeText(this, "Неверный ввод", Toast.LENGTH_SHORT).show();
        } else {
            get_pulse();

            Pair<Boolean, Double> test = orthostatic_test();
            boolean result_is_good = test.first;
            double percent = test.second;

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("result_is_good", result_is_good);
            intent.putExtra("percent", percent);
            startActivity(intent);
        }
    }

    public void add_days_and_years() {
        for (int i = 0; i < days.length; i++) {
            days[i] = i + 1;
        }

        for (int i = 0; i < years.length; i++) {
            years[i] = 2021 - i;
        }
    }

    public void set_elements() {
        spinner_year = findViewById(R.id.spinner_year);
        spinner_year_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        spinner_year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_year.setAdapter(spinner_year_adapter);
        spinner_year.setOnItemSelectedListener(this);

        spinner_month = findViewById(R.id.spinner_month);
        spinner_month_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        spinner_month_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_month.setAdapter(spinner_month_adapter);
        spinner_month.setOnItemSelectedListener(this);

        spinner_day = findViewById(R.id.spinner_day);
        spinner_day_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, get_days());
        spinner_day_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_day.setAdapter(spinner_day_adapter);

        spinner_sex = findViewById(R.id.spinner_sex);
        spinner_sex_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sexes);
        spinner_sex_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sex.setAdapter(spinner_sex_adapter);

        edit_text_lying = findViewById(R.id.lying_pulse);
        edit_text_standing = findViewById(R.id.standing_pulse);

        complete_button = findViewById(R.id.complete_button);
        complete_button.setOnClickListener(this);
    }

    public Integer[] get_days() {
        switch (spinner_month.getSelectedItem().toString()) {
            case "Апрель":
            case "Июнь":
            case "Сентябрь":
            case "Ноябрь":
                return Arrays.copyOfRange(days, 0, 30);
            case "Февраль":
                if (Integer.parseInt(spinner_year.getSelectedItem().toString()) % 4 == 0) {
                    return Arrays.copyOfRange(days, 0, 29);
                } else {
                    return Arrays.copyOfRange(days, 0, 28);
                }
            default:
                return Arrays.copyOfRange(days, 0, 31);
        }
    }

    public void get_date() {
        day = Integer.parseInt(spinner_day.getSelectedItem().toString());
        month = spinner_month.getSelectedItem().toString();
        year = Integer.parseInt(spinner_year.getSelectedItem().toString());
        sex = spinner_sex.getSelectedItem().toString();
    }

    public boolean check_pulse() {
        return is_Integer(edit_text_lying.getText().toString()) && is_Integer(edit_text_standing.getText().toString());
    }

    public boolean is_Integer(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void change_border(int drawable) {
        edit_text_lying.setBackgroundResource(drawable);
        edit_text_standing.setBackgroundResource(drawable);
    }

    public void get_pulse() {
        lying_pulse = Integer.parseInt(edit_text_lying.getText().toString());
        standing_pulse = Integer.parseInt(edit_text_standing.getText().toString());
    }

    public Pair<Boolean, Double> orthostatic_test() {
        int pulse_difference = Math.abs(standing_pulse - lying_pulse);
        int main_pulse = (lying_pulse + standing_pulse) / 2;
        int age = 2021 - year;
        double percent;
        if (sex.equals("М")) {
            percent = (double) pulse_difference / 30;
            if (age <= 17) {
                if (60 <= main_pulse && main_pulse <= 80) {
                    return new Pair<>(true, percent);
                }
            } else {
                if (age <= 40) {
                    if (55 <= main_pulse && main_pulse <= 100) {
                        return new Pair<>(true, percent);
                    }
                } else {
                    if (age <= 60) {
                        if (60 <= main_pulse && main_pulse <= 85) {
                            return new Pair<>(true, percent);
                        }
                    } else {
                        if (70 <= main_pulse && main_pulse <= 90) {
                            return new Pair<>(true, percent);
                        }
                    }
                }
            }
        } else {
            percent = (double) pulse_difference / 25;
            if (age <= 17) {
                if (60 <= main_pulse && main_pulse <= 80) {
                    return new Pair<>(true, percent);
                }
            } else {
                if (age <= 40) {
                    if (60 <= main_pulse && main_pulse <= 75) {
                        return new Pair<>(true, percent);
                    }
                } else {
                    if (age <= 60) {
                        if (75 <= main_pulse && main_pulse <= 85) {
                            return new Pair<>(true, percent);
                        }
                    } else {
                        if (80 <= main_pulse && main_pulse <= 90) {
                            return new Pair<>(true, percent);
                        }
                    }
                }
            }
        }
        return new Pair<>(false, percent);
    }
}