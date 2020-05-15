package com.example.repository.converters.impl;

import com.example.repository.converters.Converter;
import com.example.repository.model.Movie;
import com.example.repository.model.MovieDTO;
import com.example.repository.model.MovieList;
import com.example.repository.model.MovieResultsDTO;

import java.util.ArrayList;
import java.util.List;

public class MovieConverter implements Converter<MovieResultsDTO, MovieList> {

    @Override
    public MovieList convert(MovieResultsDTO input) {
        List<Movie> movieList = new ArrayList<>();

        for (MovieDTO movie : input.getResults()) {
            Movie temp = new Movie.MovieBuilder()
                    .BackdropPath(movie.getBackdropPath())
                    .GenereIds(movie.getGenereIds())
                    .OriginalLanguage(movie.getOriginalLanguage())
                    .OriginalTitle(movie.getOriginalTitle())
                    .Overview(movie.getOverview())
                    .PosterPath(movie.getPosterPath())
                    .ReleaseDate(movie.getReleaseDate())
                    .Title(movie.getTitle())
                    .VoteCount(movie.getVoteCount())
                    .build();

            movieList.add(temp);
        }

        return new MovieList(movieList);
    }
}
