package com.flowz.kidsplayground.quizmanager;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.flowz.kidsplayground.R;

import java.util.List;

public class QuizOptionsListAdapter implements ListAdapter {
    private List<QuizOptionInfo> quizOptionArrayList;
    private Context mContext;
    private int mAnswerId;
    private boolean answered;
    private RadioGroup optionsGroup;

    public QuizOptionsListAdapter(List<QuizOptionInfo> quizOptionArrayList, Context context, int answerId) {
        this.quizOptionArrayList = quizOptionArrayList;
        mContext = context;
        mAnswerId = answerId;
        optionsGroup = new RadioGroup(mContext);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return quizOptionArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup viewGroup) {
        QuizOptionInfo quizOptionInfo = quizOptionArrayList.get(position);
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(R.layout.quiz_option_row, null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    if (!answered) {
//                        if (position + 1 == mAnswerId) {
//                            v.setBackgroundColor(Color.parseColor("#ADD8E6"));
//                        } else {
//                            v.setBackgroundColor(Color.parseColor("#FF0000"));
//                        }
//                        answered = true;
//                    }
                }
            });
            RadioButton option = view.findViewById(R.id.option_radio);
            option.setText(quizOptionInfo.getOption());
        }
        optionsGroup.addView(view, position);
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return quizOptionArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
