package com.flowz.kidsplayground;

public class ScoreModel {
    private int questionId;
    private int Answer; //correct or incorrect if correct then value is 1 else value is 0

    public ScoreModel(int questionId, int answer) {
        this.questionId = questionId;
        Answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswer() {
        return Answer;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }
}
