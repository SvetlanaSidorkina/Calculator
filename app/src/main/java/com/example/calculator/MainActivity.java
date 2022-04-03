package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textInput;
    private double number1;
    private double number2;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = findViewById(R.id.input_text);

        onClickNumber();
        onClickAction();

    }

    private void onClickNumber() {
        findViewById(R.id.digit_one_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "1"));
        findViewById(R.id.digit_two_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "2"));
        findViewById(R.id.digit_three_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "3"));
        findViewById(R.id.digit_four_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "4"));
        findViewById(R.id.digit_five_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "5"));
        findViewById(R.id.digit_six_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "6"));
        findViewById(R.id.digit_seven_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "7"));
        findViewById(R.id.digit_eight_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "8"));
        findViewById(R.id.digit_nine_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "9"));
        findViewById(R.id.digit_zero_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "0"));
    }

    private void onClickAction() {
        findViewById(R.id.multiply_operation_button).setOnClickListener(view -> {
            if (textInput == null) {
                textInput.setText("");
            } else {
                number1 = Double.parseDouble(textInput.getText() + "");
                textInput.setText(textInput.getText() + "*");
                operator = '*';
            }
        });

        findViewById(R.id.div_operation_button).setOnClickListener(view -> {
            if (textInput == null) {
                textInput.setText("");
            } else {
                number1 = Double.parseDouble(textInput.getText() + "");
                textInput.setText(textInput.getText() + "/");
                operator = '/';
            }
        });

        findViewById(R.id.deduct_operation_button).setOnClickListener(view -> {
            if (textInput == null) {
                textInput.setText("");
            } else {
                number1 = Double.parseDouble(textInput.getText() + "");
                textInput.setText(textInput.getText() + "-");
                operator = '-';
            }
        });

        findViewById(R.id.sum_operation_button).setOnClickListener(view -> {
            if (textInput == null) {
                textInput.setText("");
            } else {
                number1 = Double.parseDouble(textInput.getText() + "");
                textInput.setText(textInput.getText() + "+");
                operator = '+';
            }
        });

        findViewById(R.id.clear_input_value_button).setOnClickListener(view -> {
            String str = textInput.getText().toString();
            if (str.length() > 0) {
                textInput.setText(null);
            }
        });

        findViewById(R.id.del_button).setOnClickListener(view -> {
            String str = textInput.getText().toString();
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
                textInput.setText(str);
            }
        });

        findViewById(R.id.decimal_dot_button).setOnClickListener(view -> textInput.setText(textInput.getText() + "."));

        findViewById(R.id.calc_result_button).setOnClickListener(view -> {
            String str = textInput.getText().toString();
            number2 = Double.parseDouble(str.substring(str.lastIndexOf(operator) + 1));
            Calc result = new Calc(number1, number2);

            switch (operator) {
                case '+':
                    textInput.setText(new StringBuilder().append(result.add()));
                    break;
                case '-':
                    textInput.setText(new StringBuilder().append(result.deduct()));
                    break;
                case '*':
                    textInput.setText(new StringBuilder().append(result.multiply()));
                    break;
                case '/':
                    textInput.setText(new StringBuilder().append(result.div()));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
        });
    }
}