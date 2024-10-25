package com.simsek.cleanmovieapp.presentation.movies

import com.simsek.cleanmovieapp.domain.model.Movie

data class MoviesState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "Batman"
)