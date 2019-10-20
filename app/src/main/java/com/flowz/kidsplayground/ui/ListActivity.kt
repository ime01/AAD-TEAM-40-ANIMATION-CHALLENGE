package com.flowz.kidsplayground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.flowz.kidsplayground.R
import com.flowz.kidsplayground.adapter.AlphabetRecyclerAdapter
import com.flowz.kidsplayground.repository.DataManager
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.FlipInBottomXAnimator
import jp.wasabeef.recyclerview.animators.OvershootInRightAnimator
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.item_alphabet_list.*

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
        listItems.adapter = ScaleInAnimationAdapter(alphabetRecyclerAdapter)

        listItems.itemAnimator=FlipInBottomXAnimator()
      //  listItems.itemAnimator = OvershootInRightAnimator()
        listItems.itemAnimator?.apply {
            addDuration = 1000   // duration of add operation
            removeDuration = 500// duration of delete operation
        }

    }

    fun slideEffect(view: View, i:Int) {

        val transition = Slide(Gravity.END)
        TransitionManager.beginDelayedTransition(screenRoot, transition)


    }
}
