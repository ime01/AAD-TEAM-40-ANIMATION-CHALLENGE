package com.flowz.kidsplayground.quizmanager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<QuizQuestionInfo> quizQuestions;
    private int size;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        quizQuestions = QuizQuestionsManager.getInstance().getQuestions();
        size = quizQuestions.size();
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            default:
                return QuizQuestionFragment.newInstance(quizQuestions.get(position));
        }

    }

    @Override
    public int getCount() {
        return size;
    }
}
