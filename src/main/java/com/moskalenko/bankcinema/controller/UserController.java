package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.client.UserClient;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.service.UserMoviesService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController implements UserClient {


    private final UserMoviesService userMoviesService;

    public UserController(UserMoviesService userMoviesService) {
        this.userMoviesService = userMoviesService;
    }


    @Override
    @PostMapping("/{userId}/add/{movieId}")
    public void addToUserMoviesList(@PathVariable Long userId,@PathVariable Long movieId) {
        userMoviesService.addToUserMoviesList(userId, movieId);
    }

    @Override
    @DeleteMapping ("/{userId}/delete/{movieId}")
    public void deleteFromUserMoviesList(@PathVariable Long userId,@PathVariable Long movieId) {
        userMoviesService.deleteFromUserMoviesList(userId, movieId);
    }

    @Override
    @PutMapping("/{userId}/movies/{movieId}/rate/{rate}")
    public void rateTheMovie(@PathVariable Long userId,
                             @PathVariable Long movieId,
                             @PathVariable Integer rate) {
        userMoviesService.rateTheMovie(userId, movieId, rate);

    }

    @Override
    @PutMapping("/{userId}/view/{movieId}")
    public void updateMovieViewInfo(@PathVariable Long userId,@PathVariable Long movieId) {
        userMoviesService.updateMovieViewInfo(userId, movieId);
    }


    @Override
    @GetMapping("/{userId}/all")
    public Collection<Movie> getAllMoviesFromUserMoviesList(@PathVariable Long userId) {
        return userMoviesService.getAllMoviesFromUserMoviesList(userId);
    }

    @Override
    @GetMapping("/{userId}/unseen")
    public Collection<Movie> getAllUnseenMoviesFromUserMoviesList(@PathVariable Long userId) {
        return userMoviesService.getAllUnseenMoviesFromUserMoviesList(userId);
    }
}
