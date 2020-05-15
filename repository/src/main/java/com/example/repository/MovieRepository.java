package com.example.repository;

import com.example.repository.model.MovieList;

import io.reactivex.Single;

public interface MovieRepository {

    Single<MovieList> getMovies();
}