package com.hcamara.maliquiz.maliquiz;

import android.content.Intent;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;
import java.util.Random;
import mlquizLib.Player;
import mlquizLib.Tools;

/**
 * Created by hcamara on 06/03/2017.
 */

public class Gameplay extends AppCompatActivity {

    TextView userID, chrono, ans, indice, score, level, quiz;
    TextView rep1, rep2, rep3, rep4;
    ImageButton img1, img2, img3, img4, svt, stop, sage;
    int currentTime = 15;
    Handler handler;
    Runnable runnable;
    String currentQuiz = "";
    int currentQuizNb = 0;
    String idUser;
    String[] currentProp;
    int min = 0;
    int max = 0;
    int nbf = 0;

    Random r = new Random();

    public void chrono() {

        if(MaliQuiz.demo == 0){
            Intent intent = new Intent(getBaseContext(), EndDemo.class);
            startActivity(intent);
            finish();
        }

        if(MaliQuiz.nbTry == 0){
            Intent intent = new Intent(getBaseContext(), Perdu.class);
            startActivity(intent);
            finish();
        }

        if(MaliQuiz.sage) { sage.setImageResource(R.drawable.sage);} else {sage.setImageResource(R.drawable.sage1);}
        if(MaliQuiz.stop) {stop.setImageResource(R.drawable.stop);} else {stop.setImageResource(R.drawable.stop1);}
        if(MaliQuiz.svt) {svt.setImageResource(R.drawable.svt);} else {svt.setImageResource(R.drawable.svt1);}

        if (currentTime <= 15 && currentTime > 0){
            if(currentTime == 15) {
                max = (dbres.getQuiz().length-1);
                if(nbf == 0){
                currentQuiz = dbres.getQuiz()[(r.nextInt(max - min + 1) + min)];
                    MaliQuiz.demo--;
                }else{
                    nbf = 0;
                }
                quiz.setText(currentQuiz.split(";")[0]);

                currentProp = (currentQuiz.split(";")[1]).split(",,");

                rep1.setText(currentProp[0]);
                rep2.setText(currentProp[1]);
                rep3.setText(currentProp[2]);
                rep4.setText(currentProp[3]);

                //ans.setText(currentQuiz.split(";")[2]);
                //indice.setText(currentQuiz.split(";")[3]);
                currentQuizNb++;
            }
            chrono.setText(""+(currentTime));
            currentTime--;



        } else {
            if(currentTime == 16){
                img1.setImageResource(R.drawable.grisb300);
                img2.setImageResource(R.drawable.grisr300);
                img3.setImageResource(R.drawable.grisb300);
                img4.setImageResource(R.drawable.grisr300);


                currentTime = 15;
            }else if(currentTime == 0){

               /* if(currentProp[0].equals(currentQuiz.split(";")[2])) img1.setImageResource(R.drawable.bleub);
                if(currentProp[1].equals(currentQuiz.split(";")[2])) img2.setImageResource(R.drawable.bleub2);
                if(currentProp[2].equals(currentQuiz.split(";")[2])) img3.setImageResource(R.drawable.bleub);
                if(currentProp[3].equals(currentQuiz.split(";")[2])) img1.setImageResource(R.drawable.bleub2);

                currentTime = 16;*/
                updateTry(idUser);
                currentTime = 15;

            } else if (currentTime == 17){
                currentTime--;
            }else{
                chrono.setText("" + (currentTime));
                currentTime = 15;
            }
        }

        handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);

        userID = (TextView) findViewById(R.id.userID);
        chrono = (TextView) findViewById(R.id.chrono);
        quiz = (TextView) findViewById(R.id.quiz);

        img1 = (ImageButton) findViewById(R.id.img1);
        img2 = (ImageButton) findViewById(R.id.img2);
        img3 = (ImageButton) findViewById(R.id.img3);
        img4 = (ImageButton) findViewById(R.id.img4);

        rep1 = (TextView) findViewById(R.id.rep1);
        rep2 = (TextView) findViewById(R.id.rep2);
        rep3 = (TextView) findViewById(R.id.rep3);
        rep4 = (TextView) findViewById(R.id.rep4);

        svt = (ImageButton) findViewById(R.id.svt);
        sage = (ImageButton) findViewById(R.id.sage);
        stop = (ImageButton) findViewById(R.id.stop);

       // level = (TextView) findViewById(R.id.level);
        //score = (TextView) findViewById(R.id.score);

