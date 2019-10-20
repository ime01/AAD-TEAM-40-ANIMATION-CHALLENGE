package com.flowz.kidsplayground;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.Viewholder> {

    List<Alphabet> alphabetList;
    Context context;

    public AlphabetAdapter(List<Alphabet> alphabetList, Context context) {

        this.alphabetList = alphabetList;
        this.context = context;
    }

    @NonNull
    @Override
    public AlphabetAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alphapet_viewholder, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetAdapter.Viewholder holder, int position) {

        Alphabet alphabet = alphabetList.get(position);

        holder.tvName.setText(alphabet.letter);
        holder.getView().setAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_in));

    }

    @Override
    public int getItemCount() {
        return alphabetList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView tvName;

        private View view;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            tvName = itemView.findViewById(R.id.textView2);
        }

        public View getView() {
            return view;
        }
    }
}

