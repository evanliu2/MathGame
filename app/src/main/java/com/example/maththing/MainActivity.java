package com.example.maththing;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> numbers, luckyNumbers, operations; // 1 -> +, 2 -> -, 3 -> *, 4 -> /
    private Button row1col1, row1col2, row1col3, row1col4, row2col1, row2col2, row2col3, row2col4, row3col1, row3col2, row3col3, row3col4, reset, add, subt, mult, div;
    private int target;
    private TextView targetNum, userInput, operationDisplay;
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
    private int operationCounter;
    public String time;
    private String sign;




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
    private int specialNum = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        createComponents();
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);

        animation();
        setButtonsAndDisplay();

    }

    private void setButtonsAndDisplay() {
        row1col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                doTheThing(row1col1);

            }
        });

        row1col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row1col2);

            }
        });

        row1col3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row1col3);

            }
        });

        row1col4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row1col4);

            }
        });

        row2col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row2col1);

            }
        });

        row2col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row2col2);

            }
        });

        row2col3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row2col3);

            }
        });

        row2col4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row2col4);

            }
        });

        row3col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row3col1);

            }
        });

        row3col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row3col2);

            }
        });

        row3col3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row3col3);

            }
        });

        row3col4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doTheThing(row3col4);

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                operation = 1;
                sign = getString(R.string.main_addition);
                doTheOperation(operation, sign);
            }
        });

        subt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                operation = 2;
                sign = getString(R.string.main_subtraction);
                doTheOperation(operation, sign);
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                operation = 3;
                sign = getString(R.string.main_multiplication);
                doTheOperation(operation, sign);

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                operation = 4;
                sign = getString(R.string.main_division);
                doTheOperation(operation, sign);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userInput.setText("");
                num1 = 0;
                num2 = 0;
                operationCounter = 0;
                operationDisplay.setText("Operations Used: 0 / 4");
                operation = 4;
                numClicked1 = false;
                numClicked2 = false;
                operationClicked = false;
                enableButtons();


            }
        });
    }

    private void animation() {
        Animation LtoR = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        Animation RtoL = AnimationUtils.loadAnimation(this, R.anim.righttoleft);
        Animation ZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        Animation Down = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        Animation Bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);

        userInput.startAnimation(ZoomIn);
        row1col1.startAnimation(LtoR);
        row1col2.startAnimation(LtoR);
        row2col1.startAnimation(LtoR);
        row2col2.startAnimation(LtoR);
        row3col1.startAnimation(LtoR);
        row3col2.startAnimation(LtoR);
        add.startAnimation(LtoR);
        subt.startAnimation(LtoR);

        timer.startAnimation(LtoR);

        row1col3.startAnimation(RtoL);
        row1col4.startAnimation(RtoL);
        row2col3.startAnimation(RtoL);
        row2col4.startAnimation(RtoL);
        row3col3.startAnimation(RtoL);
        row3col4.startAnimation(RtoL);
        mult.startAnimation(RtoL);
        div.startAnimation(RtoL);

        reset.startAnimation(RtoL);

        targetNum.startAnimation(Down);

        operationDisplay.startAnimation(ZoomIn);
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

    private void doTheThing(Button button)
    {
        if(numClicked1 == false)
        {
            num1 = Integer.parseInt(button.getText().toString());
            userInput.setText(userInput.getText() + " " + button.getText());
            numClicked1 = true;
            disableButton(button);
        }

        else if(numClicked1 == true && operationClicked == true && numClicked2 == false)
        {
            num2 = Integer.parseInt(button.getText().toString());
            userInput.setText(calculate(num1, num2, operation) + "");
            num1 = calculate(num1,num2,operation);
            disableButton(button);
            if(num1 == specialNum)
            {
                Toast.makeText(MainActivity.this, "Invalid Input, Please Reset", Toast.LENGTH_SHORT).show();
            }
            checkFinished();
            num2 = 0;
            numClicked1 = true;
            numClicked2 = false;

        }
    }

    private void doTheOperation(int operation, String sign)
    {
        if (numClicked1 == true && numClicked2 == false)
        {
            operation = 1;
            operationClicked = true;
            userInput.setText(userInput.getText() + " " + sign);
            operationCounter++;
            operationDisplay.setText("Operations Used:" + operationCounter + " / 4");
            checkFinished();

        }
    }

    private void disableButton(Button butter) {
        butter.setVisibility(View.INVISIBLE);
    }

    private void enableButtons() {
        row1col1.setVisibility(View.VISIBLE);
        row1col2.setVisibility(View.VISIBLE);
        row1col3.setVisibility(View.VISIBLE);
        row1col4.setVisibility(View.VISIBLE);
        row2col1.setVisibility(View.VISIBLE);
        row2col2.setVisibility(View.VISIBLE);
        row2col3.setVisibility(View.VISIBLE);
        row2col4.setVisibility(View.VISIBLE);
        row3col1.setVisibility(View.VISIBLE);
        row3col2.setVisibility(View.VISIBLE);
        row3col3.setVisibility(View.VISIBLE);
        row3col4.setVisibility(View.VISIBLE);
    }

    private void checkFinished() {

        if(num1 == Integer.parseInt(targetNum.getText().toString()) && operationCounter == 4)
        {
            Intent finish = new Intent(MainActivity.this, FinishedActivity.class);
            time = startTime+"";
            finish.putExtra("Finish", time);
            startActivity(finish);
        }

        else if(operationCounter > 4)
        {
            openDialog();
        }
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Out of Operations!")
                .setMessage("You failed to achieve the target number...")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent exit = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(exit);
                    }
                })
                .setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userInput.setText("");
                        num1 = 0;
                        num2 = 0;
                        operationCounter = 0;
                        operationDisplay.setText("Operations Used: 0 / 4");
                        operation = 4;
                        numClicked1 = false;
                        numClicked2 = false;
                        operationClicked = false;
                        enableButtons();
                    }
                });
        builder.create().show();

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
        userInput = findViewById(R.id.textView_main_userinput);
        operationDisplay = findViewById(R.id.textView_main_operation_counter);

    }




}
