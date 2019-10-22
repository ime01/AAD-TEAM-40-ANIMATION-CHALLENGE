package com.flowz.kidsplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Animation animSequential, animQuizBtn, animPlayBtn;
    public Button playBtn, quizBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.btn_lesson);
        quizBtn = findViewById(R.id.btn_quiz);

        animSequential = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.welcome_text_animation);
        animPlayBtn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.play_animation);
        animQuizBtn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.quiz_buttuon_animation);

        TextView kids_Playground = findViewById(R.id.aad_team_40);
        kids_Playground.setVisibility(View.VISIBLE);
        kids_Playground.startAnimation(animSequential);



    }

    public void quizActivity(View view) {
        quizBtn.startAnimation(animQuizBtn);
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void playActivity(View view) {
        playBtn.startAnimation(animPlayBtn);
        startActivity( new Intent(this, PlayActivity.class));
    }
}
