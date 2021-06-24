package com.moskalenko.bankcinema.controller;

import com.moskalenko.bankcinema.api.DTO.UserDTO;
import com.moskalenko.bankcinema.api.client.UserClient;
import com.moskalenko.bankcinema.api.entity.Movie;
import com.moskalenko.bankcinema.api.entity.User;
import com.moskalenko.bankcinema.kafka.ProducerService;
import com.moskalenko.bankcinema.service.UserMoviesService;
import com.moskalenko.bankcinema.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/users")
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
    @ApiOperation(value = "Add new user")
    public User addUser(@RequestBody UserDTO userData) {
        // producerService.produce(userData);
        return userService.addUser(userData);
    }

    @Override
    @GetMapping("/{userId}")
    @ApiOperation(value = "Get user by id")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @Override
    @GetMapping
    @ApiOperation(value = "Get list of all users")
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @PostMapping("/{userId}/add/{movieId}")
    @ApiOperation(value = "Add movie to user wishlist")
    public @ResponseBody
    String addToUserMoviesList(@PathVariable Long userId, @PathVariable Long movieId) {
        userMoviesService.addToUserMoviesList(userId, movieId);
        return "Movie added for user";
    }

    @Override
    @DeleteMapping("/{userId}/delete/{movieId}")
    @ApiOperation(value = "Delete movie from user wishlist")
    public @ResponseBody
    String deleteFromUserMoviesList(@PathVariable Long userId, @PathVariable Long movieId) {
        userMoviesService.deleteFromUserMoviesList(userId, movieId);
        return "Movie removed from user";
    }

    @Override
    @PutMapping("/{userId}/movies/{movieId}/rate/{rate}")
    @ApiOperation(value = "Rate movie by user")
    public @ResponseBody
    String rateTheMovie(@PathVariable Long userId,
                        @PathVariable Long movieId,
                        @PathVariable Integer rate) {
        userMoviesService.rateTheMovie(userId, movieId, rate);
        return "Movie rated by user";
    }

    @Override
    @PutMapping("/{userId}/view/{movieId}")
    @ApiOperation(value = "Mark movie like watched by user")
    public @ResponseBody
    String updateMovieViewInfo(@PathVariable Long userId, @PathVariable Long movieId) {
        userMoviesService.updateMovieViewInfoToWatched(userId, movieId);
        return "Movie updated by user";
    }

    @Override
    @GetMapping("/{userId}/all")
    @ApiOperation(value = "Get list of all user's movies")
    public Collection<Movie> getAllMoviesFromUserMoviesList(@PathVariable Long userId) {
        return userMoviesService.getAllMoviesFromUserMoviesList(userId);
    }

    @Override
    @GetMapping("/{userId}/unseen")
    @ApiOperation(value = "Get list of all unseen user's movies")
    public Collection<Movie> getAllUnseenMoviesFromUserMoviesList(@PathVariable Long userId) {
        return userMoviesService.getAllUnseenMoviesFromUserMoviesList(userId);
    }
}
