package com.flowz.kidsplayground.quizmanager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<QuizQuestionInfo> quizQuestions;
    private int size;

    public ViewPagerAdapter(FragmentManager fm, List<QuizQuestionInfo> quizQuestionInfo) {
        super(fm);
        this.quizQuestions = quizQuestionInfo;
        size = quizQuestions.size();
    }

    @Override
    public Fragment getItem(int position) {
        Boolean lastQuestion = position + 1 == size;
        switch (position) {
            default:
                return QuizQuestionFragment.newInstance(quizQuestions.get(position), lastQuestion);
        }

    }

    @Override
    public int getCount() {
        return size;
    }
}
