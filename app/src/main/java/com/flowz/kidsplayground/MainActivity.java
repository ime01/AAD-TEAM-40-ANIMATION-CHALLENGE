package com.flowz.kidsplayground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CardView cardView;
    TextView textView;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.cardView);
        textView = findViewById(R.id.textView2);
        relativeLayout = findViewById(R.id.relative);

        List<Alphabet> alphabetList = new ArrayList<>();


        Alphabet alphabet = new Alphabet("Aa");
        alphabetList.add(alphabet);
        Alphabet alphabet1 = new Alphabet("Bb");
        alphabetList.add(alphabet1);
        Alphabet alphabet2 = new Alphabet("Cc");
        alphabetList.add(alphabet2);
        Alphabet alphabet3 = new Alphabet("Dd");
        alphabetList.add(alphabet3);
        Alphabet alphabet4 = new Alphabet("Ee");
        alphabetList.add(alphabet4);
        Alphabet alphabet5 = new Alphabet("Ff");
        alphabetList.add(alphabet5);
        Alphabet alphabet6 = new Alphabet("Gg");
        alphabetList.add(alphabet6);
        Alphabet alphabet7 = new Alphabet("Hh");
        alphabetList.add(alphabet7);
        Alphabet alphabet8 = new Alphabet("Ii");
        alphabetList.add(alphabet8);
        Alphabet alphabet9 = new Alphabet("Jj");
        alphabetList.add(alphabet9);
        Alphabet alphabet10 = new Alphabet("Kk");
        alphabetList.add(alphabet10);
        Alphabet alphabet11 = new Alphabet("Ll");
        alphabetList.add(alphabet11);
        Alphabet alphabet12 = new Alphabet("Mm");
        alphabetList.add(alphabet12);
        Alphabet alphabet13 = new Alphabet("Nn");
        alphabetList.add(alphabet13);
        Alphabet alphabet14 = new Alphabet("Oo");
        alphabetList.add(alphabet14);
        Alphabet alphabet15 = new Alphabet("Pp");
        alphabetList.add(alphabet15);
        Alphabet alphabet16 = new Alphabet("Qq");
        alphabetList.add(alphabet16);
        Alphabet alphabet17 = new Alphabet("Rr");
        alphabetList.add(alphabet17);
        Alphabet alphabet18 = new Alphabet("Ss");
        alphabetList.add(alphabet18);
        Alphabet alphabet19 = new Alphabet("Tt");
        alphabetList.add(alphabet19);
        Alphabet alphabet20 = new Alphabet("Uu");
        alphabetList.add(alphabet20);
        Alphabet alphabet21 = new Alphabet("Vv");
        alphabetList.add(alphabet20);
        Alphabet alphabet22 = new Alphabet("Ww");
        alphabetList.add(alphabet22);
        Alphabet alphabet23 = new Alphabet("Xx");
        alphabetList.add(alphabet23);
        Alphabet alphabet24 = new Alphabet("Yy");
        alphabetList.add(alphabet24);
        Alphabet alphabet25 = new Alphabet("Zz");
        alphabetList.add(alphabet25);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        AlphabetAdapter peopleAdapter = new AlphabetAdapter(alphabetList, this);
        peopleAdapter.notifyDataSetChanged();

        recyclerView.setAdapter(peopleAdapter);

    }
}



