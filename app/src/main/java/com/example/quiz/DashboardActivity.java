package com.example.quiz;

import static com.example.quiz.MainActivity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue=20;
    ProgressBar progressBar;
    List<Modelclass> questionList;
    Modelclass modelclass;
    int index=0;
    TextView card_question,optiona,optionb,optionc,optiond,tvScore,tvQuestion;
    CardView cardOA,cardOB,cardOC,cardOD;
    int correctCount=0;
    int wrongCount=0;
    LinearLayout nextBtn;
    int totalQuestions;
    int qCounter=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();

        questionList=list;
        Collections.shuffle(questionList);
        modelclass=list.get(index);

        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
        
       nextBtn.setClickable(false);
       //tvQuestion.setText("Question: "+index+"/"+totalQuestions);

        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                timerValue=timerValue-1;
                progressBar.setProgress(timerValue);

            }

            @Override
            public void onFinish() {
                Dialog dialog=new Dialog(DashboardActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.timeout_dialog);


                dialog.findViewById(R.id.tryagain_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

                dialog.show();

            }
        }.start();

        setAllData();
    }

    private void setAllData() {

        card_question.setText(modelclass.getQuestion());
        optiona.setText(modelclass.getoA());
        optionb.setText(modelclass.getoB());
        optionc.setText(modelclass.getoC());
        optiond.setText(modelclass.getoD());

        timerValue = 20;
        countDownTimer.cancel();
        countDownTimer.start();



    }

    private void Hooks() {

      tvQuestion = findViewById(R.id.textQuestionNumber);
      tvScore = findViewById(R.id.textScore);
      progressBar = findViewById(R.id.quiz_timer);
      card_question = findViewById(R.id.card_question);
      optiona = findViewById(R.id.card_optiona);
      optionb = findViewById(R.id.card_optionb);
      optionc = findViewById(R.id.card_optionc);
      optiond = findViewById(R.id.card_optiond);

      cardOA = findViewById(R.id.ans_A);
      cardOB = findViewById(R.id.ans_B);
      cardOC = findViewById(R.id.ans_C);
      cardOD = findViewById(R.id.ans_D);

      nextBtn = findViewById(R.id.nextBtn);

    }

    public void Correct(CardView cardView){

        cardView.setBackgroundColor(getResources().getColor(R.color.green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                correctCount++;
                index++;
                modelclass=list.get(index);
                resetColor();
                setAllData();
                enableButton();
                tvScore.setText("Score: "+correctCount);


            }
        });

    }


    public void Wrong(CardView cardOA){

        cardOA.setBackgroundColor(getResources().getColor(R.color.red));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wrongCount++;
                if (index<list.size()-1) {
                    index++;
                    modelclass = list.get(index);
                    resetColor();
                    setAllData();
                    enableButton();

                }else {
                    GameWon();
                }
            }

        });


    }

    private void GameWon() {
        Intent intent= new Intent(DashboardActivity.this,WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);
    }

    public void enableButton(){

        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);

    }

    public void disableButton(){

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

        nextBtn.setClickable(true);
    }

    public void optionClickA(View view){

        disableButton();
        nextBtn.setClickable(true);

        if(modelclass.getoA().equals(modelclass.getAns()))
        {
            cardOA.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1)

            {
                Correct(cardOA);
            }
            else {
                GameWon();
            }
        }
        else{
            Wrong(cardOA);
        }
    }
    public void optionClickB(View view){

        disableButton();
        nextBtn.setClickable(true);

        if(modelclass.getoB().equals(modelclass.getAns()))
        {
            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1)
            {

               Correct(cardOB);
            }
            else {
                GameWon();
            }
        }
        else{
            Wrong(cardOB);
        }

    }
    public void optionClickC(View view){

        disableButton();
        nextBtn.setClickable(true);

        if(modelclass.getoC().equals(modelclass.getAns()))
        {
            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1)
            {
                Correct(cardOC);
            }
            else {
                GameWon();
            }
        }
        else{
            Wrong(cardOC);
        }

    }
    public void optionClickD(View view){

        disableButton();
        nextBtn.setClickable(true);

        if(modelclass.getoD().equals(modelclass.getAns()))
        {
            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if (index<list.size()-1)
            {
                Correct(cardOD);
            }
            else {
                GameWon();
            }
        }
        else{
            Wrong(cardOD);
        }

    }
}