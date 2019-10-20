package com.flowz.kidsplayground;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.flowz.kidsplayground.quizfragments.ViewPagerAdapter;

public class QuizActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mViewPager.getCurrentItem() > 0) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }

    }


    public void onPreviousPressed(View view) {
        if ((mViewPager.getCurrentItem() + 1) <= (mViewPager.getChildCount())) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    public void onNextPressed(View view) {
        if ((mViewPager.getCurrentItem() + 1) <= (mViewPager.getChildCount())) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
        }
    }
}
