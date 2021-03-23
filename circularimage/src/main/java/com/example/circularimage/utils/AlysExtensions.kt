package com.example.circularimage.utils

import android.content.Context
import android.util.TypedValue
import android.view.View

fun convertDpToPixelFloat(dp: Float, context: Context): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        context.resources.displayMetrics
    )
}

fun convertDpToPixel(dp: Float, context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        context.resources.displayMetrics
    )
        .toInt()
}

fun View.setHeight(value: Int) {
    layoutParams?.let {
        layoutParams = it.apply { height = value }
    }
}

fun View.setWidth(value: Int) {
    layoutParams?.let {
        layoutParams = it.apply { width = value }
    }
}