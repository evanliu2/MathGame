package com.example.maththing;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TutorialActivity extends AppCompatActivity {

    private Button gotIt;
    TextView title;
    TextView instruction1;
    TextView instruction2;
    TextView instruction3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        title = findViewById(R.id.textView3);
        instruction1 = findViewById(R.id.textView4);
        instruction2 = findViewById(R.id.textView5);
        instruction3 = findViewById(R.id.textView6);

        Animation LtoR = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        Animation RtoL = AnimationUtils.loadAnimation(this, R.anim.righttoleft);

        title.startAnimation(LtoR);
        instruction1.startAnimation(RtoL);
        instruction2.startAnimation(LtoR);
        instruction3.startAnimation(RtoL);

        gotIt = findViewById(R.id.button_tutorial_gotit);

        gotIt.startAnimation(LtoR);

        gotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent canIPlay = new Intent(TutorialActivity.this, MainActivity.class);
                startActivity(canIPlay);
            }
        });

    }
}
