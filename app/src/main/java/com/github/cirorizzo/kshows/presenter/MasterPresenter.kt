package com.github.cirorizzo.kshows.presenter

import com.github.cirorizzo.kshows.model.cats.Cats
import com.github.cirorizzo.kshows.view.ImagesAdapter
import com.github.cirorizzo.kshows.view.MainActivityInterface
import rx.Observable


interface MasterPresenter {
    fun connect(mainActivityInterface: MainActivityInterface, imagesAdapter: ImagesAdapter)
    fun getMasterRequest()
    fun getObservableMasterRequest(): Observable<Cats>
}