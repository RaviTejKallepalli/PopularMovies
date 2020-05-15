package com.example.repository.impl;

import com.example.repository.MovieRepository;
import com.example.repository.api.MovieAPI;
import com.example.repository.converters.impl.MovieConverter;
import com.example.repository.model.MovieList;
import com.example.repository.network.NetworkUtils;

import io.reactivex.Single;
import retrofit2.Retrofit;

import static com.example.repository.utils.Constants.MOVIE_TMDB_API;

public class MovieRepositoryImpl implements MovieRepository {

    private Retrofit retrofit;
    private MovieAPI movieAPI;
    private static MovieRepositoryImpl movieRepository;

    private MovieRepositoryImpl() {
        init();
    }

    public static MovieRepository getMovieRepository() {
        if (movieRepository == null) {
            movieRepository = new MovieRepositoryImpl();
        }
        return movieRepository;
    }

    private void init() {
        retrofit = NetworkUtils.getInstance().getRetrofit();
        movieAPI = retrofit.create(MovieAPI.class);
    }

    @Override
    public Single<MovieList> getMovies() {
        return movieAPI.getMovies(MOVIE_TMDB_API)
                .map(movieResultsDTO -> new MovieConverter().convert(movieResultsDTO))
                .singleOrError();
    }
}
