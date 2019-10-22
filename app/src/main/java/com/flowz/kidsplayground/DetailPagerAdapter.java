package com.flowz.kidsplayground;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class DetailPagerAdapter extends PagerAdapter {

    Context context;
    //int[] images;
    int[] letters;
    int[] examples;
    String[] texts;
    LayoutInflater inflater;

    public DetailPagerAdapter(Context context, int[] letters, int[] examples, String[] texts) {
        this.context = context;
        this.letters = letters;
        this.examples = examples;
        this.texts = texts;
    }

    @Override
    public int getCount() {
        return letters.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //return super.instantiateItem(container, position);
        ImageView imageLetter;
        ImageView imageExample;
        TextView textView;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.pager_item, container, false);

        imageLetter = itemView.findViewById(R.id.image_letter);
        imageExample = itemView.findViewById(R.id.image_example);
        textView = itemView.findViewById(R.id.textView);

        imageLetter.setImageResource(letters[position]);
        imageExample.setImageResource(examples[position]);
        textView.setText(texts[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((ConstraintLayout) object);
    }
}
