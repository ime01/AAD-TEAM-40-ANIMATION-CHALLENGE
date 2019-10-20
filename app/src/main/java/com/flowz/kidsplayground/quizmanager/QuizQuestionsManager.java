package com.flowz.kidsplayground.quizmanager;

import com.flowz.kidsplayground.R;

import java.util.ArrayList;
import java.util.List;


public class QuizQuestionsManager {
    private static QuizQuestionsManager ourInstance = null;

    private List<QuizQuestionInfo> mQuestions = new ArrayList<>();


    public static QuizQuestionsManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new QuizQuestionsManager();
            ourInstance.initializeQuestions();
        }
        return ourInstance;
    }

    public List<QuizQuestionInfo> getQuestions() {
        return mQuestions;
    }

    private void initializeQuestions() {
        mQuestions.add(initializeQuestion1());
        mQuestions.add(initializeQuestion2());
        mQuestions.add(initializeQuestion3());
    }

    private QuizQuestionInfo initializeQuestion1() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.ladder, "Book", "Ladder", "Tree", "Road", 2);
    }

    private QuizQuestionInfo initializeQuestion2() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.ice_cream, "Soup", "balls", "Ice Cream", "cone", 3);
    }

    private QuizQuestionInfo initializeQuestion3() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.well, "well", "hole", "pit", "grain", 1);
    }

    private QuizQuestionInfo createQuestions(String question, int imageResource, String options1, String options2, String options3, String options4, int answerId) {
        List<QuizOptionInfo> options = new ArrayList<>();
        options.add(new QuizOptionInfo(options1, 1));
        options.add(new QuizOptionInfo(options2, 2));
        options.add(new QuizOptionInfo(options3, 3));
        options.add(new QuizOptionInfo(options4, 4));
        return new QuizQuestionInfo(question, imageResource, options, answerId);
    }
}
