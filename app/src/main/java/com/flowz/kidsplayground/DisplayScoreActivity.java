package com.flowz.kidsplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.flowz.kidsplayground.quizmanager.QuizQuestionsManager;

public class DisplayScoreActivity extends AppCompatActivity {

    int score = 10;
    TextView youScored, commendation;
    Button playAgain, exit;
    ImageView dispalyedPic;
    public Animation animPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);

        youScored = (TextView)findViewById(R.id.you_scored);
        commendation = (TextView)findViewById(R.id.commendations);
        dispalyedPic = (ImageView)findViewById(R.id.displayed_pic);
        playAgain = (Button)findViewById(R.id.play_again);
        exit = (Button)findViewById(R.id.exit);

        animPlay = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.play_animation);

        if (score <= 10){
            KidScoresBelowTen();
        }else if (score <=15){
            score_from_10_to_15();
        }
        else if (score <=20){
            score_from_15_to_20();
        }
        else {
            score_from_20and_above();
        }

        QuizQuestionsManager questionsManager = new QuizQuestionsManager();

    }

    private void KidScoresBelowTen() {
        youScored.setText(R.string.score_below_10);
        commendation.setText(R.string.D);
        dispalyedPic.setImageResource(R.drawable.sadface);

    }

    private void score_from_10_to_15() {
        youScored.setText(R.string.score_from_10_to_15);
        commendation.setText(R.string.C);
        dispalyedPic.setImageResource(R.drawable.apple);
    }

    private void score_from_15_to_20() {
        youScored.setText(R.string.score_from_15_to_20);
        commendation.setText(R.string.B);
        dispalyedPic.setImageResource(R.drawable.excited);
    }
    private void score_from_20and_above() {
        youScored.setText(R.string.score_from_20and_above);
        commendation.setText(R.string.A);
        dispalyedPic.setImageResource(R.drawable.greatjob);
    }

    public void PlayAgain(View view) {
        playAgain.startAnimation(animPlay);
        Intent intent = new Intent(DisplayScoreActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void Exit(View view) {
      moveTaskToBack(true);
      android.os.Process.killProcess(android.os.Process.myPid());
    }
}
