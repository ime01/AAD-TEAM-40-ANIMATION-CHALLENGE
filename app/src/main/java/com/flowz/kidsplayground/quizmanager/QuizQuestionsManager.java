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
        mQuestions.add(initializeQuestion4());
        mQuestions.add(initializeQuestion5());
        mQuestions.add(initializeQuestion6());
        mQuestions.add(initializeQuestion7());
        mQuestions.add(initializeQuestion8());
        mQuestions.add(initializeQuestion9());
        mQuestions.add(initializeQuestion10());
        mQuestions.add(initializeQuestion11());
        mQuestions.add(initializeQuestion12());
        mQuestions.add(initializeQuestion13());
        mQuestions.add(initializeQuestion14());
        mQuestions.add(initializeQuestion15());
        mQuestions.add(initializeQuestion16());
        mQuestions.add(initializeQuestion17());
        mQuestions.add(initializeQuestion18());
        mQuestions.add(initializeQuestion19());
        mQuestions.add(initializeQuestion20());
        mQuestions.add(initializeQuestion21());
        mQuestions.add(initializeQuestion22());
        mQuestions.add(initializeQuestion23());
        mQuestions.add(initializeQuestion24());
        mQuestions.add(initializeQuestion25());
        mQuestions.add(initializeQuestion26());
    }

    private QuizQuestionInfo initializeQuestion1() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.apple, "C", "A", "B", "F", 2);
    }

    private QuizQuestionInfo initializeQuestion2() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.bicycle, "D", "G", "A", "Z", 3);
    }

    private QuizQuestionInfo initializeQuestion3() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.cake, "H", "J", "I", "C", 1);
    }

    private QuizQuestionInfo initializeQuestion4() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.duck, "D", "A", "B", "C", 4);
    }

    private QuizQuestionInfo initializeQuestion5() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.elephant, "C", "A", "B", "E",  5);
    }

    private QuizQuestionInfo initializeQuestion6() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.frog, "C", "F", "B", "C", 6);
    }
    private QuizQuestionInfo initializeQuestion7() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.grape, "A", "D", "G", "C", 6);
    }
    private QuizQuestionInfo initializeQuestion8() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.hen, "H", "X", "J", "C", 6);
    }
    private QuizQuestionInfo initializeQuestion9() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.ice_cream, "N", "I", "B", "M", 6);
    }
    private QuizQuestionInfo initializeQuestion10() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.jacket, "A", "F", "J", "D", 6);
    }
    private QuizQuestionInfo initializeQuestion11() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.kangaroo, "W", "K", "B", "N", 6);
    }
    private QuizQuestionInfo initializeQuestion12() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.ladder, "O", "S", "P", "L", 6);
    }
    private QuizQuestionInfo initializeQuestion13() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.monocycle, "M", "H", "V", "Z", 6);
    }
    private QuizQuestionInfo initializeQuestion14() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.nurse, "U", "N", "E", "A", 6);
    }
    private QuizQuestionInfo initializeQuestion15() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.orange, "G", "B", "O", "C", 6);
    }
    private QuizQuestionInfo initializeQuestion16() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.parrot, "J", "P", "V", "Z", 6);
    }
    private QuizQuestionInfo initializeQuestion17() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.quail, "K", "Z", "Q", "Y", 6);
    }
    private QuizQuestionInfo initializeQuestion18() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.rainbow, "R", "I", "Y", "I", 6);
    }
    private QuizQuestionInfo initializeQuestion19() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.socks, "L", "S", "H", "W", 6);
    }
    private QuizQuestionInfo initializeQuestion20() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.tent, "S", "T", "X", "T", 6);
    }
    private QuizQuestionInfo initializeQuestion21() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.umbrella, "F", "U", "Y", "Q", 6);
    }
    private QuizQuestionInfo initializeQuestion22() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.vase, "X", "V", "B", "K", 6);
    }
    private QuizQuestionInfo initializeQuestion23() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.well, "W", "D", "P", "Z", 6);
    }
    private QuizQuestionInfo initializeQuestion24() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.xylophone, "M", "H", "X", "C", 6);
    }
    private QuizQuestionInfo initializeQuestion25() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.yam, "R", "T", "W", "Y", 6);
    }
    private QuizQuestionInfo initializeQuestion26() {
        return createQuestions("Match this picture to the corresponding alphabet", R.drawable.zebra, "D", "Z", "J", "T", 6);
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
