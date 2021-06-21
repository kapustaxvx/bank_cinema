package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.dao.MovieDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

@Service
public class MovieService {
    private final static Logger log = LoggerFactory.getLogger(MovieService.class);
    private final MovieDAO movieDAO;

    public MovieService(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Transactional
    public Movie addMovie(MovieDTO movieData) {
        final Movie movie = movieDAO.addMovie(movieData).orElse(null);
        if (movie == null){
            log.info("Movie was not added: "+ movieData.toString());
            throw new RuntimeException("Movie was not added");
        }
        log.info("[{}] Movie added", movie.getId());
        return movie;
    }

    public Movie getMovieById(Long movieId){
        final Movie movie = movieDAO.getMovieById(movieId).orElse(null);
        if (movie == null){
            log.info("[{}] Movie is not found", movieId);
            throw new RuntimeException("Movie is not found");
        }
        return movie;
    }

    public Collection<Movie> getAllMovies() {
        final Set<Movie> movies = movieDAO.getAllMovies();
        if (movies.isEmpty()) {
            log.info("Movie's list is empty");
            throw new RuntimeException("List is empty");
        }
        return movies;
    }

    @Transactional
    public void updateMovieRating(Long movieId, Double rating){
        movieDAO.updateMovieRating(movieId, rating);
    }
}
