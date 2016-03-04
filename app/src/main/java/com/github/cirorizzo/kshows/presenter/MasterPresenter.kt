package com.github.cirorizzo.kshows.presenter

import com.github.cirorizzo.kshows.view.ImagesAdapter


interface MasterPresenter {
    fun connect(imagesAdapter: ImagesAdapter)
    fun getMasterRequest()
}