package com.example.maththing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> numbers, luckyNumbers, operations; // 1 -> +, 2 -> -, 3 -> *, 4 -> /
    private Button row1col1, row1col2, row1col3, row1col4, row2col1, row2col2, row2col3, row2col4, row3col1, row3col2, row3col3, row3col4, reset, add, subt, mult, div;
    private int target;
    private Boolean redo = true;
    private TextView targetNum, userInput;
    private Boolean numClicked1 = false;
    private Boolean numClicked2 = false;
    private Boolean operationClicked = false;
    private int num1;
    private int num2;
    private int operation;
    private int randNumRow1Col1;
    private int randNumRow1Col2;
    private int randNumRow1Col3;
    private int randNumRow1Col4;
    private int randNumRow2Col1;
    private int randNumRow2Col2;
    private int randNumRow2Col3;
    private int randNumRow2Col4;
    private int randNumRow3Col1;
    private int randNumRow3Col2;
    private int randNumRow3Col3;
    private int randNumRow3Col4;



    // modify based on level difficulties
    private int operationNum = 4;
    private int range = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        createComponents();

        row1col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(numClicked1 == false)
               {
                   num1 = randNumRow1Col1;
                   numClicked1 = true;
               }

               else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
               {
                   num2 = randNumRow1Col1;
                   userInput.setText(calculate(num1, num2, operation));
                   num1 = 0;
                   num2 = 0;
                   numClicked1 = false;
                   numClicked2 = false;
               }

            }
        });

        row1col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow1Col2;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow1Col2;
                    userInput.setText(calculate(num1, num2, operation) + "");
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row1col3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow1Col3;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow1Col3;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row1col4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow1Col4;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow1Col4;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row2col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow2Col1;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow2Col1;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row2col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow2Col2;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow2Col2;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row2col3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow2Col3;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow2Col3;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row2col4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow2Col4;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow2Col4;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row3col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow3Col1;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow3Col1;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row3col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow3Col2;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow3Col2;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row3col3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow3Col3;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow3Col3;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        row3col4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(numClicked1 == false)
                {
                    num1 = randNumRow3Col4;
                    numClicked1 = true;
                }

                else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
                {
                    num2 = randNumRow3Col4;
                    userInput.setText(calculate(num1, num2, operation));
                    num1 = 0;
                    num2 = 0;
                    numClicked1 = false;
                    numClicked2 = false;
                }

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numClicked1 == true && operationClicked == false && numClicked2 == false)
                {
                    operation = 1;
                    operationClicked = true;
                }
            }
        });

        subt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numClicked1 == true && operationClicked == false && numClicked2 == false)
                {
                    operation = 2;
                    operationClicked = true;
                }
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numClicked1 == true && operationClicked == false && numClicked2 == false)
                {
                    operation = 3;
                    operationClicked = true;
                }

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numClicked1 == true && operationClicked == false && numClicked2 == false)
                {
                    operation = 4;
                    operationClicked = true;
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userInput.setText("");
                num1 = 0;
                num2 = 0;
                operation = 4;
                numClicked1 = false;
                numClicked2 = false;
                operationClicked = false;

            }
        });
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

        randNumRow1Col1 = numbers.get(0);
        randNumRow1Col2 = numbers.get(1);
        randNumRow1Col3 = numbers.get(2);
        randNumRow1Col4 = numbers.get(3);
        randNumRow2Col1 = numbers.get(4);
        randNumRow2Col2 = numbers.get(5);
        randNumRow2Col3 = numbers.get(6);
        randNumRow2Col4 = numbers.get(7);
        randNumRow3Col1 = numbers.get(8);
        randNumRow3Col2 = numbers.get(9);
        randNumRow3Col3 = numbers.get(10);
        randNumRow3Col4 = numbers.get(11);

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
        userInput = findViewById(R.id.textView_main_userinput);


    }

    private int specialNum = (int)(Math.pow(range*1.0, operationNum*1.0)+1);

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



}

//https://crunchify.com/how-to-create-simple-calculator-android-app-using-android-studio/
//calculator logic
//https://stackoverflow.com/questions/1397361/how-do-i-restart-an-android-activity
//possible reset button
//https://www.mkyong.com/java/java-convert-string-to-int/
//string to int logic
