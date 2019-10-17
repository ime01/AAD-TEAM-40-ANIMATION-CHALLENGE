package com.flowz.kidsplayground.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flowz.kidsplayground.R
import com.flowz.kidsplayground.repository.AlphabetData

class AlphabetRecyclerAdapter(private val context: Context, private val list: ArrayList<AlphabetData>) :
        RecyclerView.Adapter<AlphabetRecyclerAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alphabetData:AlphabetData = list[position]
        holder.bind(alphabetData)
       // holder.thumbnailPosition=position

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
    (inflater?.inflate(R.layout.item_alphabet_list, parent, false)!!) {
        private var mletter: TextView? = null


        init {
            mletter = itemView.findViewById(R.id.capitalLetter)


        }

        fun bind(alphabetData: AlphabetData) {
            mletter?.text = alphabetData.letter
            itemView?.setOnClickListener {

            }
        }

    }
}