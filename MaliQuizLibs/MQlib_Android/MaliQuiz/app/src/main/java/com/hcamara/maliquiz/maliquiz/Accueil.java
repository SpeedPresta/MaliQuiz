package com.hcamara.maliquiz.maliquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);


    ImageButton jouer = (ImageButton) findViewById(R.id.jouer);
    ImageButton aide = (ImageButton) findViewById(R.id.aide);
    ImageButton apropos = (ImageButton) findViewById(R.id.apropos);
    ImageButton quitter = (ImageButton) findViewById(R.id.quitter);


    jouer.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MaliQuiz.class);
            startActivity(intent);
        }
    });


        /**/aide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Aide.class);
                startActivity(intent);
            }
        });

          /**/apropos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Apropos.class);
                startActivity(intent);
            }
        });

          quitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);
            }
        });


    }
}
