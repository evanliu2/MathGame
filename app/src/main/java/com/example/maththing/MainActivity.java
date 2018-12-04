package com.example.maththing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> numbers, luckyNumbers, operations; // 1 -> +, 2 -> -, 3 -> *, 4 -> /
    private Button row1col1, row1col2, row1col3, row1col4, row2col1, row2col2, row2col3, row2col4, row3col1, row3col2, row3col3, row3col4, reset, add, subt, mult, div;
    private int target;
    private Boolean redo = true;
    private TextView targetNum;

    // modify based on level difficulties
    private int operationNum = 4;
    private int range = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        createComponents();

    }

    private void createComponents() {
        ArrayList<Integer> selector = new ArrayList<>();
        numbers = new ArrayList<>();
        luckyNumbers = new ArrayList<>();
        operations = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            numbers.add((int)(Math.random()*range + 1));
            selector.add(i);
        }
        for (int i = 1; i <= operationNum; i++) {
            operations.add((int)(Math.random()*operationNum + 1));
        }

        row1col1.setText("" + numbers.get(0));
        row1col2.setText("" + numbers.get(1));
        row1col3.setText("" + numbers.get(2));
        row1col4.setText("" + numbers.get(3));
        row2col1.setText("" + numbers.get(4));
        row2col2.setText("" + numbers.get(5));
        row2col3.setText("" + numbers.get(6));
        row2col4.setText("" + numbers.get(7));
        row3col1.setText("" + numbers.get(8));
        row3col2.setText("" + numbers.get(9));
        row3col3.setText("" + numbers.get(10));
        row3col4.setText("" + numbers.get(11));

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
        reset = findViewById(R.id.button_main_reset);
        add = findViewById(R.id.button_main_add);
        subt = findViewById(R.id.button_main_subt);
        mult = findViewById(R.id.button_main_mult);
        div = findViewById(R.id.button_main_div);
        targetNum = findViewById(R.id.textView_main_targetNum);


    }


}
