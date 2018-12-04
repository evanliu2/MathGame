package com.example.maththing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button row1col1;
    private Button row1col2;
    private Button row1col3;
    private Button row1col4;
    private Button row2col1;
    private Button row2col2;
    private Button row2col3;
    private Button row2col4;
    private Button row3col1;
    private Button row3col2;
    private Button row3col3;
    private Button row3col4;
    private Button buttonReset;
    private Button buttonAdd;
    private Button buttonSubtract;
    private Button buttonMultiply;
    private Button buttonDivide;
    private TextView textViewScore;
    private TextView textViewTargetNum;
    private TextView textViewUserInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent reset = new Intent();
                reset.setClass(MainActivity.this, MainActivity.class);
                MainActivity.this.startActivity(reset);
                MainActivity.this.finish();

            }
        });
    }

    private void wireWidgets() {

        row1col1 = findViewById(R.id.button_main_row1_col1);
        row1col2 = findViewById(R.id.button_main_row1_col2);
        row1col3 = findViewById(R.id.button_main_row1_col3);
        row1col4 = findViewById(R.id.button_main_row1_col4);
        row2col1 = findViewById(R.id.button_main_row2_col1);
        row2col2 = findViewById(R.id.button_main_row2_col2);
        row2col3 = findViewById(R.id.button_main_row2_col3);
        row2col4 = findViewById(R.id.button_main_row2_col4);
        row3col1 = findViewById(R.id.button_main_row3_col1);
        row3col2 = findViewById(R.id.button_main_row3_col2);
        row3col3 = findViewById(R.id.button_main_row3_col3);
        row3col4 = findViewById(R.id.button_main_row3_col4);
        buttonReset = findViewById(R.id.button_main_reset);
        buttonAdd = findViewById(R.id.button_main_addition);
        buttonSubtract = findViewById(R.id.button_main_subtraction);
        buttonMultiply = findViewById(R.id.button_main_multiplication);
        buttonDivide = findViewById(R.id.button_main_division);
        textViewScore = findViewById(R.id.textView_main_score);
        textViewTargetNum = findViewById(R.id.textView_main_targetNum);
        textViewUserInput = findViewById(R.id.textView_main_userinput);


    }


}
