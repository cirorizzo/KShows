package com.github.cirorizzo.kshows.network

import com.github.cirorizzo.kshows.BuildConfig
import com.github.cirorizzo.kshows.model.cats.Cats
import retrofit2.http.GET
import rx.Observable


interface CatAPI {
    @GET("/api/images/get?format=xml&results_per_page=" + BuildConfig.MAX_IMAGES_PER_REQUEST)
    fun getCatImageURLs(): Observable<Cats>
}