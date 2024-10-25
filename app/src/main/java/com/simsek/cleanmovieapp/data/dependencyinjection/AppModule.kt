package com.simsek.cleanmovieapp.data.dependencyinjection

import com.simsek.cleanmovieapp.data.remote.MovieAPI
import com.simsek.cleanmovieapp.data.repository.MovieRepositoryImpl
import com.simsek.cleanmovieapp.domain.repository.MovieRepository
import com.simsek.cleanmovieapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieRepository(api: MovieAPI): MovieRepository{
        return MovieRepositoryImpl(api)
    }
}