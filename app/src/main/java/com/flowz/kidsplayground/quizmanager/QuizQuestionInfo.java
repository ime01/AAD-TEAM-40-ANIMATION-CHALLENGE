package com.flowz.kidsplayground.quizmanager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class QuizQuestionInfo implements Parcelable {
    private String question;
    private int imageResource;
    private int mAnswer;
    private List<QuizOptionInfo> mQuizOptionInfos;


    public QuizQuestionInfo(String question, int imageResource, List<QuizOptionInfo> quizOptionInfos, int answer) {
        this.question = question;
        this.imageResource = imageResource;
        mQuizOptionInfos = quizOptionInfos;
        mAnswer = answer;
    }

    protected QuizQuestionInfo(Parcel in) {
        question = in.readString();
        imageResource = in.readInt();
        mQuizOptionInfos = in.createTypedArrayList(QuizOptionInfo.CREATOR);
        mAnswer = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeInt(imageResource);
        dest.writeTypedList(mQuizOptionInfos);
        dest.writeInt(mAnswer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuizQuestionInfo> CREATOR = new Creator<QuizQuestionInfo>() {
        @Override
        public QuizQuestionInfo createFromParcel(Parcel in) {
            return new QuizQuestionInfo(in);
        }

        @Override
        public QuizQuestionInfo[] newArray(int size) {
            return new QuizQuestionInfo[size];
        }
    };

    public List<QuizOptionInfo> getQuizOptionInfos() {
        return mQuizOptionInfos;
    }

    public void setQuizOptionInfos(List<QuizOptionInfo> quizOptionInfos) {
        mQuizOptionInfos = quizOptionInfos;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getAnswer() {
        return mAnswer;
    }

    public void setAnswer(int answer) {
        mAnswer = answer;
    }
}
