package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.DTO.UserDTO;
import com.moskalenko.bankcinema.api.client.UserClient;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.api.entity.User;
import com.moskalenko.bankcinema.kafka.ProducerService;
import com.moskalenko.bankcinema.service.UserMoviesService;
import com.moskalenko.bankcinema.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController implements UserClient {

    private final UserMoviesService userMoviesService;
    private final ProducerService producerService;
    private final UserService userService;

    public UserController(UserMoviesService userMoviesService, ProducerService producerService,
                          UserService userService) {
        this.userMoviesService = userMoviesService;
        this.producerService = producerService;
        this.userService = userService;
    }

    @Override
    @PostMapping
    public User addUser(@RequestBody UserDTO userData) {
        producerService.produce(userData);
        return userService.addUser(userData);
    }

    @Override
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @Override
    @GetMapping
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @Override
    @PostMapping("/{userId}/add/{movieId}")
    public void addToUserMoviesList(@PathVariable Long userId, @PathVariable Long movieId) {
        userMoviesService.addToUserMoviesList(userId, movieId);
    }

    @Override
    @DeleteMapping("/{userId}/delete/{movieId}")
    public void deleteFromUserMoviesList(@PathVariable Long userId, @PathVariable Long movieId) {
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
    public void updateMovieViewInfo(@PathVariable Long userId, @PathVariable Long movieId) {
        userMoviesService.updateMovieViewInfoToWatched(userId, movieId);
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
