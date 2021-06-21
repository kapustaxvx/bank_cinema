package com.moskalenko.bankcinema.dao;

import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class MovieDAO {
    public Optional<Movie> addMovie(MovieDTO movieData) {
        return Optional.empty();
    }

    public Optional<Movie> getMovieById(Long movieId) {
        return Optional.empty();
    }

    public Set<Movie> getAllMovies() {
        return null;
    }

    public void updateMovieRating(Long movieId, Double rating){
    }

}
