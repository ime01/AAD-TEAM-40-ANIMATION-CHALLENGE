package com.flowz.kidsplayground.repository

import android.media.Image
import android.content.Context
import com.flowz.kidsplayground.R

object DataManager {
    val alphabet = ArrayList<AlphabetData>()

    init {
        alphabeticalImage()
    }


    private fun alphabeticalImage() {
        var image: Int
        image = R.drawable.letter_a //id.drawable.letter_a

        /* var c = 'A'
         var d='a'
         while (c <= 'Z') {
             letter = "$c $d"
             Log.e("letters",letter)
            val letters =AlphabetData(letter)
             alphabet.add(letters)
             ++c
         }*/
        image = R.drawable.letter_a
        var letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_b
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_c
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_d
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_e
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_f
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_h
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_i
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_j
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_k
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_l
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_m
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_n
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_o
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_p
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_q
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_q
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_r
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_s
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_t
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_u
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_v
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_w
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_x
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_y
        letters = AlphabetData(image)
        alphabet.add(letters)
        image = R.drawable.letter_z
        letters = AlphabetData(image)
        alphabet.add(letters)

    }

}