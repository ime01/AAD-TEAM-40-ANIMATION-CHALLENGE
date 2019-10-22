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
import android.widget.ImageView
import android.content.Intent


class AlphabetRecyclerAdapter(private val context: Context, private val list: ArrayList<AlphabetData>) :
        RecyclerView.Adapter<AlphabetRecyclerAdapter.ViewHolder>(),RandomAccess {


    var DURATION: Long = 500
    private val on_attach = true
    var lastPosition=-1
    private var rotateAnimator: ObjectAnimator? = null
    private var scaleAnimator: ObjectAnimator? = null
    private var translateAnimator: ObjectAnimator? = null


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alphabetData:AlphabetData = list[position]
        val random= java.util.Random()
        val currentColor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        holder.pos=position
        holder.bind(alphabetData)
        holder.layout?.setBackgroundColor(currentColor)

        setFlipAnimation(holder.layout!!,position)
    }




    fun setFlipAnimation(view: ViewGroup, i: Int){
        if (i > lastPosition) {
           scaleAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 3.0f,1.0f)
            translateAnimator = ObjectAnimator.ofFloat(view, "translationX", 0f, 300f,0f)
            rotateAnimator = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f)
            AnimatorSet().apply {
                play(rotateAnimator).before(translateAnimator).with(scaleAnimator)
                duration = 500
                start()

            }
            lastPosition =i

            /*rotateAnimator?.apply {
                duration = 500
                repeatCount = 1
                repeatMode = ValueAnimator.REVERSE
               start()
            }*/
        }
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
        private var mImage: ImageView? = null
        var layout:ViewGroup?=null
        var pos=0

        init {
            mImage = itemView.findViewById(com.flowz.kidsplayground.R.id.capitalLetter)
            layout=itemView.findViewById(com.flowz.kidsplayground.R.id.screenRoot)

        }

        fun bind(alphabetData: AlphabetData) {
            mImage?.setImageResource(alphabetData.letter!!) //= alphabetData.image

            itemView?.setOnClickListener {
           /*     val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("KEY", pos)
                context.startActivity(intent)*/
            }
        }

    }
}