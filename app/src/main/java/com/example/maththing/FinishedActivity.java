package com.example.maththing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class FinishedActivity extends AppCompatActivity {

    private Button menu;
    private Button replay;
    private Long finalTime;
    private TextView displayTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        wireWidgets();
        Intent receive = getIntent();
        String receiveTime = receive.getStringExtra("Finish");
        finalTime = Long.parseLong(receiveTime);

        long millis = System.currentTimeMillis() - finalTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;

        displayTime.setText("Time Used: " + String.format("%d:%02d", minutes, seconds));

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(FinishedActivity.this, HomeActivity.class);
                startActivity(goToMenu);
            }
        });

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playAgain = new Intent(FinishedActivity.this, TutorialActivity.class);
                startActivity(playAgain);
            }
        });

    }

    private void wireWidgets() {
        menu = findViewById(R.id.button_finished_menu);
        replay = findViewById(R.id.button_finished_replay);
        displayTime = findViewById(R.id.textView_main_time);
    }
}
