package com.faire.faireshop.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.ViewTarget
import com.faire.faireshop.R

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun ImageView.loadImage(url: String): ViewTarget<ImageView, Drawable> {
    return Glide.with(this)
        .load(url)
        .placeholder(ContextCompat.getDrawable(context, R.drawable.image_loading))
        .error(ContextCompat.getDrawable(context, R.drawable.image_error))
        .into(this)
}
