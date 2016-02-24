package com.github.cirorizzo.kshows.network

import com.github.cirorizzo.kshows.model.cats.Cats
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class CatAPINetwork {
    val TAG = CatAPINetwork::class.java.simpleName

    fun getExec(): Observable<Cats> {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://thecatapi.com")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        val catAPI: CatAPI = retrofit.create(CatAPI::class.java)

        /*
        catAPI.getCatImageURLs().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(object : Subscriber<Cats>() {
                    override fun onNext(cats: Cats?) {
                        Log.d(TAG, "onNext")
                        cats?.data?.images?.forEach { Log.d(TAG, it.url) }
                    }

                    override fun onCompleted() {
                        Log.d(TAG, "onCompleted")
                    }

                    override fun onError(e: Throwable?) {
                        //TODO : Handle error here
                        Log.d(TAG, "" + e?.message)
                    }
                })

        */

        return catAPI.getCatImageURLs().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread())
    }
}