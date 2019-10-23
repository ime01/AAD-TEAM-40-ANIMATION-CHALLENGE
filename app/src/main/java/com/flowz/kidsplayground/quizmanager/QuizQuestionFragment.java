package com.flowz.kidsplayground.quizmanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.flowz.kidsplayground.DisplayScoreActivity;
import com.flowz.kidsplayground.QuizActivity;
import com.flowz.kidsplayground.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuizQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizQuestionFragment extends Fragment {

    private static final String ARG_LAST_QUESTION = "lastQuestion";

    private boolean lastQuestion;
    private static final String ARG_QUESTION = "question";

    private QuizQuestionInfo mQuestion;

    private OnFragmentInteractionListener mListener;

    public Animation animPlay;
    public Animation animPlay2;

    public QuizQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param question Parameter 1.
     * @return A new instance of fragment QuizQuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizQuestionFragment newInstance(QuizQuestionInfo question, boolean lastQuestion) {
        QuizQuestionFragment fragment = new QuizQuestionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_QUESTION, question);
        args.putBoolean(ARG_LAST_QUESTION, lastQuestion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mQuestion = getArguments().getParcelable(ARG_QUESTION);
            lastQuestion = getArguments().getBoolean(ARG_LAST_QUESTION);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_quiz_question, container, false);
        List<QuizOptionInfo> quizOptions = mQuestion.getQuizOptionInfos();

        ImageView quizImage = view.findViewById(R.id.quiz_image);
        ListView optionsView = view.findViewById(R.id.quiz_options);
        TextView questionTextView = view.findViewById(R.id.quiz_question);
        Button submit = view.findViewById(R.id.submit);
        ImageButton next = view.findViewById(R.id.quiz_next_button);
        if (!lastQuestion) {
            submit.setVisibility(View.GONE);
            next.setVisibility(View.VISIBLE);
        } else {
            submit.setVisibility(View.VISIBLE);
            next.setVisibility(View.GONE);
        }

        quizImage.setImageResource(mQuestion.getImageResource());
        questionTextView.setText(mQuestion.getQuestion());

        QuizOptionsListAdapter quizOptionsListAdapter = new QuizOptionsListAdapter(quizOptions, this.getContext(), mQuestion.getAnswer());
        optionsView.setAdapter(quizOptionsListAdapter);

        animPlay = AnimationUtils.loadAnimation(getContext(), R.anim.question_picture_animation);
        animPlay2 = AnimationUtils.loadAnimation(getContext(), R.anim.quiz_buttuon_animation);

        questionTextView.startAnimation(animPlay2);

        quizImage.startAnimation(animPlay);


//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(requireContext(), DisplayScoreActivity.class);
//                startActivity(intent);
//                getActivity().overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.activity_stay);
//
//            }
//        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    public void moveToTheNextQuestion(View view) {

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
