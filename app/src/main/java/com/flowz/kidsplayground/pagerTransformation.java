package com.flowz.kidsplayground;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class pagerTransformation implements ViewPager.PageTransformer {


    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setTranslationY(-position * page.getWidth());
        page.setCameraDistance(12000f);

        if (position < -1){
            page.setAlpha(0f);
        } else if (position <= 0){
            page.setAlpha(1f);
            page.setRotationY(180 * (1 - Math.abs(position) + 1));
        }else if (position <= 1){
            page.setAlpha(1f);
            page.setRotationY(-180 * (1 - Math.abs(position) + 1));
        }
        else page.setAlpha(0f);
        if (position < 0.5 && position > -0.5){
            page.setVisibility(View.VISIBLE);
        } else {
            page.setVisibility(View.INVISIBLE);
        }


    }
}

//
//        page.translationX = -position * page.width
//        page.cameraDistance = 12000f
//
//        if (position < 0.5 && position > -0.5) {
//        page.visibility = View.VISIBLE
//        } else {
//        page.visibility = View.INVISIBLE
//        }
//
//        when {
//        position < -1 -> // [-Infinity,-1)
//        // This page is way off-screen to the left.
//        page.alpha = 0f
//        position <= 0 -> {    // [-1,0]
//        page.alpha = 1f
//        page.rotationY = 180 * (1 - Math.abs(position) + 1)
//
//        }
//        position <= 1 -> {    // (0,1]
//        page.alpha = 1f
//        page.rotationY = -180 * (1 - Math.abs(position) + 1)
//
//        }
//        else -> // (1,+Infinity]
//        // This page is way off-screen to the right.
//        page.alpha = 0f
//        }
//        }
//        }