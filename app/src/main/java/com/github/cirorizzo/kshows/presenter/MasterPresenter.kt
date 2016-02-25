package com.github.cirorizzo.kshows.presenter

import com.github.cirorizzo.kshows.view.ImagesAdapter
import com.github.cirorizzo.kshows.view.MainActivityInterface


interface MasterPresenter {
    fun connect(mainActivityInterface: MainActivityInterface, imagesAdapter: ImagesAdapter)
    fun getMasterRequest()
}