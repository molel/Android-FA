package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button digit_0, digit_1, digit_2, digit_3, digit_4, digit_5, digit_6, digit_7, digit_8, digit_9;
    Button plus, minus, multiply, divide, evaluate, open_bracket, close_bracket;
    EditText line;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        digit_0 = findViewById(R.id.digit_0);
        digit_1 = findViewById(R.id.digit_1);
        digit_2 = findViewById(R.id.digit_2);
        digit_3 = findViewById(R.id.digit_3);
        digit_4 = findViewById(R.id.digit_4);
        digit_5 = findViewById(R.id.digit_5);
        digit_6 = findViewById(R.id.digit_6);
        digit_7 = findViewById(R.id.digit_7);
        digit_8 = findViewById(R.id.digit_8);
        digit_9 = findViewById(R.id.digit_9);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        open_bracket = findViewById(R.id.open_bracket);
        close_bracket = findViewById(R.id.close_bracket);
        evaluate = findViewById(R.id.evaluate);
        line = findViewById(R.id.line);


        digit_0.setOnClickListener(v -> line.setText(line.getText().toString() + "0"));
        digit_1.setOnClickListener(v -> line.setText(line.getText().toString() + "1"));
        digit_2.setOnClickListener(v -> line.setText(line.getText().toString() + "2"));
        digit_3.setOnClickListener(v -> line.setText(line.getText().toString() + "3"));
        digit_4.setOnClickListener(v -> line.setText(line.getText().toString() + "4"));
        digit_5.setOnClickListener(v -> line.setText(line.getText().toString() + "5"));
        digit_6.setOnClickListener(v -> line.setText(line.getText().toString() + "6"));
        digit_7.setOnClickListener(v -> line.setText(line.getText().toString() + "7"));
        digit_8.setOnClickListener(v -> line.setText(line.getText().toString() + "8"));
        digit_9.setOnClickListener(v -> line.setText(line.getText().toString() + "9"));
        plus.setOnClickListener(v -> line.setText(line.getText().toString() + "+"));
        minus.setOnClickListener(v -> line.setText(line.getText().toString() + "-"));
        multiply.setOnClickListener(v -> line.setText(line.getText().toString() + "*"));
        divide.setOnClickListener(v -> line.setText(line.getText().toString() + "/"));
        evaluate.setOnClickListener(v -> line.setText(line.getText().toString() + "/"));
        open_bracket.setOnClickListener(v -> line.setText(line.getText().toString() + "("));
        close_bracket.setOnClickListener(v -> line.setText(line.getText().toString() + ")"));
        evaluate.setOnClickListener(v -> {
            double answer = eval(line.getText().toString());
            if (answer % 1 == 0) {
                line.setText(String.valueOf((int) answer));
            } else {
                line.setText(String.valueOf(answer));
            }
        });
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }


            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    switch (func) {
                        case "sqrt":
                            x = Math.sqrt(x);
                            break;
                        case "sin":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "cos":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "tan":
                            x = Math.tan(Math.toRadians(x));
                            break;
                        default:
                            throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}