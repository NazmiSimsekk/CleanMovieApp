package com.simsek.cleanmovieapp.domain.repository

import com.simsek.cleanmovieapp.data.remote.dto.MovieDetailDto
import com.simsek.cleanmovieapp.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search: String): MoviesDto
    suspend fun getMovieDetail(imdbId: String): MovieDetailDto
}