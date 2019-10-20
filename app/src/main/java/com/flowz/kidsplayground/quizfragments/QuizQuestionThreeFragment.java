package com.flowz.kidsplayground.quizfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.flowz.kidsplayground.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuizQuestionThreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizQuestionThreeFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CURRENT_SCORE = "currentScore";

    private int mScore;

    private OnFragmentInteractionListener mListener;

    public QuizQuestionThreeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param score Parameter 1.
     * @return A new instance of fragment QuizQuestionThreeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizQuestionThreeFragment newInstance(int score) {
        QuizQuestionThreeFragment fragment = new QuizQuestionThreeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CURRENT_SCORE, score);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mScore = getArguments().getInt(ARG_CURRENT_SCORE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_quiz_question_three, container, false);
        ListView optionsView = view.findViewById(R.id.quiz_three_options);
        ArrayList<QuizOptionModel> quizOptionModels = new ArrayList<>();
        quizOptionModels.add(new QuizOptionModel("well", 1));
        quizOptionModels.add(new QuizOptionModel("hole", 2));
        quizOptionModels.add(new QuizOptionModel("pit", 3));
        quizOptionModels.add(new QuizOptionModel("grain", 4));

        QuizFragmentAdapter quizFragmentAdapter = new QuizFragmentAdapter(quizOptionModels, this.getContext(), 1);
        optionsView.setAdapter(quizFragmentAdapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}