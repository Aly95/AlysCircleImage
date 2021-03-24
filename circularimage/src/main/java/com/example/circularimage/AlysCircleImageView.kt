package com.example.circularimage

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import com.example.circularimage.utils.convertDpToPixel
import com.example.circularimage.utils.convertDpToPixelFloat
import com.example.circularimage.utils.setHeight
import com.example.circularimage.utils.setWidth
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso

class AlysCircleImageView : MaterialCardView {

    private val cardView: MaterialCardView
    private val imageView: ImageView

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        View.inflate(context, R.layout.view_circle_image, this)
        cardView = findViewById(R.id.circle_card_view)
        imageView = findViewById(R.id.circle_image)
    }

    private fun init(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AlysCircleImageView)
        val circleRadius = typedArray.getFloat(R.styleable.AlysCircleImageView_default_radius, 0f)
        radius = convertDpToPixelFloat(circleRadius, context)
        typedArray.recycle()
    }

    fun showImage(image: Int, size: Float) {
        updateImageFormatting(size)

        Picasso.with(context)
            .load(image)
            .fit()
            .centerCrop()
            .into(imageView)
    }

    fun showImage(image: String, size: Float) {
        updateImageFormatting(size)

        Picasso.with(context)
                .load(image)
                .fit()
                .centerCrop()
                .into(imageView)
    }

    fun addStroke(colour: Int = Color.WHITE, size: Float = 2f) {
        strokeColor = colour
        strokeWidth = convertDpToPixel(size, context)
    }


    private fun updateImageFormatting(size: Float) {
        val sizeInPixels = convertDpToPixel(size, context)
        addRadius(sizeInPixels)
        applyImageViewSizes(sizeInPixels)
    }

    private fun applyImageViewSizes(sizeInPixels: Int) {
        imageView.apply {
            setHeight(sizeInPixels)
            setWidth(sizeInPixels)
        }
    }

    private fun addRadius(sizeInPixels: Int) {
        radius = sizeInPixels / 2f
    }
}