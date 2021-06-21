package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.client.MovieClient;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/movies")
public class MovieController implements MovieClient {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    @PostMapping
    public Movie addMovie(@RequestBody MovieDTO movieData) {
        return movieService.addMovie(movieData);
    }

    @Override
    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @Override
    @GetMapping
    public Collection<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
