package com.moskalenko.bankcinema.api.client;

import com.moskalenko.bankcinema.api.beans.Actor;
import com.moskalenko.bankcinema.api.beans.Director;
import com.moskalenko.bankcinema.api.beans.Movie;

import java.util.Collection;

public interface UserClient {
    void addToUserMoviesList(Long userId, Long movieId);

    void deleteFromUserMoviesList(Long userId, Long movieId);

    void rateTheMovie(Long userId, Long movieId, Integer rate);

    void updateMovieViewInfo(Long userId, Long movieId);

    Collection<Movie> getAllMoviesFromUserMoviesList(Long userId);

    Collection<Movie> getAllUnseenMoviesFromUserMoviesList(Long userId);

    Collection<Director> getAllDirectors();

    Collection<Actor> getAllActors();

    Collection<Movie> getAllMovies();
}
