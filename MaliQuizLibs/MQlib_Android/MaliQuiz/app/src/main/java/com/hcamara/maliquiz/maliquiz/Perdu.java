package com.hcamara.maliquiz.maliquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Perdu extends AppCompatActivity {

    TextView titre,score,nbEssais;
    ImageButton btRejouer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdu);

        titre = (TextView) findViewById(R.id.titre);
        score = (TextView) findViewById(R.id.score);
        nbEssais = (TextView) findViewById(R.id.nbEssais);

        titre.setText("Désolé " + MaliQuiz.UserID);
        score.setText("Score " + MaliQuiz.score);
        nbEssais.setText("Nb Essais " + MaliQuiz.nbTry);

        btRejouer = (ImageButton)findViewById(R.id.btRejouer);

        btRejouer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), MaliQuiz.class);
                startActivity(intent);
            }
        });
    }
}
