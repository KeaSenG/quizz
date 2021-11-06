package com.example.quiz_real;

import static com.example.quiz_real.MainActivity.list;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends Activity {

    CountDownTimer countDownTimer;
    int timerValue=20;
    List<Modelclass> allQuestionList;
    Modelclass modelclass;
    int index=0;
    TextView  question, option_1, option_2, option_3, option_4;
    CardView cardOA, cardOB, cardOC, cardOD;
    int correctCount=0;
    int wrongCount=0;
    Button nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Hooks();

        allQuestionList=list;
        Collections.shuffle(allQuestionList);
        modelclass=list.get(index);

        setAlldata();


        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue=timerValue-1;

            }

            @Override
            public void onFinish() {
                Dialog dialog=new Dialog(QuizActivity.this);
            }
        }.start();
    }

    private void setAlldata() {

        question.setText(modelclass.getQuestion());
        option_1.setText(modelclass.getoA());
        option_2.setText(modelclass.getoB());
        option_3.setText(modelclass.getoC());
        option_4.setText(modelclass.getoD());
    }

    private void Hooks() {
        question = findViewById(R.id.question);
        option_1 = findViewById(R.id.option_1);
        option_2 = findViewById(R.id.option_2);
        option_3 = findViewById(R.id.option_3);
        option_4 = findViewById(R.id.option_4);

        cardOA = findViewById(R.id.CardA);
        cardOB = findViewById(R.id.CardB);
        cardOC = findViewById(R.id.CardC);
        cardOD = findViewById(R.id.CardD);

        nextBtn = findViewById(R.id.nextBtn);
    }

    public void Correct(CardView cardView){

        cardView.setBackgroundColor(getResources().getColor(R.color.color_green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                index++;
                modelclass = list.get(index);
                setAlldata();

            }
        });



    }
    public void Wrong(CardView cardOA) {


        cardOA.setBackgroundColor(getResources().getColor(R.color.color_red));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if (index < list.size() - 1) {
                    index++;
                    modelclass = list.get(index);
                    setAlldata();
                    resetColor();
                } else {
                    GameMon();
                }
            }
        });
    }
    private void GameMon() {
        Intent intent = new Intent(QuizActivity.this, wonActivity.class);
        startActivity(intent);

    }

    public void enableButton(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);

    }
    public void disableButton() {
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }

    public void resetColor(){
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void onClickA(View view) {
        nextBtn.setClickable(true);
        if(modelclass.getoA().equals(modelclass.getAns()))
        {
            cardOA.setBackgroundColor(getResources().getColor(R.color.color_green));

            if (index < list.size()-1) {

                Correct(cardOA);

            }else {
                GameMon();

            }


        }
        else {
            Wrong(cardOA);
        }

    }
    public void onClickB(View view) {
        nextBtn.setClickable(true);
        if(modelclass.getoB().equals(modelclass.getAns()))
        {
            cardOB.setBackgroundColor(getResources().getColor(R.color.color_green));

            if (index < list.size()-1) {

                Correct(cardOB);

            }else {
                GameMon();

            }


        }
        else {
            Wrong(cardOB);
        }

    }
    public void onClickC(View view) {
        nextBtn.setClickable(true);
        if(modelclass.getoC().equals(modelclass.getAns()))
        {
            cardOC.setBackgroundColor(getResources().getColor(R.color.color_green));

            if (index < list.size()-1) {

                Correct(cardOC);

            }else {
                GameMon();

            }


        }
        else {
            Wrong(cardOC);
        }

    }
    public void onClickD(View view) {
        nextBtn.setClickable(true);
        if(modelclass.getoD().equals(modelclass.getAns()))
        {
            cardOD.setBackgroundColor(getResources().getColor(R.color.color_green));

            if (index < list.size()-1) {

                Correct(cardOD);

            }else {
                GameMon();

            }


        }
        else {
            Wrong(cardOD);
        }

    }
}
