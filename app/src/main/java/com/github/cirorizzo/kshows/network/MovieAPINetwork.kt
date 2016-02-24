package com.github.cirorizzo.kshows.network

import com.github.cirorizzo.kshows.model.movies.Movies
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory.create
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers.io

class MovieAPINetwork {


    fun getMovieRequest() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api-v2launch.trakt.tv")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(create())
                .build()

        val movieAPI: MovieAPI = retrofit.create(MovieAPI::class.java)

        val call: Observable<Movies> = movieAPI.getMovies("batman", 2015)

        val subscription: Subscription = call.
                subscribeOn(io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(object : Subscriber<Movies>() {
                    override fun onNext(p0: Movies?) {
                        throw UnsupportedOperationException()
                    }

                    override fun onCompleted() {
                        //Completed
                    }

                    override fun onError(e: Throwable?) {
                        //TODO : Handle error here
                    }
                })
    }
}



