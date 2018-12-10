package com.example.maththing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView name;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        wireWidgets();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tutorialpls = new Intent(HomeActivity.this, TutorialActivity.class);
                startActivity(tutorialpls);
            }
        });
    }

    private void wireWidgets() {
        name = findViewById(R.id.textView_home_name);
        playButton = findViewById(R.id.button_home_play);
    }
}
