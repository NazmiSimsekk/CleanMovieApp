package com.simsek.cleanmovieapp.domain.use_case.get_movies

import coil.network.HttpException
import com.simsek.cleanmovieapp.data.remote.dto.toMovieList
import com.simsek.cleanmovieapp.domain.model.Movie
import com.simsek.cleanmovieapp.domain.repository.MovieRepository
import com.simsek.cleanmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun  executeGetMovies(search: String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            //kullanıcı saçma sapan bir arama yaptığında Response false gelecek
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            }else{
                emit(Resource.Error("Movie not found"))
            }
        }catch (e: IOError){
            emit(Resource.Error("Mo internet connection"))
        }catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}