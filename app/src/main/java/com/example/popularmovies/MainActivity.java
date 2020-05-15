package com.example.popularmovies;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.popularmovies.adapter.MovieAdapter;
import com.example.popularmovies.databinding.ActivityMainBinding;
import com.example.repository.impl.MovieRepositoryImpl;
import com.example.repository.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getMovieList();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = binding.movieListRecyclerView;
        adapter = new MovieAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void getMovieList() {
        MovieRepositoryImpl.getMovieRepository()
                .getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        movieList -> {
                            Log.e("OnSuccess", movieList.toString());
                            updateImage(movieList.getMovieList().get(0));
                            adapter.update(movieList.getMovieList());
                        },
                        e -> Log.e("Exception", e.toString())
                );
    }

    private void updateImage(Movie movie) {
        Picasso.get()
                .load(movie.getPosterPath())
                .into(binding.expandedMovieItem.expandedMoviePoster);

        binding.expandedMovieItem.expandedMovieSynopsis.setText(movie.getOverview());
        binding.expandedMovieItem.expandedMovieTitle.setText(movie.getTitle());
    }
}