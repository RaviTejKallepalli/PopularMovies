package com.example.repository.model;

import com.example.repository.utils.Constants;

import java.util.List;

public class Movie {
    private String posterPath;
    private String overview;
    private String originalTitle;
    private String originalLanguage;
    private String title;
    private String backdropPath;
    private int voteCount;
    private List<Integer> genereIds;
    private String releaseDate;

    public String getPosterPath() {
        return Constants.IMAGE_URL + posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public List<Integer> getGenereIds() {
        return genereIds;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public static class MovieBuilder {

        private String posterPath;
        private String overview;
        private String originalTitle;
        private String originalLanguage;
        private String title;
        private String backdropPath;
        private int voteCount;
        private List<Integer> genereIds;
        private String releaseDate;

        public static MovieBuilder builder() {
            return new MovieBuilder();
        }

        public MovieBuilder PosterPath(String posterPath) {
            this.posterPath = posterPath;
            return this;
        }

        public MovieBuilder Overview(String overview) {
            this.overview = overview;
            return this;
        }

        public MovieBuilder OriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
            return this;
        }

        public MovieBuilder OriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
            return this;
        }

        public MovieBuilder Title(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder BackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
            return this;
        }

        public MovieBuilder VoteCount(int voteCount) {
            this.voteCount = voteCount;
            return this;
        }

        public MovieBuilder GenereIds(List<Integer> genereIds) {
            this.genereIds = genereIds;
            return this;
        }

        public MovieBuilder ReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Movie build() {
            Movie movie = new Movie();
            movie.posterPath = this.posterPath;
            movie.overview = this.overview;
            movie.originalTitle = this.originalTitle;
            movie.originalLanguage = this.originalLanguage;
            movie.title = this.title;
            movie.backdropPath = this.backdropPath;
            movie.voteCount = this.voteCount;
            movie.genereIds = this.genereIds;
            movie.releaseDate = this.releaseDate;
            return movie;
        }
    }
}
