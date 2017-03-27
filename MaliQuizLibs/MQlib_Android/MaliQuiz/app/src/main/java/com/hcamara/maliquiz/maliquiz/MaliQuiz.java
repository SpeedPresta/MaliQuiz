package com.hcamara.maliquiz.maliquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class MaliQuiz extends AppCompatActivity {

    static  String UserID = "";
    static int score = 0;
    static boolean sage = true;
    static boolean stop = true;
    static boolean svt = true;
    static int demo = 10;
    static int nbTry = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mali_quiz);

        final EditText userID = (EditText) findViewById(R.id.userID);
        ImageButton continuer = (ImageButton) findViewById(R.id.continuer);


        continuer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserID = userID.getText().toString();
                Intent intent = new Intent(getBaseContext(), Gameplay.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
