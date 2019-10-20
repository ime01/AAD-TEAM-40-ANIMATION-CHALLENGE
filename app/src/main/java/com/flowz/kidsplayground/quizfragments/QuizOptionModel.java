package com.flowz.kidsplayground.quizfragments;

public class QuizOptionModel {
    private String option;
    private int id;

    public QuizOptionModel(String option, int id) {
        this.option = option;
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
