package com.github.cirorizzo.kshows.view

import com.github.cirorizzo.kshows.model.cats.Cats
import rx.Observable


interface ImagesAdapter {
    fun setData(cats: Cats?)
    fun setObservable(observableCats: Observable<Cats>)
}