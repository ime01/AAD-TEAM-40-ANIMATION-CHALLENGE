package com.flowz.kidsplayground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.flowz.kidsplayground.R
import com.flowz.kidsplayground.adapter.AlphabetRecyclerAdapter
import com.flowz.kidsplayground.repository.DataManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private val listLayoutManager by lazy {
        LinearLayoutManager(this)
    }

    private val alphabetRecyclerAdapter by lazy {
        AlphabetRecyclerAdapter(this, DataManager.alphabet)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        displayAlphabet()
    }

    private fun displayAlphabet() {

        listItems.layoutManager = listLayoutManager
        listItems.adapter = alphabetRecyclerAdapter

    }
}
