package com.simsek.cleanmovieapp.data.remote

import com.simsek.cleanmovieapp.data.remote.dto.MovieDetailDto
import com.simsek.cleanmovieapp.data.remote.dto.MoviesDto
import com.simsek.cleanmovieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey: String = API_KEY
    ): MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String = API_KEY
    ): MovieDetailDto
}