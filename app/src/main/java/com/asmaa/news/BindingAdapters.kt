package com.asmaa.news

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageURL")
fun loadingImageFromUrl( imageView:ImageView? , Url:String ){


    if (imageView!= null) {
        Glide.with(imageView)
            .load(Url)
            .placeholder(R.drawable.animation_progressbar)
            .error(R.drawable.animation_progressbar)
            .into(imageView)
    }

}
