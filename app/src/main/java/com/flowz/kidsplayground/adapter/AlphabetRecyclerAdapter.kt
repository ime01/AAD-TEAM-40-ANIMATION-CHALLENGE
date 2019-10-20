package com.flowz.kidsplayground.adapter

import android.content.Context
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flowz.kidsplayground.R
import com.flowz.kidsplayground.repository.AlphabetData
import kotlinx.android.synthetic.main.item_alphabet_list.*
import android.R.attr.start
import android.animation.ObjectAnimator
import android.animation.AnimatorSet
import android.graphics.Color
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import android.animation.ValueAnimator


class AlphabetRecyclerAdapter(private val context: Context, private val list: ArrayList<AlphabetData>) :
        RecyclerView.Adapter<AlphabetRecyclerAdapter.ViewHolder>(),RandomAccess {


    var DURATION: Long = 500
    private val on_attach = true
    var lastPosition=-1
    private var rotateAnimator: ObjectAnimator? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alphabetData:AlphabetData = list[position]
        val random= java.util.Random()
        val currentColor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        holder.pos=position
        holder.bind(alphabetData)
        holder.layout?.setBackgroundColor(currentColor)

        // holder.thumbnailPosition=position
       slideEffect(holder.layout!!,position)
        setAnimation(holder.layout!!,position)
        setFlipAnimation(holder.layout!!,position)
    }





    fun slideEffect(view: ViewGroup, i:Int) {

        val transition = Slide(Gravity.END)
        TransitionManager.beginDelayedTransition(view, transition)


    }

    fun setFlipAnimation(view: ViewGroup, i: Int){
        if (i > lastPosition) {
            rotateAnimator = ObjectAnimator.ofFloat(view, "rotation", 0.0f, -180.0f)
            rotateAnimator?.apply {
                duration = 1000
                repeatCount = 1
                repeatMode = ValueAnimator.REVERSE
                start()
            }
            lastPosition =i
        }
    }



    private fun setAnimation(itemView: View, i: Int) {
        var i = i
        if (!on_attach) {
            i = -1
        }
        val isNotFirstItem = i == -1
        i++
        itemView.alpha = 0f
        val animatorSet = AnimatorSet()
        val animator = ObjectAnimator.ofFloat(itemView, "alpha", 0f, 0.5f, 1.0f)
        ObjectAnimator.ofFloat(itemView, "alpha", 0f).start()



        animator.startDelay = if (isNotFirstItem) DURATION / 2 else i * DURATION / 3
        animator.duration = 500
        animatorSet.play(animator)
        animator.start()
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater,parent)
    }
    override fun getItemCount() = list.size

   /* override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    *//*    val note = notes[position]
        holder.textCourse?.text = note.course?.title
        holder.textTitle?.text = note.title
        holder.notePosition = position*//*
    }*/

    inner class ViewHolder(inflater: LayoutInflater?, parent: ViewGroup) : RecyclerView.ViewHolder
    (inflater?.inflate(com.flowz.kidsplayground.R.layout.item_alphabet_list, parent, false)!!) {
        private var mletter: TextView? = null
        var layout:ViewGroup?=null
        var pos=0

        init {
            mletter = itemView.findViewById(com.flowz.kidsplayground.R.id.capitalLetter)
            layout=itemView.findViewById(com.flowz.kidsplayground.R.id.screenRoot)

        }

        fun bind(alphabetData: AlphabetData) {
            mletter?.text = alphabetData.letter

            itemView?.setOnClickListener {
                setAnimation(itemView,position)

            }
        }

    }
}