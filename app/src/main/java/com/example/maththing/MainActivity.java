package com.example.maththing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> numbers, luckyNumbers, operations; // 1 -> +, 2 -> -, 3 -> *, 4 -> /
    private Button N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, reset, add, subt, mult, div;
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

        N1.setText("" + numbers.get(0));
        N2.setText("" + numbers.get(1));
        N3.setText("" + numbers.get(2));
        N4.setText("" + numbers.get(3));
        N5.setText("" + numbers.get(4));
        N6.setText("" + numbers.get(5));
        N7.setText("" + numbers.get(6));
        N8.setText("" + numbers.get(7));
        N9.setText("" + numbers.get(8));
        N10.setText("" + numbers.get(9));
        N11.setText("" + numbers.get(10));
        N12.setText("" + numbers.get(11));

    }

    private void wireWidgets() {
        N1 = findViewById(R.id.button_main_num1);
        N2 = findViewById(R.id.button_main_num2);
        N3 = findViewById(R.id.button_main_num3);
        N4 = findViewById(R.id.button_main_num4);
        N5 = findViewById(R.id.button_main_num5);
        N6 = findViewById(R.id.button_main_num6);
        N7 = findViewById(R.id.button_main_num7);
        N8 = findViewById(R.id.button_main_num8);
        N9 = findViewById(R.id.button_main_num9);
        N10 = findViewById(R.id.button_main_num10);
        N11 = findViewById(R.id.button_main_num11);
        N12 = findViewById(R.id.button_main_num12);
        reset = findViewById(R.id.button_main_reset);
        add = findViewById(R.id.button_main_add);
        subt = findViewById(R.id.button_main_subt);
        mult = findViewById(R.id.button_main_mult);
        div = findViewById(R.id.button_main_div);
        targetNum = findViewById(R.id.textView_main_targetNum);
    }

}
