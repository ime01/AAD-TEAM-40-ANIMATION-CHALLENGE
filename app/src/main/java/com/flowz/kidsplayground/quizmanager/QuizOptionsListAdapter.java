package com.flowz.kidsplayground.quizmanager;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.flowz.kidsplayground.R;

import java.util.List;

public class QuizOptionsListAdapter extends BaseAdapter {
    private List<QuizOptionInfo> quizOptionArrayList;
    private Context mContext;
    private int mAnswerId;
    private boolean answered;
    private int selectedPosition = -1;
    private RadioButton mSelectedOption;

    public QuizOptionsListAdapter(List<QuizOptionInfo> quizOptionArrayList, Context context, int answerId) {
        this.quizOptionArrayList = quizOptionArrayList;
        mContext = context;
        mAnswerId = answerId;

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
            RadioButton option = view.findViewById(R.id.option_radio);
            option.setText(quizOptionInfo.getOption());
            option.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(position != selectedPosition && mSelectedOption !=null){
                        mSelectedOption.setChecked(false);
                    }
                    selectedPosition = position;
                    mSelectedOption = ((RadioButton) view);
                }
            });
            if(selectedPosition != position){
                option.setChecked(false);
            }else {
                option.setChecked(true);
                if(mSelectedOption !=null && option != mSelectedOption){
                    mSelectedOption = option;
                }
            }
        }
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
