package com.flowz.kidsplayground.repository

import android.util.Log

object DataManager {
    val alphabet = ArrayList<AlphabetData>()

    init {
        alphabeticalLetter()
    }


    private fun alphabeticalLetter() {
        var letter:String
        var c = 'A'
        while (c <= 'Z') {
            letter = c.toString()
            Log.e("letters",letter)
           val letters =AlphabetData(letter)
            alphabet.add(letters)
            ++c

        }
    }

}