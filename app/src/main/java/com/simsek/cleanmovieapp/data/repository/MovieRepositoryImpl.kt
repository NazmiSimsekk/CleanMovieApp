package com.simsek.cleanmovieapp.data.repository

import com.simsek.cleanmovieapp.data.remote.MovieAPI
import com.simsek.cleanmovieapp.data.remote.dto.MovieDetailDto
import com.simsek.cleanmovieapp.data.remote.dto.MoviesDto
import com.simsek.cleanmovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl  @Inject constructor(private val api: MovieAPI): MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }
}