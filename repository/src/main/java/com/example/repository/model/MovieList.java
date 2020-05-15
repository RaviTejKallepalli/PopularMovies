package com.example.repository.model;

import java.util.List;

public class MovieList {

    private List<Movie> movieList;

    public MovieList(List<Movie> movies) {
        this.movieList = movies;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
