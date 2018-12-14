package com.example.maththing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class FinishedActivity extends AppCompatActivity {

    private Button menu;
    private Button replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        wireWidgets();
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
    }
}
