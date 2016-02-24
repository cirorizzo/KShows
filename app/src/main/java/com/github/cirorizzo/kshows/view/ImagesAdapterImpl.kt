package com.github.cirorizzo.kshows.view

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.cirorizzo.kshows.R
import com.github.cirorizzo.kshows.model.cats.Cats
import rx.Observable
import rx.Subscriber


class ImagesAdapterImpl : RecyclerView.Adapter<ImagesURLsDataHolder>(), ImagesAdapter {
    private val TAG = ImagesAdapterImpl::class.java.simpleName

    private var cats: Cats? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesURLsDataHolder? {
        return ImagesURLsDataHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.row_card_view, parent, false))
    }

    override fun getItemCount(): Int {
        return this.cats?.data?.images?.size ?: 0
    }

    override fun onBindViewHolder(holder: ImagesURLsDataHolder, position: Int) {
        holder?.bindImages(cats?.data?.images?.get(position)?.url ?: "")
    }

    override fun setData(cats: Cats?) {
        this.cats = cats
    }

    override fun setObservable(observableCats: Observable<Cats>) {
        observableCats.subscribe(object : Subscriber<Cats>() {
            override fun onNext(cats: Cats?) {
                Log.d(TAG, "onNextNew")
                cats?.data?.images?.forEach { Log.d(TAG, it.url) }
            }

            override fun onCompleted() {
                Log.d(TAG, "onCompleted")
                notifyDataSetChanged()
            }

            override fun onError(e: Throwable?) {
                //TODO : Handle error here
                Log.d(TAG, "" + e?.message)
            }
        })
    }


}