        Player jouer = new Player(MaliQuiz.UserID);

        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                chrono();
            }
        };

        idUser = jouer.getPseudo();
        userID.setText(idUser + " | " + MaliQuiz.score + " pts" + " | " + MaliQuiz.nbTry + " Essais");



        /*jouer.setLevel(1);
        jouer.setScore(10);
        level.setText(jouer.getLevel());
        score.setText(jouer.getScore());*/
        runnable.run();


        img1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currentProp[0].equals(currentQuiz.split(";")[2])) {
                    img1.setImageResource(R.drawable.bleub);
                    updateScore(idUser, 10);

                } else {
                    img1.setImageResource(R.drawable.redb1);
                    //Toast.makeText(getApplicationContext(), "Mauvaise reponse !!!", 5000).show();
                    if(currentProp[1].equals(currentQuiz.split(";")[2])) img2.setImageResource(R.drawable.bleub2);
                    if(currentProp[2].equals(currentQuiz.split(";")[2])) img3.setImageResource(R.drawable.bleub);
                    if(currentProp[3].equals(currentQuiz.split(";")[2])) img4.setImageResource(R.drawable.bleub2);

                    updateTry(idUser);
                }

                currentTime = 17;


            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currentProp[1].equals(currentQuiz.split(";")[2])) {
                    img2.setImageResource(R.drawable.bleub2);
                    updateScore(idUser, 10);


                } else {
                    img2.setImageResource(R.drawable.redb2);
                    //Toast.makeText(getApplicationContext(), "Mauvaise reponse !!!", 5000).show();

                    if(currentProp[0].equals(currentQuiz.split(";")[2])) img1.setImageResource(R.drawable.bleub);
                    if(currentProp[2].equals(currentQuiz.split(";")[2])) img3.setImageResource(R.drawable.bleub);
                    if(currentProp[3].equals(currentQuiz.split(";")[2])) img4.setImageResource(R.drawable.bleub2);

                    updateTry(idUser);
                }

                currentTime = 17;


            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currentProp[2].equals(currentQuiz.split(";")[2])) {
                    img3.setImageResource(R.drawable.bleub);
                    updateScore(idUser, 10);
                } else {
                    img3.setImageResource(R.drawable.redb1);
                    //Toast.makeText(getApplicationContext(), "Mauvaise reponse !!!", 5000).show();

                    if(currentProp[0].equals(currentQuiz.split(";")[2])) img1.setImageResource(R.drawable.bleub);
                    if(currentProp[1].equals(currentQuiz.split(";")[2])) img2.setImageResource(R.drawable.bleub2);
                    if(currentProp[3].equals(currentQuiz.split(";")[2])) img4.setImageResource(R.drawable.bleub2);

                    updateTry(idUser);
                }
                currentTime = 17;

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currentProp[3].equals(currentQuiz.split(";")[2])) {
                    img4.setImageResource(R.drawable.bleub2);
                    updateScore(idUser, 10);

                } else {
                    img4.setImageResource(R.drawable.redb2);
                    //Toast.makeText(getApplicationContext(), "Mauvaise reponse !!!", 5000).show();

                    if(currentProp[0].equals(currentQuiz.split(";")[2])) img1.setImageResource(R.drawable.bleub);
                    if(currentProp[1].equals(currentQuiz.split(";")[2])) img2.setImageResource(R.drawable.bleub2);
                    if(currentProp[2].equals(currentQuiz.split(";")[2])) img3.setImageResource(R.drawable.bleub);

                    updateTry(idUser);
                }

                currentTime = 17;
            }
        });


        sage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              if(MaliQuiz.sage){
                  MaliQuiz.sage = false;
                  Toast.makeText(getApplicationContext(), currentQuiz.split(";")[3], 5000).show();
              }

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(MaliQuiz.stop){
                    MaliQuiz.stop = false;
                    nbf = 1;
                }

            }
        });

        svt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(MaliQuiz.svt) {
                    MaliQuiz.svt = false;
                    currentTime = 15;
                }
            }
        });
    }

    void updateScore(String id, int score){
        MaliQuiz.score += score;
        userID.setText(id + " | " + MaliQuiz.score + " pts"  + " | " + MaliQuiz.nbTry + " Essais");
    }

    void updateTry(String id){
        MaliQuiz.nbTry--;
        userID.setText(id + " | " + MaliQuiz.score + " pts" + " | " + MaliQuiz.nbTry + " Essais");
    }
}
