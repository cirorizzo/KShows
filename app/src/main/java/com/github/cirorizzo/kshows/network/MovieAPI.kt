package com.github.cirorizzo.kshows.network

import com.github.cirorizzo.kshows.model.movies.Movies
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable


interface MovieAPI {
    //https://api-v2launch.trakt.tv/search?query={query}&type=type&year={year}

//    @Headers({"Content-Type:application/json", "trakt-api-version:2", "trakt-api-key:861c13c594170a99fade50b28b7e142791b28338b88d46aa9a95873224fe05ec"})
    @GET("/search?query=batman&type=type&year=2015")
    fun getMovies (@Query("query") query: String, @Query("year") year: Int): Observable<Movies>
}