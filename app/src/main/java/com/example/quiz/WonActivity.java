package com.example.quiz;

import static com.intuit.sdp.BuildConfig.*;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.intuit.sdp.BuildConfig;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    int correct,wrong;
    LinearLayout shareBtn;
    TextView resulttext,ic_exit;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correct=getIntent().getIntExtra("correct",0);
        wrong=getIntent().getIntExtra("wrong",0);

        circularProgressBar = findViewById(R.id.circularProgressBar);
        resulttext = findViewById(R.id.resulttext);
        shareBtn = findViewById(R.id.shareBtn);
        ic_exit = findViewById(R.id.ic_exit);
        ic_back = findViewById(R.id.ic_back);

        circularProgressBar.setProgress(correct);
        resulttext.setText(correct+"/20");



        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\n i got "+correct+" Out of 20 You Can Also Try";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BUILD_TYPE+ "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                    startActivity(Intent.createChooser(shareIntent,"Choose one"));

                } catch (Exception e){

                }

            }
        });

        ic_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(WonActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(WonActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

    }
}