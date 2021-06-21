package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.entity.Director;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.dao.DirectorDAO;
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
    private final DirectorDAO directorDAO;

    public MovieService(MovieDAO movieDAO, DirectorDAO directorDAO) {
        this.movieDAO = movieDAO;
        this.directorDAO = directorDAO;
    }

    @Transactional
    public Movie addMovie(MovieDTO movieData) {
        final Director director = directorDAO.getDirectorById(movieData.getDirectorId()).orElse(null);
        if (director == null){
            log.info("[{}] Director is not exist", movieData.getDirectorId());
            throw new RuntimeException("Director is not exist");
        }
        final Movie movie = new Movie(movieData.getTitle(), movieData.getDescription(),
                movieData.getGenre(), movieData.getRating(), movieData.getFees(), director);
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
        final Set<Movie> movies = (Set<Movie>) movieDAO.findAll();
        if (movies.isEmpty()) {
            log.info("Movie's list is empty");
            throw new RuntimeException("List is empty");
        }
        return movies;
    }

    @Transactional
    public void updateMovieRating(Long movieId, Double rating){
        final Movie movie = movieDAO.getMovieById(movieId).orElse(null);
        if (movie == null){
            log.info("[{}] Movie is not found", movieId);
            throw new RuntimeException("Movie is not found");
        }
        movie.setRating(rating);
        log.info("[{}] Movie's rating is update to [{}]", movieId, rating);
    }
}
