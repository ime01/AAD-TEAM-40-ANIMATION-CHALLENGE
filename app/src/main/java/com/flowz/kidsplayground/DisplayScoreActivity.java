package com.flowz.kidsplayground;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.flowz.kidsplayground.quizmanager.QuizQuestionInfo;
import com.flowz.kidsplayground.quizmanager.QuizQuestionsManager;

import java.util.List;
import java.util.Locale;

public class DisplayScoreActivity extends AppCompatActivity {
    TextToSpeech mytextToSpeech;
    final String TAG = "DisplayScoreActivity";
    int score;
    int totalScore;
    TextView youScored, commendation, displayKidsScore;
    Button playAgain, exit;
    ImageView dispalyedPic;
    public Animation animPlay, animBounce, animBlink, animSlide, animSlide2, animSlideText, animSlideInText;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);
        totalScore = intent.getIntExtra("totalScore", 0);



        mytextToSpeech = new TextToSpeech(DisplayScoreActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
//                if(status == TextToSpeech.SUCCESS)
                mytextToSpeech.setLanguage(Locale.ENGLISH);
                String commendStudent = commendation.getText().toString();
                Log.d(TAG, "speakText: Text: " + commendStudent);
//                mytextToSpeech.setPitch(2f);
                mytextToSpeech.setSpeechRate(0.7f);
                mytextToSpeech.speak(commendStudent, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });



        youScored = findViewById(R.id.you_scored);
        commendation = findViewById(R.id.commendations);
        dispalyedPic = findViewById(R.id.displayed_pic);
        playAgain = findViewById(R.id.play_again);
        exit = findViewById(R.id.exit);
        displayKidsScore = findViewById(R.id.display_kids_score);
        displayKidsScore.setText("You scored " + score+ " out of "+ totalScore+ " questions");



        animPlay = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.play_animation);
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.quiz_buttuon_animation);
        animSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left);
        animSlide2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        animSlideText = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right_text);
        animSlideInText = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_text);

        dispalyedPic.startAnimation(animBounce);
        commendation.setAnimation(animBlink);
        youScored.setAnimation(animSlideInText);
        animBounce.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                playAgain.setVisibility(View.GONE);
                exit.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                playAgain.setVisibility(View.VISIBLE);
                exit.setVisibility(View.VISIBLE);
                playAgain.startAnimation(animSlideText);
                exit.setAnimation(animSlideText);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });

        analyseScore();




//        String commendStudent = commendation.getText().toString();
//        mytextToSpeech.speak(commendStudent, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onPause() {
        if(mytextToSpeech != null){
            mytextToSpeech.stop();
            mytextToSpeech.shutdown();
        }
        super.onPause();
    }

    private int calculatePercentage(){
      return (score*100) / totalScore;

    }

    private void analyseScore(){
        int percentScore = calculatePercentage();
        if (percentScore <= 30){
            KidScoresBelow30Percent();
        }else if (percentScore <=50){
            from_31_to_50Percent();
        }
        else if (percentScore <=70){
            from_51_to_70Percent();
        }
        else {
            from_70and_abovepercent();
        }
    }

    private void KidScoresBelow30Percent() {
        youScored.setText(R.string.score_below_10);
        commendation.setText(R.string.D);
        dispalyedPic.setImageResource(R.drawable.sadface);

    }

    private void from_31_to_50Percent() {
        youScored.setText(R.string.score_from_10_to_15);
        commendation.setText(R.string.C);
        dispalyedPic.setImageResource(R.drawable.excited);
    }

    private void from_51_to_70Percent() {
        youScored.setText(R.string.score_from_15_to_20);
        commendation.setText(R.string.B);
        dispalyedPic.setImageResource(R.drawable.happyface);
    }
    private void from_70and_abovepercent() {
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
        new AlertDialog.Builder(this)
                .setMessage("Do you want to Exit Kids PlayGround")
                .setCancelable(true)

                .setPositiveButton(
                        "Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                            }
                        })
                .setNegativeButton("No", null).show();
    }
}
