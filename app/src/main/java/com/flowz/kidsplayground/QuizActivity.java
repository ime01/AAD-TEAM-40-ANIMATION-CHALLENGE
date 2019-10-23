package com.flowz.kidsplayground;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.flowz.kidsplayground.quizmanager.QuizOptionsListAdapter;
import com.flowz.kidsplayground.quizmanager.QuizQuestionInfo;
import com.flowz.kidsplayground.quizmanager.QuizQuestionsManager;
import com.flowz.kidsplayground.quizmanager.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private int totalScore = 0;

    public ImageButton questionText;
    public Button submit;
    private List<QuizQuestionInfo> mQuizQuestionInfos;
    private List<ScoreModel> mScores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuizQuestionInfos = QuizQuestionsManager.getInstance().getFewQuestions();
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), mQuizQuestionInfos));


    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() > 0) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
        if (mViewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        }


    }


    public void onPreviousPressed(View view) {
        if ((mViewPager.getCurrentItem() + 1) <= (mViewPager.getAdapter().getCount())) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    public void onNextPressed(View view) {
        if ((mViewPager.getCurrentItem() + 1) <= (mViewPager.getAdapter().getCount())) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
        }
        analyzeAnswer();
    }

    private void analyzeAnswer() {
        ListView optionsList = findViewById(R.id.quiz_options);

        QuizOptionsListAdapter quizOptionsListAdapter = ((QuizOptionsListAdapter) optionsList.getAdapter());

        mScores.add(new ScoreModel(quizOptionsListAdapter.getQuestionId(), quizOptionsListAdapter.getAnswer()));

//        if (scores.get(currentItem).equals(quizOptionsListAdapter.getQuestionId())) {
//            scores.remove(currentItem);
//            scores.add(new ScoreModel(quizOptionsListAdapter.getQuestionId(), quizOptionsListAdapter.getAnswer()));
//        } else {
//            scores.add(new ScoreModel(quizOptionsListAdapter.getQuestionId(), quizOptionsListAdapter.getAnswer()));
//
//        }

    }

    private int calculateAnswer() {
        int totalScore = 0;
        for (ScoreModel scoreModel : mScores) {
            totalScore = totalScore + scoreModel.getAnswer();
        }
        return totalScore;

    }

    public void submitButtonClicked(View view) {
       int score = calculateAnswer();
        Intent intent = new Intent(this, DisplayScoreActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("totalScore", mQuizQuestionInfos.size());
        startActivity(intent);
        this.overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.activity_stay);
    }
}
