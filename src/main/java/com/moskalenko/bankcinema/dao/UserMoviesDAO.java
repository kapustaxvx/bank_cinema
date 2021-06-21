package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.api.entity.UserMovies;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserMoviesDAO {
    public void addToUserMoviesList(Long userId, Long movieId) {
    }

    public void deleteFromUserMoviesList(Long userId, Long movieId) {
    }

    public void rateTheMovie(Long userId, Long movieId, Integer rate) {
    }

    public void updateMovieViewInfo(Long userId, Long movieId) {
    }

    public Collection<Movie> getAllMoviesFromUserMoviesList() {
        return null;
    }

    public Collection<Movie> getAllUnseenMoviesFromUserMoviesList() {
        return null;
    }

    public Collection<UserMovies> getMoviesWithRate() {
        return null;
    }
}
