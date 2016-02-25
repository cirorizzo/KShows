package com.github.cirorizzo.kshows.view

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.cirorizzo.kshows.R
import kotlinx.android.synthetic.main.row_card_view.view.*


class ImagesURLsDataHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val TAG = ImagesURLsDataHolder::class.java.simpleName

    fun bindImages(imgURL: String) {
        Log.d(TAG, "URL: $imgURL")
        Glide.with(itemView.context).
                load(imgURL).
                placeholder(R.mipmap.document_image_cancel).
                diskCacheStrategy(DiskCacheStrategy.ALL).
                fitCenter().
                into(itemView.imgVw_cat)
    }
}