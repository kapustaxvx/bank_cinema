package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.DTO.MovieDTO;
import com.moskalenko.bankcinema.api.client.MovieClient;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.service.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/movies")
public class MovieController implements MovieClient {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    @PostMapping
    @ApiOperation(value = "Add new movie")
    public Movie addMovie(@RequestBody MovieDTO movieData) {
        return movieService.addMovie(movieData);
    }

    @Override
    @GetMapping("/{movieId}")
    @ApiOperation(value = "Get movie by id")
    public Movie getMovieById(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @Override
    @GetMapping
    @ApiOperation(value = "Get list of all movies")
    public Collection<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
