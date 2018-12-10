package com.example.maththing;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> numbers, luckyNumbers, operations; // 1 -> +, 2 -> -, 3 -> *, 4 -> /
    private Button row1col1, row1col2, row1col3, row1col4, row2col1, row2col2, row2col3, row2col4, row3col1, row3col2, row3col3, row3col4, reset, add, subt, mult, div;
    private int target;
    private TextView targetNum;

    // Timer
    private TextView timer;
    private long startTime = 0;
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timer.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    // Modify based on level difficulties
    private int operationNum = 4;
    private int range = 10;
    private int specialNum = (int)(Math.pow(range*1.0, operationNum*1.0)+1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        createComponents();
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);

    }

    private void createComponents() {
        numbers = new ArrayList<>();
        luckyNumbers = new ArrayList<>();
        operations = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            numbers.add((int) (Math.random() * range + 1));
        }
        for (int i = 1; i <= operationNum; i++) {
            operations.add((int) (Math.random() * operationNum + 1));
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

        ArrayList<Integer> selector = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            selector.add(i); // selector: 0 -> 11
        }
        for (int i = 1; i <= operationNum + 1; i++) {
            int index = (int) (Math.random() * (selector.size() - 1));
            luckyNumbers.add(numbers.get(index));
            selector.remove(index);
        }
        target = luckyNumbers.get(0);

        for (int i = 1; i <= operationNum; i++) {
            int backUp = target;
            target = calculate(target, luckyNumbers.get(i), operations.get(i - 1));
            if (target == specialNum) {
                target = backUp;
                operations.set(i-1, (int)(Math.random()*operationNum + 1));
                i--;
            }
        }


        targetNum.setText("" + target);
    }

    private int calculate(int num1, int num2, int operation) {
        if (operation == 1) {
            return num1 + num2;
        } else if (operation == 2) {
            if (num1 - num2 >= 0) {
                return num1 - num2;
            } else {
                return specialNum;
            }
        } else if (operation == 3) {
            return num1 * num2;
        } else if (operation == 4) {
            if (num1 >= num2 && num1%num2 == 0) {
                return num1/num2;
            } else {
                return specialNum;
            }
        }
        return specialNum;
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
        add = findViewById(R.id.button_main_addition);
        subt = findViewById(R.id.button_main_subtraction);
        mult = findViewById(R.id.button_main_multiplication);
        div = findViewById(R.id.button_main_division);
        targetNum = findViewById(R.id.textView_main_targetNum);
        timer = findViewById(R.id.textView_main_timer);

    }


}
