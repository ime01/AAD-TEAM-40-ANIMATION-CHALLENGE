package com.flowz.kidsplayground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerAdapter adapter;
    //ArrayList<Integer> images;
    int[] letters;
    int[] examples;
    String[] texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        letters = new int[] { R.drawable.letter_a, R.drawable.letter_b, R.drawable.letter_c,
                R.drawable.letter_d, R.drawable.letter_e, R.drawable.letter_f, R.drawable.letter_g,
                R.drawable.letter_h, R.drawable.letter_i, R.drawable.letter_j, R.drawable.letter_k,
                R.drawable.letter_l, R.drawable.letter_m, R.drawable.letter_n, R.drawable.letter_o,
                R.drawable.letter_p, R.drawable.letter_q, R.drawable.letter_r, R.drawable.letter_s,
                R.drawable.letter_t, R.drawable.letter_u, R.drawable.letter_v, R.drawable.letter_w,
                R.drawable.letter_x, R.drawable.letter_y, R.drawable.letter_z};

        examples = new int[] { R.drawable.apple, R.drawable.ball, R.drawable.cake,
                R.drawable.duck, R.drawable.elephant, R.drawable.frog, R.drawable.grape, R.drawable.hen,
                R.drawable.ice_cream, R.drawable.jacket, R.drawable.kangaroo, R.drawable.ladder,
                R.drawable.monocycle, R.drawable.nurse, R.drawable.orange, R.drawable.parrot,
                R.drawable.quail, R.drawable.rainbow, R.drawable.socks, R.drawable.tent,
                R.drawable.umbrella, R.drawable.vase, R.drawable.well, R.drawable.xylophone,
                R.drawable.yam, R.drawable.zebra};

        texts = new String[] {"Apple", "Ball", "Cake", "Duck", "Elephant", "Frog", "Grape", "Hen", "Ice Cream",
                "Jacket", "Kangaroo", "Ladder", "Monocycle", "Nurse", "Orange", "Parrot", "Quail", "Rainbow",
                "Socks", "Tent", "Umbrella", "Vase", "Well", "Xylophone", "Yam", "Zebra"};

        viewPager = findViewById(R.id.pager);
        // Initialize our PagerAdapter
        adapter = new DetailPagerAdapter(this, letters, examples, texts);
        // Bind the PagerAdapter to the ViewPager
        viewPager.setAdapter(adapter);
        setPageTransformer(new pagerTransformation());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_next) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setPageTransformer(ViewPager.PageTransformer transformer){
        viewPager.setPageTransformer(true, transformer);
    }
}

