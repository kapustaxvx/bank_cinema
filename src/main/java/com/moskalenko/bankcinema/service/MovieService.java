package com.moskalenko.bankcinema.service;

import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.entity.Director;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.dao.MovieDAO;
import com.moskalenko.bankcinema.kafka.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class MovieService {
    private final static Logger log = LoggerFactory.getLogger(MovieService.class);
    private final MovieDAO movieDAO;
    private final DirectorService directorService;
    private final ProducerService producerService;

    public MovieService(MovieDAO movieDAO, DirectorService directorService,
                        ProducerService producerService) {
        this.movieDAO = movieDAO;
        this.directorService = directorService;
        this.producerService = producerService;
    }

    @Transactional
    public Movie addMovie(MovieDTO movieData) {
        final Director director = directorService.getDirectorById(movieData.getDirectorId());
        final Movie movie = new Movie(movieData.getTitle(), movieData.getDescription(),
                movieData.getGenre(), movieData.getRating(), movieData.getFees());
        movie.setDirector(director);
        movieDAO.save(movie);
        log.info("[{}] Movie added", movie.getId());
        producerService.produce(new MovieDTO(movie));
        return movie;
    }

    public Movie getMovieById(Long movieId){
        final Movie movie = movieDAO.getMovieById(movieId).orElse(null);
        if (movie == null){
            log.info("[{}] Movie is not found", movieId);
            throw new RuntimeException("Movie is not found");
        }
        log.info("Return [{}] movie", movieId);
        return movie;
    }

    public Collection<Movie> getAllMovies() {
        final Collection<Movie> movies = (Collection<Movie>) movieDAO.findAll();
        if (movies.isEmpty()) {
            log.info("Movie's list is empty");
            throw new RuntimeException("List is empty");
        }
        log.info("Return all movies");
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
        producerService.produce(new MovieDTO(movie));
        log.info("[{}] Movie's rating is update to [{}]", movieId, rating);
    }
}
