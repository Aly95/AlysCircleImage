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

//import com.squareup.picasso.Picasso

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
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.WPCircleView)
        val circleRadius = typedArray.getFloat(R.styleable.WPCircleView_default_radius, 0f)
        radius = convertDpToPixelFloat(circleRadius, context)
        typedArray.recycle()
    }

    fun showImage(image: Int, size: Float) {
        val sizeInPixels = convertDpToPixel(size, context)
        radius = sizeInPixels / 2f

        imageView.apply {
            setHeight(sizeInPixels)
            setWidth(sizeInPixels)
        }

//        imageView.setImageResource(image)
//        imageView.scaleType = ImageView.ScaleType.CENTER_CROP

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

}