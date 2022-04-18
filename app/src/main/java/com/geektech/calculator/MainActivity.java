package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer firstVar, secondVar;
    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                //Нажал на единицу
                setNumber("1");
//                if (textView.getText().toString().equals("0")){
//                    textView.setText("1");
//                }else if (isOperationClick){
//                    textView.setText("1");
//                }else {
//                    textView.append("1");
//                }
//                isOperationClick = false;
                break;
            case R.id.btn_two:
                //нажал на двойку
                setNumber("2");
                isOperationClick = false;
                break;
            case R.id.btn_clear:
                //нажал на очистить
                textView.setText("0");
                firstVar = 0;
                secondVar = 0;
                break;
        }
    }

    private void setNumber(String number){
        if (textView.getText().toString().equals("0")){
            textView.setText(number);
        }else if (isOperationClick){
            textView.setText(number);
        }else {
            textView.append(number);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.btn_plus:
                //нажал на +
                firstVar = Integer.parseInt(textView.getText().toString());
                isOperationClick = true;
                break;
            case R.id.btn_equal:
                //нажал на =
                secondVar = Integer.parseInt(textView.getText().toString());
                Integer result = firstVar + secondVar;
                textView.setText(result.toString());
                isOperationClick = true;
                break;
        }
    }
}