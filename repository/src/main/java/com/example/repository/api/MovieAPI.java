package com.example.repository.api;

import com.example.repository.model.MovieResultsDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {

    @GET("/3/movie/popular")
    Observable<MovieResultsDTO> getMovies(@Query("api_key") String apiKey);
}
