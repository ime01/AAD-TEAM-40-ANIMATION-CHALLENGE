package com.flowz.kidsplayground.quizfragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
            default:
                return QuizQuestionFragment.newInstance(0);
            case 1:
                return new QuizQuestionTwoFragment();
            case 2:
                return new QuizQuestionThreeFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
