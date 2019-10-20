package com.flowz.kidsplayground.quizfragments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizQuestions {
    private static QuizQuestions ourInstance = null;

    private List<Map> mQuestions = new ArrayList<>();

    public static QuizQuestions getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeCourses();
            ourInstance.initializeExampleNotes();
        }
        return ourInstance;
    }

    private void initializeQuestions(){
        mQuestions.add(initializeQuestion1());
    }

    private Map initializeQuestion1() {


        List<QuizOptionModel> options = new ArrayList<>();
        options.add(new QuizOptionModel("Book", 1));
        options.add(new QuizOptionModel("Ladder", 2));
        options.add(new QuizOptionModel("Tree", 3));
        options.add(new QuizOptionModel("Road", 4));
    }


}
