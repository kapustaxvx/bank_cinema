package com.moskalenko.bankcinema.api.client;

import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.entity.Movie;

import java.util.Collection;

public interface MovieClient {
    Movie addMovie(MovieDTO movieData);

    Movie getMovieById(Long movieId);

    Collection<Movie> getAllMovies();
}
