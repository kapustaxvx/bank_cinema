package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.beans.Actor;
import com.moskalenko.bankcinema.api.beans.Director;
import com.moskalenko.bankcinema.api.beans.Movie;
import com.moskalenko.bankcinema.api.client.UserClient;
import com.moskalenko.bankcinema.service.ActorService;
import com.moskalenko.bankcinema.service.DirectorService;
import com.moskalenko.bankcinema.service.MovieService;
import com.moskalenko.bankcinema.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController implements UserClient {


    private final UserService userService;
    private final DirectorService directorService;
    private final ActorService actorService;
    private final MovieService movieService;

    public UserController(UserService userService, DirectorService directorService,
                          ActorService actorService, MovieService movieService) {
        this.userService = userService;
        this.directorService = directorService;
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @Override
    @PostMapping("users/{userId}/add/{movieId}")
    public void addToUserMoviesList(@PathVariable Long userId,@PathVariable Long movieId) {
        userService.addToUserMoviesList(userId, movieId);
    }

    @Override
    @DeleteMapping ("users/{userId}/delete/{movieId}")
    public void deleteFromUserMoviesList(@PathVariable Long userId,@PathVariable Long movieId) {
        userService.deleteFromUserMoviesList(userId, movieId);
    }

    @Override
    @PutMapping("users/{userId}/movies/{movieId}/rate/{rate}")
    public void rateTheMovie(@PathVariable Long userId,
                             @PathVariable Long movieId,
                             @PathVariable Integer rate) {
        userService.rateTheMovie(userId, movieId, rate);

    }

    @Override
    @PutMapping("users/{userId}/view/{movieId}")
    public void updateMovieViewInfo(@PathVariable Long userId,@PathVariable Long movieId) {
        userService.updateMovieViewInfo(userId, movieId);
    }

    @Override
    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @Override
    @GetMapping("/directors/{directorId}")
    public Director getDirectorById(@PathVariable Long directorId) {
        return directorService.getDirectorById(directorId);
    }

    @Override
    @GetMapping("/actors/{actorId}")
    public Actor getActorById(@PathVariable Long actorId) {
        return actorService.getActorById(actorId);
    }

    @Override
    @GetMapping("users/{userId}/all")
    public Collection<Movie> getAllMoviesFromUserMoviesList(@PathVariable Long userId) {
        return userService.getAllMoviesFromUserMoviesList(userId);
    }

    @Override
    @GetMapping("users/{userId}/unseen")
    public Collection<Movie> getAllUnseenMoviesFromUserMoviesList(@PathVariable Long userId) {
        return userService.getAllUnseenMoviesFromUserMoviesList(userId);
    }


    @Override
    @GetMapping("/directors")
    public Collection<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @Override
    @GetMapping("/actors")
    public Collection<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @Override
    @GetMapping("/movies")
    public Collection<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
