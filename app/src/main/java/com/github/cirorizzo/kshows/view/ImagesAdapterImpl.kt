package com.github.cirorizzo.kshows.view

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.cirorizzo.kshows.R
import com.github.cirorizzo.kshows.model.cats.Cats
import kotlinx.android.synthetic.main.row_card_view.view.*
import rx.Observable
import rx.Subscriber


class ImagesAdapterImpl : RecyclerView.Adapter<ImagesAdapterImpl.ImagesURLsDataHolder>(), ImagesAdapter {
    private val TAG = ImagesAdapterImpl::class.java.simpleName

    private var cats: Cats? = null
    private val subscriber: Subscriber<Cats> by lazy { getSubscribe() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesURLsDataHolder {
        return ImagesURLsDataHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_card_view, parent, false))
    }

    override fun getItemCount(): Int {
        return cats?.data?.images?.size ?: 0
    }

    override fun onBindViewHolder(holder: ImagesURLsDataHolder, position: Int) {
        holder.bindImages(cats?.data?.images?.get(position)?.url ?: "")
    }

    private fun setData(cats: Cats?) {
        this.cats = cats
    }

    override fun setObservable(observableCats: Observable<Cats>) {
        observableCats.subscribe(subscriber)
    }

    override fun unsubscribe() {
        if (!subscriber.isUnsubscribed) {
            subscriber.unsubscribe()
        }
    }

    private fun getSubscribe(): Subscriber<Cats> {
        return object : Subscriber<Cats>() {
            override fun onCompleted() {
                Log.d(TAG, "onCompleted")
                notifyDataSetChanged()
            }

            override fun onNext(cats: Cats) {
                Log.d(TAG, "onNextNew")
                setData(cats)
            }

            override fun onError(e: Throwable) {
                //TODO : Handle error here
                Log.d(TAG, "" + e.message)
            }
        }
    }

    class ImagesURLsDataHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindImages(imgURL: String) {
            Glide.with(itemView.context).
                    load(imgURL).
                    placeholder(R.mipmap.document_image_cancel).
                    diskCacheStrategy(DiskCacheStrategy.ALL).
                    centerCrop().
                    into(itemView.imgVw_cat)
        }

    }

}