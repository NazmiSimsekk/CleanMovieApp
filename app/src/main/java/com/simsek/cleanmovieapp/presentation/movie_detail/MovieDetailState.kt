package com.simsek.cleanmovieapp.presentation.movie_detail

import com.simsek.cleanmovieapp.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = ""
)