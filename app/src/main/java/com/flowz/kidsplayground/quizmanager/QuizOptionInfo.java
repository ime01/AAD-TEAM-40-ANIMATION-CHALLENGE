package com.flowz.kidsplayground.quizmanager;

import android.os.Parcel;
import android.os.Parcelable;

public class QuizOptionInfo implements Parcelable {
    private String mOption;
    private int mId;

    public QuizOptionInfo(String option, int id) {
        mOption = option;
        mId = id;
    }

    protected QuizOptionInfo(Parcel in) {
        mOption = in.readString();
        mId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mOption);
        dest.writeInt(mId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuizOptionInfo> CREATOR = new Creator<QuizOptionInfo>() {
        @Override
        public QuizOptionInfo createFromParcel(Parcel in) {
            return new QuizOptionInfo(in);
        }

        @Override
        public QuizOptionInfo[] newArray(int size) {
            return new QuizOptionInfo[size];
        }
    };

    public String getOption() {
        return mOption;
    }

    public void setOption(String option) {
        mOption = option;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

}