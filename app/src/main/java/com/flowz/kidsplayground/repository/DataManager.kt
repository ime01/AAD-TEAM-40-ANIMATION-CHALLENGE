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
        var d='a'
        while (c <= 'Z') {
            letter = "$c $d"
            Log.e("letters",letter)
           val letters =AlphabetData(letter)
            alphabet.add(letters)
            ++c
        }
    }

}